# 📌 Azentrix Fullstack Task 1 - URL Shortener API

## 📖 Overview

A RESTful URL Shortener API built using Spring Boot and PostgreSQL.

This application allows users to:
- 🔗 Shorten long URLs
- 🔁 Redirect using generated short URLs
- 📊 Track click counts
- 📈 View URL analytics
- 📚 Access API documentation using Swagger UI

---

## ⚙️ Tech Stack

- Java 22
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Swagger OpenAPI

---

## 🗂️ Project Structure

src/
├── controller
├── service
├── repository
├── entity
├── dto
└── resources

---

## 🧠 Approach

### 🔗 URL Shortening
User submits a long URL via `/shorten` endpoint.

A unique 6-character short code is generated and stored in PostgreSQL with:
- Original URL
- Short Code
- Click Count (default = 0)

---

### 🔁 Redirection
When user accesses:

http://localhost:8080/{shortCode}

System:
1. Fetches original URL from DB  
2. Increments click count  
3. Redirects user to original URL  

---

### 📊 Analytics
Endpoint: `/stats/{code}`

Returns:
- Original URL  
- Short Code  
- Click Count  

---

## 🗄️ Database Setup

```sql
CREATE DATABASE urlshortener;