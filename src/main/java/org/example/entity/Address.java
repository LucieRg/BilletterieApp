package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private int idAddress;
    private String street;
    private String city;

    @OneToOne (mappedBy = "address")
    private Client client;

    @OneToOne( mappedBy = "address")
    private Event event;

    @Override
    public String toString() {
        return "Address{" +
                "idAddress=" + idAddress +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
