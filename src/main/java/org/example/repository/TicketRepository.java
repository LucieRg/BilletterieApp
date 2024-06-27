package org.example.repository;

import org.example.entity.Client;
import org.example.entity.Event;
import org.example.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

public class TicketRepository {
    private final EntityManager em;

    public TicketRepository(EntityManager em) {
        this.em = em;
    }

    public void addTicket(Ticket ticket) {
        em.getTransaction().begin();

        Client client = ticket.getClient();
        Event event = ticket.getEvent();


        if (client != null && !em.contains(client)) {
            client = em.merge(client);
        }


        if (event != null && !em.contains(event)) {
            event = em.merge(event);
        }


        ticket.setClient(client);
        ticket.setEvent(event);


        em.persist(ticket);

        em.getTransaction().commit();
    }


    public void updateTicket(int id) {
        em.getTransaction().begin();
        Ticket ticket = em.find(Ticket.class, id);
        if (ticket != null) {
            em.merge(ticket);
        }
        em.getTransaction().commit();
    }

    public void deleteTicket(int id) {
        em.getTransaction().begin();
        Ticket ticket = em.find(Ticket.class, id);
        if (ticket != null) {
            em.remove(ticket);
        }
        em.getTransaction().commit();
    }

    public List<Ticket> getAllTickets() {
        TypedQuery<Ticket> query = em.createQuery("SELECT t FROM Ticket t", Ticket.class);
        return query.getResultList();
    }


}
