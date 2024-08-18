# Event Registration System

This project is a prototype application of RESTful web services in Spring Boot, designed for an Event Registration domain. It allows users to register for events and provides a system for event organizers to manage these events.

## Table of Contents
- [Introduction](#introduction)
- [Main Functionalities](#main-functionalities)
- [Architecture](#architecture)
- [Dependencies](#dependencies)
- [How to Build and Run](#how-to-build-and-run)
- [Sample REST Requests](#sample-rest-requests)

## Introduction
The Event Registration System is a simple yet powerful application that demonstrates the use of Spring Boot to create a layered architecture for managing events and user registrations.

## Main Functionalities
- **Event Management**: Create, update, delete, and view events.
- **User Registration**: Register users for events and view registered users.
- **Search and Filter**: Search for events by name, date, and other criteria.
- **Event Details**: View detailed information about each event including the name, date, location, and description.

## Architecture
The application follows a typical layered architecture:
- **API Layer**: Handles HTTP requests and responses (Controllers).
- **Service Layer**: Contains business logic.
- **Data Access Layer**: Interacts with the database (Repositories).
- **Database**: Stores data (Using H2 in-memory database).

## Dependencies
The following dependencies are used in the project:
- **Spring Web**
- **Spring Data JPA**
- **H2 Database**
- **JDK 21**

## How to Build and Run
1. **Clone the repository**:
    ```bash
    git clone <repository-url>
    ```
2. **Navigate to the project directory**:
    ```bash
    cd EventRegistrationSystem-main
    ```
3. **Build and run the project**:
    ```bash
    ./mvnw spring-boot:run
    ```
4. The application will be available at [http://localhost:8080](http://localhost:8080).

## Sample REST Requests
Here are some sample REST requests to demonstrate the implemented use cases:

### Create an Event
```
curl -X POST http://localhost:8080/events \
-H "Content-Type: application/json" \
-d '{
  "eventName": "Tech Conference",
  "eventDate": "2024-08-15",
  "location": "Convention Center",
  "description": "A conference about the latest in tech."
}'
```

### Read an Event

```bash
curl -X GET http://localhost:8080/events/1
```

### Create a User
```bash
curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{
  "userName": "johndoe123",
  "email": "johndoe@example.com"
}'
```

### Read a User


```bash
curl -X GET http://localhost:8080/users/1
```


