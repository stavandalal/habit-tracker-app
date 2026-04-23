# Habit Tracker App

## Overview

Habit Tracker is a scalable full-stack productivity application designed to help users build, track, and maintain habits effectively.

The system is being developed with a focus on clean architecture, scalability, and real-world engineering practices.

---

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* H2 Database (Development)

### Frontend (Upcoming)

* React.js

---

## Architecture

The backend follows a layered architecture:

```
Controller → Service → Repository → Database
```

This separation ensures maintainability, scalability, and clear responsibility boundaries.

---

## Features

### Current

* Create Habit
* Persist habits in database
* RESTful API design

### Planned

* Habit tracking (daily completion)
* Streak system
* Analytics dashboard
* Authentication (JWT)
* Reminders and notifications
* AI-based habit suggestions

---

## API

### Create Habit

**Endpoint**

```
POST /api/habits
```

**Request**

```json
{
  "name": "Workout",
  "description": "30 mins gym",
  "frequency": "DAILY"
}
```

**Response**

```json
{
  "id": 1,
  "name": "Workout",
  "description": "30 mins gym",
  "frequency": "DAILY",
  "active": true
}
```

---

## Running the Project

### Prerequisites

* Java 17+
* Maven

### Setup

```bash
git clone https://github.com/stavandalal/habit-tracker-app.git
cd habit-tracker-app
```

### Run Backend

```bash
./mvnw spring-boot:run
```

---

## Engineering Principles

* Clean Code
* Layered Architecture
* Separation of Concerns
* Scalable Design Approach

---

## Project Status

In active development
