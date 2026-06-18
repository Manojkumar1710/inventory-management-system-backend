# Inventory Management System - Backend

## Overview

The Inventory Management System (IMS) Backend is a Spring Boot application that provides secure authentication, role-based access control, and inventory management functionalities for administrators and managers.

The system allows users to manage products, categories, suppliers, and users through REST APIs secured using JWT Authentication.

---

## Tech Stack

* Java 17
* Spring Boot 3
* Spring Security
* JWT Authentication
* Spring Data JPA
* MySQL
* Maven
* Swagger / OpenAPI

---

## Features

### Authentication & Security

* User Login
* JWT Token Generation
* Password Encryption using BCrypt
* Role-Based Access Control (RBAC)

### Inventory Management

* Products CRUD Operations
* Categories CRUD Operations
* Suppliers CRUD Operations
* Users CRUD Operations

### Dashboard

* Dashboard APIs for Inventory Overview

### API Documentation

* Swagger UI Integration

### Validation & Exception Handling

* Request Validation
* Global Exception Handling

---

## Roles

### ADMIN

* Manage Users
* Manage Products
* Manage Categories
* Manage Suppliers
* Access Dashboard

### MANAGER

* Manage Products
* Manage Categories
* Manage Suppliers
* Access Dashboard

---

## API Documentation

Swagger UI:

```text
Local Swagger URL:
http://localhost:8080/swagger-ui/index.html
```

---

## Demo Credentials

### ADMIN

```text
Email    : admin1@ims.com
Password : admin@123
```

### MANAGER

```text
Email    : manager1@ims.com
Password : manager@123
```

> Note: Replace these credentials with your actual demo accounts before deployment.

---

## Run Locally

### 1. Clone Repository

```bash
git clone https://github.com/Manojkumar1710/inventory-management-system-backend.git
```

### 2. Configure Database

Update the MySQL configuration inside:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Run Application

```bash
mvn spring-boot:run
```

---

## Project Structure

```text
com.manoj.inventory
│
├── controller
├── service
├── service.impl
├── repository
├── entity
├── dto
├── security
├── exception
├── config
│
└── InventoryManagementSystemApplication
```

---
## Environment Variables

Configure the following variables before running:

DB_URL
DB_USERNAME
DB_PASSWORD

## Future Enhancements

* Employee Management Module
* Stock Transaction Tracking
* Reports & Analytics
* Cloud Deployment
* Audit Logging

---

## Author

Akula Manoj Kumar

SRKR Engineering College
