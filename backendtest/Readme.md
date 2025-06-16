# BE Dev Test

This project is a backend application developed using Spring Boot to test my skills as a BE Developer. It provides a RESTful API endpoint to retrieve transaction data and their corresponding statuses from a simulated database.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Building the Project](#building-the-project)
  - [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Database (H2 In-Memory)](#database-h2-in-memory)

## Features

- Provides a GET endpoint to fetch transaction details and status information.
- Loads initial data into an in-memory database upon application startup for demonstration purposes.
- Follows a basic REST API design pattern.

## Technologies Used

- **Java 17+**: The core programming language.
- **Spring Boot 3.x**: Framework for building the backend application.
- **Spring Web**: For creating RESTful APIs.
- **Spring Data JPA**: For interacting with the database.
- **H2 Database**: An in-memory database used for development and demonstration. It resets upon application restart.
- **Lombok**: (Optional but recommended) A library that reduces boilerplate code (getters, setters, constructors).
- **Maven**: Build automation tool.

## Project Structure

The project follows a standard Spring Boot application structure:

``````
backendtest/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── backendtest/
│   │   │               ├── MyBackendAppApplication.java
│   │   │               ├── controller/
│   │   │               │   └── TransactionController.java  
│   │   │               ├── model/
│   │   │               │   ├── Transaction.java            
│   │   │               │   ├── TransactionStatus.java      
│   │   │               │   └── ApiResponse.java            
│   │   │               └── repository/
│   │   │                   ├── TransactionRepository.java
│   │   │                   └── TransactionStatusRepository.java
│   │   └── resources/
│   │       └── application.properties
└── pom.xml
``````

## Getting Started

Follow these steps to get the application up and running on your local machine.

### Prerequisites

Before you begin, ensure you have the following installed:

-   **Java Development Kit (JDK) 17 or higher**: [Download from Oracle](https://www.oracle.com/java/technologies/downloads/) or use a package manager like SDKMAN.
-   **Apache Maven 3.x or higher**:
    -   **macOS (Homebrew)**: `brew install maven`
    -   **Windows**: [Download and configure PATH](https://maven.apache.org/install.html)
    -   **Linux**: Install via package manager (`sudo apt install maven` for Debian/Ubuntu) or [Download and configure PATH](https://maven.apache.org/install.html)
-   (Optional) An IDE like IntelliJ IDEA, Visual Studio Code with Java extensions, or Eclipse.

### Building the Project

Navigate to the root directory of the project (`my-backend-app`) in your terminal and run the Maven clean and install command:

```bash
mvn clean install
```

This command will compile the code, run tests (if any), and package the application into a JAR file.

### Running the Application
You can run the Spring Boot application using Maven:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080` by default. You will see logs in your terminal indicating that the server has started.

## API Endpoints
Once the application is running, you can access the following endpoint:

### Get All Transactions and Statuses
- URL: http://localhost:8080/api/viewData
- Method: GET
- Response: A JSON object containing a data array of transactions and a status array of transaction statuses, matching the structure of viewData.json.

Example curl command:
```bash
curl http://localhost:8080/api/viewData
```

## Database (H2 In-Memory)
This project uses H2 Database as an in-memory database. This means:

- The database is created in memory when the application starts.
- All data stored in it will be lost when the application stops or restarts.
- Initial data is loaded into this database via a CommandLineRunner component when the application first starts up.

### You can access the H2 database console to view the data:

URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:mydb
User Name: sa
Password: (leave blank)