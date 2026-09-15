# Student Course Registration

## Overview

Student Course Registration is a Spring Boot REST API application used to manage student course registrations without a database.

The application uses in-memory storage to register, retrieve, and delete student course registrations.

## Technology Stack

* Java 17
* Spring Boot 3.5.6
* Spring Web
* Spring Validation
* Lombok
* Maven
* REST API
* In-Memory Storage

## Features

* Register a student
* View all students
* Find student by ID
* Delete course registration
* Request validation
* Custom exception handling
* Global exception handling
* Duplicate registration validation
* Standard API response structure
* ResponseEntity

## Project Architecture

```text
Controller
    ↓
Request DTO
    ↓
Service
    ↓
ServiceIMPL
    ↓
In-Memory List
    ↓
Response DTO
    ↓
ApiResponse
```

## API Endpoints

| Method | Endpoint                       | Description         |
| ------ | ------------------------------ | ------------------- |
| POST   | `/api/v1/students/register`    | Register a student  |
| GET    | `/api/v1/students`             | Get all students    |
| GET    | `/api/v1/students/{studentId}` | Get student by ID   |
| DELETE | `/api/v1/students/{studentId}` | Delete registration |

## Sample Request

### Register Student

```json
{
    "studentName": "Poovarasan",
    "courseName": "Java Backend Development",
    "email": "poovarasan@gmail.com",
    "age": 27
}
```

## Validation

* Student name cannot be empty
* Course name cannot be empty
* Email must be valid
* Email cannot be empty
* Age must be at least 18

## Exception Handling

The application uses centralized exception handling with:

* StudentNotFoundException
* DuplicateStudentException
* MethodArgumentNotValidException
* GlobalExceptionHandler

## Response Format

```json
{
    "success": true,
    "message": "Student registered successfully",
    "data": {}
}
```

## Important Note

This application uses in-memory storage instead of a database.

Therefore, all student registration data will be cleared when the application is restarted.
