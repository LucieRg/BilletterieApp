# Ticket Reservation System

Ce projet est un système de réservation de billets pour des événements. Il permet la création, la mise à jour, la suppression et la gestion des clients, des événements et des billets.


## Installation

**Configurez la base de données :**

    - Créez une base de données PostgreSQL.
    - Mettez à jour le fichier `persistence.xml` avec vos informations de connexion à la base de données.


## Utilisation

Une fois l'application démarrée, vous pouvez interagir avec elle via la console. Voici quelques commandes de base pour démarrer :

- **Créer un événement :**

    ```
    Creating a new event:
    Enter event name: Concert
    Enter event date (dd-MM-yyyy): 27-06-2024
    Enter event time (HH:MM): 20:00
    Enter event capacity: 100
    Event created successfully.
    ```

- **Lister tous les événements :**

    ```
    Event{id=1, name='Concert', date=2024-06-27, time=20:00, capacity=100}
    ```

- **Créer un client :**

    ```
    Creating a new client:
    Enter client last name: Doe
    Enter client first name: John
    Enter client age: 30
    Enter client phone number: 123-456-7890
    Adress:
    Number and Street : 123 Main St
    City : Springfield
    Client created successfully.
    ```

- **Créer un billet :**

    ```
    Creating a new ticket:
    Enter ticket number: 1
    Enter ticket type (STANDARD, GOLD, VIP): VIP
    Enter client ID: 1
    Enter event ID: 1
    Ticket created successfully.
    ```

## Fonctionnalités

- **Gestion des événements :** Créer, mettre à jour, supprimer et lister des événements.
- **Gestion des clients :** Créer, mettre à jour, supprimer et lister des clients.
- **Gestion des billets :** Créer, mettre à jour, supprimer et lister des billets, avec association des clients et des événements.


