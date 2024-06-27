package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.util.TicketType;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private int id;
    private int ticketNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_type")
    private TicketType ticketType;


    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_event")
    private Event event;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketNumber=" + ticketNumber +
                ", ticketType=" + ticketType +
                ", client name=" + client.getLastName() + " " + client.getFirstName() +
                ", event name=" + event.getName() +
                '}';
    }
}
