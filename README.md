#  Weather Spring Boot API

A simple **Spring Boot REST API** that:

* Fetches real-time weather data from **OpenWeatherMap API**
* Stores the data in a **MySQL database**
* Provides REST endpoints to **save** and **retrieve** weather records

This project is built for learning **Spring Boot fundamentals**, including:

* Controller → Service → Repository architecture
* External API integration
* JPA & MySQL persistence
* RESTful endpoint design

---

#  Project Architecture

```
Controller  →  Service  →  Repository  →  MySQL
                ↓
         External Weather API
```

### Layers

* **Controller**

  * Handles HTTP requests
  * Returns JSON responses

* **Service**

  * Calls the external weather API
  * Processes and prepares data
  * Saves data to database

* **Repository**

  * Uses Spring Data JPA
  * Performs database operations automatically

* **Entity**

  * Represents the `weather` table in MySQL

---

# ⚙️ Technologies Used

* **Java 17+**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **MySQL**
* **OpenWeatherMap API**
* **Maven**

---

#  How to Run the Project

## 1️ Clone the repository

```
git clone <your-repo-url>
cd weather
```

## 2️ Configure MySQL

Create a database:

```
CREATE DATABASE weather_db;
```

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/weather_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 3️ Add your OpenWeatherMap API key

Inside:

```
WeatherService.java
```

Replace:

```
private final String API_KEY = "YOUR_API_KEY";
```

Get a free key from:

```
https://openweathermap.org/api
```

---

## 4️ Run the application

Using IntelliJ or terminal:

```
mvn spring-boot:run
```

Server starts at:

```
http://localhost:8080
```

---

# 📡 API Endpoints

## Fetch and store weather

```
GET /weather/fetch?city=Cairo
```

### Response

```json
{
  "id": 1,
  "city": "Cairo",
  "temperature": 30.5,
  "humidity": 40,
  "fetchedAt": "2026-02-08T20:10:00"
}
```

✔ Fetches from external API
✔ Saves into MySQL

---

## Get all stored weather records

```
GET /weather/all
```

### Response

```json
[
  { ... },
  { ... }
]
```

Returns all saved weather entries.

---

#  Learning Goals

This project helps you understand:

* Spring Boot project structure
* REST API development
* Database persistence with JPA
* Calling third-party APIs
* Backend debugging & error handling

---

#  Possible Future Improvements

* Global exception handling
* DTO & clean architecture layers
* Scheduled automatic weather fetching
* Docker containerization
* Frontend dashboard (React or Thymeleaf)
* Unit & integration testing

---

#  Author

Built as a **learning project for Spring Boot backend development**.
