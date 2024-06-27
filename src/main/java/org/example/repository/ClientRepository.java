package org.example.repository;

import org.example.entity.Address;
import org.example.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClientRepository {
    private final EntityManager em;

    public ClientRepository(EntityManager em) {
        this.em = em;
    }

    public void addClient(Client client, Address address) {
        em.getTransaction().begin();
        address.setClient(client);
        em.persist(client);
        em.persist(address);
        em.getTransaction().commit();
    }

    public void updateClient(Client client) {
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();
    }

    public void deleteClient(int id) {
        em.getTransaction().begin();
        Client client = em.find(Client.class, id);
        if (client != null) {
            Address address = client.getAddress();
            if (address!= null) {
                address.setClient(null);
                em.remove(address);
            }
            em.remove(client);
        }
        em.getTransaction().commit();
    }

    public List<Client> getAllClient() {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }


}
