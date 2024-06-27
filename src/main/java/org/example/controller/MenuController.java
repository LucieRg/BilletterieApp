package org.example.controller;

import java.util.Scanner;

public class MenuController {
    private final Ihm ihm;
    private final Scanner scanner;

    public MenuController() {
        this.ihm = new Ihm();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create Event");
            System.out.println("2. List Events");
            System.out.println("3. Update Event");
            System.out.println("4. Delete Event");
            System.out.println("5. Create Client");
            System.out.println("6. List Clients");
            System.out.println("7. Update Client");
            System.out.println("8. Delete Client");
            System.out.println("9. Create Ticket");
            System.out.println("10. List Tickets");
            System.out.println("11. Update Ticket");
            System.out.println("12. Delete Ticket");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    ihm.createEvent();
                    break;
                case 2:
                    ihm.listEvents();
                    break;
                case 3:
                    ihm.updateEvent();
                    break;
                case 4:
                    ihm.deleteEvent();
                    break;
                case 5:
                    ihm.createClient();
                    break;
                case 6:
                    ihm.listClients();
                    break;
                case 7:
                    ihm.updateClient();
                    break;
                case 8:
                    ihm.deleteClient();
                    break;
                case 9:
                    ihm.createTicket();
                    break;
                case 10:
                    ihm.listTickets();
                    break;
                case 11:
                    ihm.updateTicket();
                    break;
                case 12:
                    ihm.deleteTicket();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


}
