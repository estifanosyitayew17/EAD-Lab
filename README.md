# 🚀 Enterprise Application Development - Lab 1

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.8+-orange.svg)](https://maven.apache.org/)
[![CI](https://github.com/estifanosiyatew17/EAD-Lab/actions/workflows/ci.yml/badge.svg)](https://github.com/estifanosiyatew17/EAD-Lab/actions/workflows/ci.yml)
[![H2 Database](https://img.shields.io/badge/Database-H2-blue.svg)](https://www.h2database.com/)
[![License](https://img.shields.io/badge/License-Educational-yellow.svg)](LICENSE)

---

## 📚 Course Information

| **Course** | Enterprise Application Development (EAD) |
|------------|-------------------------------------------|
| **Institution** | Addis Ababa University, CTBE |
| **Program** | Software Engineering |
| **Lab** | #1 - Hello Enterprise World with Spring Boot |
| **Author** | Estifanos Yitayew |
| **Semester** | 2026 |

---

## 🎯 Lab Overview

This lab demonstrates building a **production-style REST API** using the Spring Boot framework. The completed microservice exposes HTTP endpoints, persists data to an embedded database, is covered by unit tests, and is automatically built by a CI pipeline — all hallmarks of **enterprise-grade software**.

### Learning Objectives Achieved ✅

- [x] Generate Spring Boot project from Spring Initializr
- [x] Implement layered enterprise architecture
- [x] Build REST API with `@RestController`, `@GetMapping`, `@PostMapping`
- [x] Map Java classes to database tables using Spring Data JPA
- [x] Write clean Service layer with business logic
- [x] Create unit tests with JUnit 5 and Mockito
- [x] Configure GitHub Actions CI pipeline

---

## 📁 Project Structure
EAD-Lab/
├── 📄 README.md                    # Project documentation
├── 📁 .github/
│   └── 📁 workflows/
│       └── 📄 ci.yml               # GitHub Actions CI pipeline
├── 📁 product-service/             # Main Spring Boot application
│   ├── 📁 src/
│   │   ├── 📁 main/
│   │   │   ├── 📁 java/com/ctbe/estifanos/
│   │   │   │   ├── 📁 controller/     # REST endpoints
│   │   │   │   │   ├── ProductController.java
│   │   │   │   │   └── HealthController.java
│   │   │   │   ├── 📁 service/        # Business logic
│   │   │   │   │   └── ProductService.java
│   │   │   │   ├── 📁 repository/     # Data access layer
│   │   │   │   │   └── ProductRepository.java
│   │   │   │   ├── 📁 model/          # Entity classes
│   │   │   │   │   └── Product.java
│   │   │   │   └── ProductServiceApplication.java
│   │   │   └── 📁 resources/
│   │   │       └── application.properties
│   │   └── 📁 test/               # Unit tests
│   │       └── ProductServiceTest.java
│   └── 📄 pom.xml                 # Maven configuration
└── 📁 product-service-mvn/        # Additional lab materials


---

## 🏗️ Architecture Overview

The application follows **layered architecture** with clear separation of concerns:



┌─────────────────────────────────────────────────────────────┐
│                    HTTP Request/Response                     │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│  CONTROLLER LAYER                                            │
│  • Receives HTTP requests                                    │
│  • Validates input                                           │
│  • Returns HTTP responses (JSON)                             │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│  SERVICE LAYER                                               │
│  • Implements business logic                                 │
│  • Orchestrates repository calls                             │
│  • Throws domain-specific exceptions                         │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│  REPOSITORY LAYER                                            │
│  • Handles all database operations                           │
│  • Extends JpaRepository for CRUD methods                    │
│  • No business logic here                                    │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│  DATABASE (H2)                                               │
│  • In-memory database                                        │
│  • Auto-creates/drops tables                                 │
└─────────────────────────────────────────────────────────────┘

---

## 🚀 Getting Started

### Prerequisites

| Tool | Version | Purpose |
|------|---------|---------|
| Java (JDK) | 17+ | Compiles and runs the application |
| Apache Maven | 3.8+ | Builds, tests, and packages the project |
| Git | 2.x+ | Version control |
| IDE | IntelliJ/VS Code | Code editor (optional) |

### Installation & Setup

```bash
# Clone the repository
git clone https://github.com/estifanosiyatew17/EAD-Lab.git

# Navigate to project directory
cd EAD-Lab/product-service

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run