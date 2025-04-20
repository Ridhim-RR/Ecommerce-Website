# 🛍️ Product Service

The **Product Service** is a core component of the e-commerce ecosystem that provides capabilities for managing and retrieving product-related data. It supports both functional and non-functional requirements essential for modern, scalable systems.

---

## 📦 Core Functionalities

### 1. Product Management
- Add, update, delete, and retrieve product details.
- Each product has the following attributes:
    - **Name**
    - **Description**
    - **Price**
    - **Category**
    - **Images**

### 2. Filtering & Search
- Users can:
    - **Search products by name**
    - **Apply pagination** for efficient navigation of large result sets
    - **Sort products** by various criteria such as:
        - Price
        - Product IDs
        - (Easily extendable to other fields)

---

## ⚙️ Non-Functional Requirements

### 1. Scalability
- Designed to handle **large datasets** efficiently.
- Integrates **Redis caching** to reduce database load for frequently accessed products.

### 2. Performance
- Optimized to deliver **API responses within 200ms** for most queries.

### 3. Security
- Implements **Role-Based Access Control (RBAC)**:
    - Only **authorized users** can perform add/update/delete operations.
- Comprehensive **data validation** to ensure product integrity and prevent invalid entries.

### 4. Maintainability & Extensibility
- Modular architecture designed for:
    - Easy feature additions
    - Clean separation of concerns
    - Long-term maintainability

---

## 🌐 Service Discovery & Routing

### 🏠 Eureka Server
- The **Eureka Server** is used for **service discovery** in a microservices architecture.
- It acts as a registry where all microservices can register and discover each other.
- This ensures dynamic registration and lookup, helping services find the right endpoints for inter-service communication.

### 🔀 API Gateway
- The **API Gateway** is responsible for routing requests from clients to the appropriate backend services (Product Service, Order Service, etc.).
- It acts as a **single entry point** for all external API calls, simplifying client-side interactions with the entire microservices ecosystem.
- The API Gateway handles:
    - Routing requests to the correct service
    - Load balancing across service instances
    - Security and authentication (via User Service)
    - Centralized logging and monitoring

---

## 📌 Technologies Used
- **Java / Spring Boot**
- **MySQL** (for product data storage)
- **Redis** (for caching)
- **RESTful APIs** (for service communication)
- **Spring Cloud Eureka** (for service discovery)
- **Spring Cloud Gateway** (for API Gateway)

---

## 🧩 Contributors
- [Ridhim Singh Raizada]

---

