package org.example.controller;

import org.example.entity.Address;
import org.example.entity.Client;
import org.example.entity.Event;
import org.example.entity.Ticket;
import org.example.service.ReservationService;
import org.example.util.TicketType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Ihm {
    private final ReservationService reservationService;
    private final Scanner scanner;

    public Ihm() {
        this.reservationService = new ReservationService();
        this.scanner = new Scanner(System.in);
    }

    public void createEvent() {
        System.out.println("Creating a new event:");
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();


        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.print("Enter event date (dd-MM-yyyy): ");
        LocalDate date = LocalDate.parse(scanner.nextLine(), dateFormatter);

        System.out.print("Enter event time (HH:MM): ");
        LocalTime time = LocalTime.parse(scanner.nextLine());

        System.out.print("Enter event capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        Event event = Event.builder()
                .name(name)
                .date(date)
                .time(time)
                .capacity(capacity)
                .build();

        reservationService.addEvent(event);
        System.out.println("Event created successfully.");
    }

    public void listEvents() {
        List<Event> events = reservationService.getAllEvents();
        for (Event event : events) {
            System.out.println(event);
        }
    }

    public void updateEvent() {
        System.out.print("Enter the ID of the event to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Event event = reservationService.getAllEvents()
                .stream().filter(e -> e.getId() == id)
                .findFirst().orElse(null);

        if (event != null) {
            System.out.print("Enter new name (or press Enter to keep current: "
                    + event.getName() + "): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                event.setName(name);
            }

            System.out.print("Enter new date (YYYY-MM-DD) (or press Enter to keep current: "
                    + event.getDate() + "): ");
            String date = scanner.nextLine();
            if (!date.isEmpty()) {
                event.setDate(LocalDate.parse(date));
            }

            System.out.print("Enter new time (HH:MM) (or press Enter to keep current: "
                    + event.getTime() + "): ");
            String time = scanner.nextLine();
            if (!time.isEmpty()) {
                event.setTime(LocalTime.parse(time));
            }

            System.out.print("Enter new capacity (or press Enter to keep current: "
                    + event.getCapacity() + "): ");
            String capacity = scanner.nextLine();
            if (!capacity.isEmpty()) {
                event.setCapacity(Integer.parseInt(capacity));
            }

            reservationService.updateEvent(event);
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    public void deleteEvent() {
        System.out.print("Enter the ID of the event to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        reservationService.deleteEvent(id);
        System.out.println("Event deleted successfully.");
    }

    public void createClient() {
        System.out.println("Creating a new client:");
        System.out.print("Enter client last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter client first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter client age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter client phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Adress:");
        System.out.println("Number and Street : ");
        String street = scanner.nextLine();
        System.out.println("City : ");
        String city = scanner.nextLine();

        Address address = Address.builder()
                .street(street)
                .city(city)
                .build();

        Client client = Client.builder()
                .lastName(lastName)
                .firstName(firstName)
                .age(age)
                .phoneNumber(phoneNumber)
                .address(address)
                .build();

        reservationService.addClient(client, address);

        System.out.println("Client created successfully.");
    }

    public void listClients() {
        List<Client> clients = reservationService.getAllClients();
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public void updateClient() {
        System.out.print("Enter the ID of the client to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Client client = reservationService.getAllClients().stream()
                .filter(c -> c.getId() == id).findFirst().orElse(null);

        if (client != null) {
            System.out.print("Enter new last name (or press Enter to keep current: "
                    + client.getLastName() + "): ");
            String lastName = scanner.nextLine();
            if (!lastName.isEmpty()) {
                client.setLastName(lastName);
            }

            System.out.print("Enter new first name (or press Enter to keep current: "
                    + client.getFirstName() + "): ");
            String firstName = scanner.nextLine();
            if (!firstName.isEmpty()) {
                client.setFirstName(firstName);
            }

            System.out.print("Enter new age (or press Enter to keep current: "
                    + client.getAge() + "): ");
            String age = scanner.nextLine();
            if (!age.isEmpty()) {
                client.setAge(Integer.parseInt(age));
            }

            System.out.print("Enter new phone number (or press Enter to keep current: "
                    + client.getPhoneNumber() + "): ");
            String phoneNumber = scanner.nextLine();
            if (!phoneNumber.isEmpty()) {
                client.setPhoneNumber(phoneNumber);
            }

            reservationService.updateClient(client);
            System.out.println("Client updated successfully.");
        } else {
            System.out.println("Client not found.");
        }
    }

    public void deleteClient() {
        System.out.print("Enter the ID of the client to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        reservationService.deleteClient(id);
        System.out.println("Client deleted successfully.");
    }

    public void createTicket() {
        System.out.println("Creating a new ticket:");
        System.out.print("Enter ticket number: ");
        int ticketNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter ticket type (STANDARD, GOLD, VIP): ");
        TicketType ticketType = TicketType.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter client ID: ");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter event ID: ");
        int eventId = Integer.parseInt(scanner.nextLine());

        Client client = reservationService.getClientById(clientId);
        Event event = reservationService.getEventById(eventId);

        if (client != null && event != null) {
            Ticket ticket = Ticket.builder()
                    .ticketNumber(ticketNumber)
                    .ticketType(ticketType)
                    .client(client)
                    .event(event)
                    .build();

            reservationService.addTicket(ticket);
            System.out.println("Ticket created successfully.");
        } else {
            System.out.println("Client or Event not found.");
        }
    }


    public void listTickets() {
        List<Ticket> tickets = reservationService.getAllTickets();
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public void updateTicket() {
        System.out.print("Enter the ID of the ticket to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Ticket ticket = reservationService.getAllTickets().stream()
                .filter(t -> t.getId() == id).findFirst().orElse(null);
        if (ticket != null) {
            System.out.print("Enter new ticket number (or press Enter to keep current: "
                    + ticket.getId() + "): ");
            String ticketNumber = scanner.nextLine();
            if (!ticketNumber.isEmpty()) {
                ticket.setId(Integer.parseInt(ticketNumber));
            }

            System.out.print("Enter new ticket type (STANDARD, GOLD, VIP) (or press Enter to keep current: "
                    + ticket.getTicketType() + "): ");
            String ticketType = scanner.nextLine();
            if (!ticketType.isEmpty()) {
                ticket.setTicketType(TicketType.valueOf(ticketType.toUpperCase()));
            }

            System.out.print("Enter new client ID (or press Enter to keep current: "
                    + ticket.getClient().getId() + "): ");
            String clientId = scanner.nextLine();
        }
    }

    public void deleteTicket() {
        System.out.print("Enter the ID of the ticket to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        reservationService.deleteTicket(id);
        System.out.println("Ticket deleted successfully.");
    }
}
