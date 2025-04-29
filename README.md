# DsCatalog - Product Management System

A comprehensive product catalog management system built with Spring Boot and modern best practices.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [Development](#development)
- [Testing](#testing)
- [Deployment](#deployment)
- [Monitoring](#monitoring)
- [Security](#security)
- [Contributing](#contributing)
- [License](#license)

## Features
- RESTful API for product management
- Secure authentication and authorization
- Real-time monitoring and logging
- Caching for improved performance
- Comprehensive testing suite
- CI/CD pipeline integration
- Containerized deployment
- Health checks and metrics
- Circuit breaker pattern
- Rate limiting
- Input validation
- Proper error handling
- Comprehensive documentation

## Technologies
- **Backend**:
  - Java 17
  - Spring Boot 2.6.4
  - Spring Data JPA
  - Spring Security
  - Spring Cloud
  - H2 Database (Development)
  - PostgreSQL (Production)
  - Redis (Caching)
  - Resilience4j (Circuit Breaker)
  - Prometheus & Grafana (Monitoring)
  - Swagger/OpenAPI (Documentation)
  - JUnit 5 & Mockito (Testing)
  - Maven (Build)
  - Docker (Containerization)

## Architecture
The project follows a layered architecture:
```
com.chipset.dscatalog
├── config/           # Configuration classes
├── controller/       # REST controllers
├── service/          # Business logic
├── repository/       # Data access
├── model/           # Domain entities
├── dto/             # Data Transfer Objects
├── exception/       # Custom exceptions
├── security/        # Security configuration
├── util/            # Utility classes
└── resources/       # Configuration files
```

## Getting Started

### Prerequisites
- JDK 17
- Maven 3.6+
- Docker & Docker Compose
- Git

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/josivantarcio/dscatalog.git
   cd dscatalog
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application:
   - API: http://localhost:8080
   - Swagger UI: http://localhost:8080/swagger-ui.html
   - H2 Console: http://localhost:8080/h2-console
   - Prometheus: http://localhost:9090
   - Grafana: http://localhost:3000

## Development

### Coding Standards
- Follow Java Code Conventions
- Use meaningful names
- Write comprehensive comments
- Follow SOLID principles
- Implement proper error handling
- Write unit tests
- Use proper logging

### Branch Strategy
- main: Production code
- develop: Development code
- feature/*: New features
- bugfix/*: Bug fixes
- release/*: Release preparation

### Commit Messages
Follow conventional commits:
- feat: New feature
- fix: Bug fix
- docs: Documentation
- style: Formatting
- refactor: Code refactoring
- test: Testing
- chore: Maintenance

## Testing
- Unit Tests: `mvn test`
- Integration Tests: `mvn verify`
- Coverage Report: `mvn site`

## Deployment
1. Build Docker image:
   ```bash
   docker build -t dscatalog .
   ```

2. Run with Docker Compose:
   ```bash
   docker-compose up -d
   ```

## Monitoring
- Prometheus metrics
- Grafana dashboards
- Spring Boot Actuator
- Health checks
- Log aggregation

## Security
- JWT authentication
- Role-based authorization
- Input validation
- Rate limiting
- CORS configuration
- Secure headers
- Password encryption

## Contributing
1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
