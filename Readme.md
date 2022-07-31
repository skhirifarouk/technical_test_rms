# RMS Flights

This applications contanis three microservices
- Tunisair flights API : exposing services associated to Tunisair flights data (swagger url : http://localhost:8081/tunisair/swagger-ui.html#/tunisair-flight-controller)
    This API is connected to its database (tunisair_database (docker / dev port:3306))


- Nouvelair flights API : exposing services associated to Nouvelair flights data (swagger url : http://localhost:8082/nouvelair/swagger-ui.html#/nouvelair-flight-controller)
  This API is connected to its database (nouvelair_database (docker port:3307 / dev port : 3306))

  
- RMS flights API : An API collecting data from both APIs (swagger url : http://localhost:8080/rms/swagger-ui.html#/rms-flight-controller).

All APIs have two profiles

- Dev profile : Allowing to depoly each API on its own il a local environment.
This will requre the creation of a local MySQL database (both of the databases will use port 3306 by default)

- Prod profile : This profile is dedicated to docker delpoyment.
In order to launch the project, use the docker-compose.yml file that will launch all APIs and both of the databases each in its own container.

Every API has:
- Exception handlers
- Swagger documentation
- Unit tests on most of the methods
- Validations of Data structure

RMS API uses CompletableFutures in order to execute both of the services simultaneously.

# Requirements
- Docker 
- JDK 11
- maven 3.8.3

# Technical Properties
- Spring 2.7.0 (Compatible with feign 2021.0.3)
- Swagger 3
- Database : MySQL 8.0

# Installation
Launch "docker-compose up --build" in command prompt on the directory. This will deploy the project using configuration in docker-compose.yml



