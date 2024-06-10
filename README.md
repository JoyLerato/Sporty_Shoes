# Sporty Shoes E-commerce Website

This repository contains the prototype for Sporty Shoes' e-commerce platform. The application is built using Spring Boot and includes essential features for an online store, such as user registration and login, product management, order processing, and admin functionalities.

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Project Overview
Sporty Shoes is a company that manufactures and sells sports shoes. This project aims to develop a prototype for their e-commerce portal to transition from a walk-in store to an online store.

## Features
- **User Management**:
  - User registration and login.
  - User profile management.
- **Product Management**:
  - Admin can add, update, delete, and categorize products.
  - Customers can view and search products.
- **Order Management**:
  - Customers can add products to the cart and place orders.
  - Order confirmation and tracking.
- **Admin Features**:
  - Admin dashboard to manage products and view user lists.
  - View purchase reports filtered by date and category.
  - Change admin password.

## Technologies Used
- **Java 8**
- **Spring Boot**
- **Thymeleaf**
- **Spring Data JPA**
- **Spring Security**
- **Maven**

## Setup Instructions
1. **Clone the repository**:
   ```sh
   git clone (https://github.com/JoyLerato/Sporty_Shoes.git)
   cd sporty-shoes

Set up the database:

Ensure you have MySQL installed and running.
Create a database named sportyshoes and update the database configuration in src/main/resources/application.properties.
Build the project:
mvn clean install
Run the application:
mvn spring-boot:run

Running the Application
Once the application is running, you can access it at http://localhost:8080.

