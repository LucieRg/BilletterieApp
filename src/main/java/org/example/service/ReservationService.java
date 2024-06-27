package org.example.service;

import org.example.entity.Address;
import org.example.entity.Client;
import org.example.entity.Event;
import org.example.entity.Ticket;
import org.example.repository.ClientRepository;
import org.example.repository.EventRepository;
import org.example.repository.TicketRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ReservationService {
    private EntityManagerFactory emf;
    private EntityManager em;
    private ClientRepository clientRepository;
    private EventRepository eventRepository;
    private TicketRepository ticketRepository;

    public ReservationService() {
        emf = Persistence.createEntityManagerFactory("ticketPU"); // Specify your persistence unit name here
        em = emf.createEntityManager();
        clientRepository = new ClientRepository(em);
        eventRepository = new EventRepository(em);
        ticketRepository = new TicketRepository(em);
    }

    public void close() {
        em.close();
        emf.close();
    }

    public void addClient(Client client, Address address) {

        clientRepository.addClient(client, address);
    }

    public void updateClient(Client client) {

        clientRepository.updateClient(client);
    }

    public void deleteClient(int id) {

        clientRepository.deleteClient(id);
    }

    public void addEvent(Event event) {

        eventRepository.addEvent(event);
    }

    public void updateEvent(Event event) {

        eventRepository.updateEvent(event);
    }

    public void deleteEvent(int id) {

        eventRepository.deleteEvent(id);
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.addTicket(ticket);
    }

    public void updateTicket(Ticket ticket) {

        ticketRepository.updateTicket(ticket.getId());
    }

    public void deleteTicket(int id) {
        ticketRepository.deleteTicket(id);
    }

    public List<Event> getAllEvents() {
        return eventRepository.getAllEvent();
    }

    public List<Client> getAllClients() {
        return clientRepository.getAllClient();
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.getAllTickets();
    }


    public Client getClientById(int id) {
        return em.find(Client.class, id);
    }

    public Event getEventById(int eventId) {
        return em.find(Event.class, eventId);
    }
}

