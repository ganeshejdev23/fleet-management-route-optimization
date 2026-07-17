# Current Status

## Week 1 - Day 1 Completed

* Spring Boot project setup
* Maven dependencies configured
* MySQL database setup
* Package structure created
* Driver entity created

## Week 1 - Day 2 Completed

* Vehicle entity created
* DeliveryTask entity created
* DeliveryStatus enum created
* Entity relationships mapped

## Week 1 - Day 3 Completed

* Route entity created
* Repository layer implemented

  * DriverRepository
  * VehicleRepository
  * DeliveryTaskRepository
  * RouteRepository
* Database schema finalized

## Week 1 - Day 4 Completed

### Service Layer Implemented

- DriverService
- VehicleService
- DeliveryTaskService
- RouteService

### Features

- Save Operations
- Fetch All Records
- Fetch By ID
- Delete Operations

### Status

Business logic layer completed successfully.

### Commit

Implemented service layer and business logic for fleet management

## Week 1 - Day 5 Completed

### Controller Layer Implemented

- DriverController
- VehicleController
- DeliveryTaskController
- RouteController

### REST APIs

- POST
- GET
- GET By ID
- DELETE

### Swagger Testing

Successfully tested CRUD APIs.

### Status

Week 1 completed successfully.

## Week 1 Completed

### Achievements

- Designed database schema
- Created Driver, Vehicle, DeliveryTask and Route entities
- Implemented JPA repositories
- Implemented service layer
- Implemented REST controllers
- Integrated Swagger OpenAPI documentation
- Configured temporary security setup
- Successfully tested CRUD APIs
- Verified MySQL persistence

### Result

Week 1 completed successfully and back-end foundation is ready for Route Optimization Engine development.

## Week 2 - Day 1 Completed

### External Routing API Integration

- Configured RestTemplate Bean
- Integrated OSRM Routing API
- Created RouteOptimizationService
- Created RouteOptimizationController

### Testing

Successfully retrieved route information between Hyderabad and Bangalore.

### Result

External routing integration completed successfully.

## Week 2 - Day 2 Completed

### Route Optimization Workflow

- Created RouteRequestDto
- Created OptimizedRouteResponseDto
- Implemented optimization service workflow
- Created POST /optimize/sequence API

### Testing

Successfully tested route optimization endpoint using Swagger.

### Result

Optimization request-response framework established successfully.

## Week 2 - Day 3 Completed

### Greedy Route Optimization

Implemented a Greedy Nearest Neighbor algorithm to generate an optimized delivery sequence.

### Features

- Created LocationDto
- Implemented distance calculation logic
- Developed nearest-neighbor optimization algorithm
- Added GET /optimize/nearest API
- Successfully tested using Swagger

### Outcome

The system can now generate an optimized delivery sequence based on the nearest available location, providing the foundation for route optimization.

## Week 2 - Day 4 Completed

### Route Summary Module

Implemented a Route Summary API to provide additional route information for dispatcher dashboards.

### Features

- Created RouteSummaryDto
- Added route summary generation
- Implemented GET /optimize/summary endpoint
- Included:
  - Optimized Route
  - Total Stops
  - Starting Point
  - Ending Point

### Testing

Successfully verified the API through Swagger.

### Outcome

Enhanced the Route Optimization Engine with route summary details, making it suitable for frontend integration and dispatcher reporting.

## Week 2 - Day 5 Completed

### Fleet Integration

Implemented route assignment workflow by integrating optimized routes with fleet vehicles.

### Features

- Added Route Assignment API
- Added Route Status
- Linked Vehicle with Route
- Created Dispatcher Summary DTO

### Outcome

Completed Week 2 by connecting route optimization with fleet management workflow.

# Week 2 Progress Summary

## External API Integration

Integrated the Open Source Routing Machine (OSRM) API using Spring RestTemplate to retrieve routing information between delivery locations.

## Route Optimization

Implemented a Greedy Nearest Neighbor algorithm to generate optimized delivery sequences.

## Route Summary

Developed APIs to return optimized routes along with summary details including total stops, starting location, and destination.

## Fleet Integration

Integrated optimized routes with fleet entities by assigning routes to vehicles and linking vehicles with drivers.

## Testing

Successfully tested all APIs using Swagger OpenAPI.

### Week 2 Deliverables

- RestTemplate Integration
- OSRM API Integration
- Route Optimization Service
- Greedy Optimization Algorithm
- Route Summary API
- Vehicle Assignment
- Driver Assignment
- Route Assignment
- Swagger Testing
- Database Persistence

### Outcome

Completed the Route Optimization Engine and integrated it with the Fleet Management module, enabling optimized route assignment to vehicles and drivers.

## Week 3 - Day 1 Completed

### Dispatch Workflow

Implemented the dispatch workflow by introducing the first delivery state transition.

### Features

- Added Dispatch API
- Updated DeliveryStatus from UNASSIGNED to DISPATCHED
- Integrated dispatch workflow with DeliveryTask entity
- Verified Vehicle assignment during dispatch

### Testing

Successfully tested the Dispatch API using Swagger.

### Result

Delivery tasks can now move from UNASSIGNED to DISPATCHED.

## Week 3 - Day 2 Completed

### Delivery State Machine

Implemented the remaining delivery state transitions.

### Features

- Added In Transit API
- Added Delivered API
- Updated DeliveryStatus from DISPATCHED → IN_TRANSIT
- Updated DeliveryStatus from IN_TRANSIT → DELIVERED

### Testing

Successfully tested all delivery state transitions using Swagger.

### Result

The complete delivery lifecycle is now supported:
UNASSIGNED → DISPATCHED → IN_TRANSIT → DELIVERED

## Week 3 - Day 3 Completed

### Manifest Generation

Implemented delivery manifest generation using a DTO.

### Features

- Created ManifestResponse DTO
- Generated delivery manifest from DeliveryTask
- Included vehicle information
- Included driver information (if assigned)

### Testing

Successfully generated delivery manifests through Swagger.

### Result

Dispatchers can retrieve a complete delivery manifest for any delivery task.

## Week 3 - Day 4 Completed

### Global Exception Handling

Implemented centralized exception handling and request validation.

### Features

- Created ResourceNotFoundException
- Implemented GlobalExceptionHandler
- Added validation to DeliveryTask
- Improved API error responses

### Testing

- Verified validation errors
- Verified Resource Not Found handling

### Result

The application now returns meaningful error messages and validates incoming requests.

## Week 3 - Day 5 Completed

### Project Cleanup & Verification

Performed final verification and cleanup for all Week 3 features.

### Features

- Added HealthController
- Added API status endpoints
- Verified CRUD APIs
- Verified Dispatch Workflow
- Verified Delivery State Machine
- Verified Manifest Generation
- Verified Validation and Exception Handling

### Testing

Successfully tested all APIs using Swagger.

### Result

The Fleet Management backend is stable, well-structured, and ready for implementing authentication and authorization in
 Week 4.
 
## Week 4 - Day 1 Completed

### Authentication Setup

Implemented the initial authentication module for the Fleet Management application.

### Features

- Added Spring Security dependencies
- Added JWT libraries
- Created User entity
- Created UserRepository
- Implemented UserService
- Configured BCrypt password encoder

### Result

The project is now prepared for implementing JWT authentication and login functionality. 

### Swagger Documentation

- Added @Tag annotations to all controllers
- Added @Operation annotations to all APIs
- Improved Swagger UI readability
- Grouped APIs by module

### Result

Swagger now provides clear, categorized API documentation suitable for development and project demonstrations.

## Week 4 - Day 2 Completed

### Docker Containerization

Successfully containerized the Fleet Management application using Docker.

### Features

- Created Dockerfile
- Built Spring Boot executable JAR
- Built Docker image
- Configured Docker networking
- Successfully ran the application inside a Docker container

### Testing

- Verified Docker image creation
- Verified container startup
- Verified application accessibility on port 8081

### Result

The Fleet Management application is successfully containerized and can be deployed consistently across different environments.

## Week 4 - Day 3 Completed

### React Frontend Development

Developed the initial React frontend for the Fleet Management application and connected it to the Spring Boot REST APIs.

### Features

- Created React application using Create React App
- Installed Bootstrap, Axios, and React Router
- Designed Fleet Management Dashboard
- Connected Dashboard to Spring Boot APIs
- Displayed live counts for Drivers, Vehicles, Routes, and Delivery Tasks
- Configured CORS for frontend-backend communication

### Testing

- Verified React application on http://localhost:3000
- Successfully fetched live data from backend APIs
- Confirmed Dashboard updates dynamically based on database records

### Result

The frontend is successfully integrated with the Spring Boot backend and provides a live dashboard displaying fleet statistics.

# Week 4 - Day 4

## Objective
Develop the Driver Management module in the React frontend and integrate it with the Spring Boot REST APIs.

---

## Tasks Completed

### Driver Dashboard
- Connected the React application with the Spring Boot backend.
- Verified API communication using Axios.
- Configured reusable API service classes.

### Driver Management
- Implemented Driver List page.
- Retrieved driver records from the backend using REST API.
- Displayed driver information in a Bootstrap table.
- Added navigation from Dashboard to Driver Management.

### Add Driver
- Created Add Driver page.
- Implemented controlled React form using useState.
- Connected form submission with Spring Boot POST API.
- Added automatic redirection back to Driver List after successful insertion.

### Delete Driver
- Added Delete button for each driver.
- Integrated DELETE REST API.
- Implemented confirmation dialog before deletion.
- Investigated deletion failure.

### Database Validation
- Identified foreign key constraint preventing deletion of assigned drivers.
- Verified Driver-Vehicle relationship in MySQL.
- Learned that a driver cannot be deleted while assigned to a vehicle.
- Planned validation logic to display a user-friendly message before deletion.

### Vehicle Data Validation
- Added unique constraint for vehicle_number.
- Removed duplicate vehicle numbers from the database.
- Ensured vehicle numbers remain unique across the system.

### Testing
- Successfully tested:
  - View Drivers
  - Add Driver
  - Dashboard statistics
  - Backend API integration
  - Swagger API endpoints
- Verified React frontend communication with Spring Boot backend.

---

## Technologies Used

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- MySQL
- React.js
- React Router
- Axios
- Bootstrap
- Swagger OpenAPI
- Git
- Docker

---

## Challenges Faced

- React routing configuration.
- Axios API integration.
- Driver deletion blocked due to foreign key constraints.
- Duplicate vehicle numbers in the database.

---

## Solutions Implemented

- Fixed React Router navigation.
- Configured reusable Axios API layer.
- Identified and analyzed database foreign key relationships.
- Applied unique constraint for vehicle numbers.
- Planned business validation before driver deletion.

---

## Outcome

Successfully completed the Driver Management module with:

- Driver Listing
- Add Driver
- React Navigation
- REST API Integration
- Backend Communication
- Database Validation
- Delete Operation (business rule identified and validated)

The frontend and backend are now fully integrated for Driver Management, providing a functional CRUD workflow with proper database relationship handling.

---
# Week 4 - Day 5

## Objective
Complete the Driver Management module by implementing full CRUD operations and integrating the React frontend with Spring Boot REST APIs.

---

## Tasks Completed

### Driver Update Module
- Implemented Update Driver REST API.
- Implemented Get Driver By ID REST API.
- Added service methods for retrieving and updating driver details.
- Successfully tested update functionality using Swagger.

### React Frontend
- Added Edit button to the Driver List.
- Configured React Router navigation for editing drivers.
- Created Edit Driver page.
- Retrieved driver details using Driver ID.
- Pre-filled the edit form with existing driver information.
- Implemented Update Driver functionality using Axios.
- Redirected users back to Driver List after successful update.

### Integration
- Successfully integrated React frontend with Spring Boot backend.
- Verified CRUD operations through REST APIs.
- Tested Create, Read, Update and Delete operations successfully.

### Testing
- Tested Driver CRUD operations using both Swagger and React UI.
- Verified database updates in MySQL.
- Confirmed frontend-backend communication using Axios.

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- React.js
- React Router
- Axios
- Bootstrap
- Swagger OpenAPI
- Git

---

## Outcome

Successfully completed the Driver Management module with full CRUD functionality. The React frontend is fully integrated with the Spring Boot backend, allowing users to create, view, update and delete driver records through a responsive user interface.

## JWT Authentication & Role-Based Access Control

### Completed Tasks

- Implemented Spring Security.
- Added JWT Authentication.
- Created User Registration API.
- Created User Login API.
- Implemented BCrypt password encryption.
- Generated and validated JWT tokens.
- Added JwtFilter for authentication.
- Implemented CustomUserDetailsService.
- Configured stateless session management.
- Enabled method-level security using @EnableMethodSecurity.
- Applied @PreAuthorize annotations to secure REST APIs.
- Implemented Role-Based Access Control (RBAC).

### Roles

- ADMIN
- DISPATCHER
- DRIVER

### Secured Modules

- Driver Management
- Vehicle Management
- Route Management
- Delivery Task Management

### Result

Users can access APIs only according to their assigned roles. Unauthorized requests are rejected by Spring Security.

Procedure to Run the Project

Include this section in your project README or documentation.

Prerequisites
Java 21
Maven 3.9+
MySQL 8
Eclipse/VS Code
Postman or Swagger UI
Step 1: Create Database
CREATE DATABASE fleet_management;
Step 2: Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/fleet_management
spring.datasource.username=root
spring.datasource.password=your_password
Step 3: Build Project
mvn clean install
Step 4: Run Application
mvn spring-boot:run

or run the main class:

FleetManagementApplication.java
Step 5: Open Swagger
http://localhost:8081/swagger-ui/index.html
Step 6: Register a User

Use:

POST /auth/register

Example:

{
  "username": "admin",
  "password": "admin123",
  "role": "ADMIN"
}
Step 7: Login
POST /auth/login

Example:

{
  "username": "admin",
  "password": "admin123"
}

Response:

{
  "token": "eyJhbGc..."
}
Step 8: Authorize in Swagger

Click Authorize.

Enter:

Bearer <JWT_TOKEN>

Example:

Bearer eyJhbGc...

Click Authorize.

Step 9: Test Protected APIs

Use the authenticated token to access secured endpoints based on the user's role.

Security Flow
Register User
      │
      ▼
Password Encrypted (BCrypt)
      │
      ▼
Login
      │
      ▼
JWT Token Generated
      │
      ▼
Client Stores Token
      │
      ▼
Authorization Header
Bearer <token>
      │
      ▼
JwtFilter Validates Token
      │
      ▼
Spring Security Authenticates User
      │
      ▼
@PreAuthorize Checks Role
      │
      ▼
Access Granted / 403 Forbidden