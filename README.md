# E-Commerce Console Application

## Project Overview

The E-Commerce Console Application is a Java-based console application designed to simulate an online shopping system with Admin and Customer roles. Although it is not a Spring Boot application, the project is structured using Spring Boot–style layered architecture, making it scalable and easy to migrate to a Spring Boot environment in the future.

The application supports product management, user management, and order handling through a menu-driven console interface. Data is stored in-memory using Java Collections (List DSAs) to simulate repository behavior.

---

## Technology Stack

* Language: Java
* Application Type: Console-based
* Architecture Style: Spring Boot–like layered structure
* Data Storage: In-memory storage using Java `List`
* Design Approach: Object-Oriented Programming (OOP)

---

## DTO Layer (Data Models)

* User

  * name
  * email

* Admin

  * inherits `User`
  * role

* Customer

  * inherits `User`
  * address

* Product

  * id
  * name
  * price
  * category

* Order

  * id
  * user
  * product

---

## Repository Layer (In-Memory Storage)

* Uses Java List Data Structures to store:

  * Admins
  * Customers
  * Products
  * Orders
* Acts as a simulated database layer
* Enables CRUD operations without external DB dependency

---

## Main Menu Flow

```
1 - Admin User
2 - Customer User
3 - Exit
```

---

## Admin Operations

```
1  - Add Admin
2  - Remove Admin
3  - Add Product
4  - Remove Product
5  - Add Customer
6  - Remove Customer
7  - Delete Account
8  - Back to Main Menu
9  - Exit
10 - View Order History
```

---

## Customer Operations

```
1 - View Products
2 - Place Order using Product ID
3 - View Order History using Customer ID
```

---

## Application Flow

1. User selects role (Admin or Customer) from the main menu.
2. Based on the role, the corresponding operations menu is displayed.
3. User inputs are handled through console interaction.
4. Business logic is processed in service classes.
5. Data is stored and retrieved from in-memory repositories.
6. Output is displayed back to the console.

---

## Key Features

* Role-based operations (Admin & Customer)
* Product management by Admin
* Order placement and order history tracking
* In-memory data storage using Java Lists
* Spring Boot–style project structure
* Clean OOP-based design

---

## Learning Outcomes

* Strong understanding of Java OOP concepts
* Hands-on experience with layered architecture
* Simulation of the repository pattern using DSAs
* Clear separation of concerns
* Console-based application flow management

---

## Future Enhancements

* Convert to Spring Boot REST API
* Replace in-memory storage with MySQL
* Add authentication and authorization
* Implement exception handling and logging
* Enhance order management features

---

If you want next:

* ✅ Short GitHub repo description (1–2 lines)
* ✅ Flow diagram explanation
* ✅ Interview explanation version
* ✅ Converted Spring Boot version design

Just tell me 👍
