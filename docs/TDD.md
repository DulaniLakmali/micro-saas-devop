🛠️ Technical Design Document (TDD)
Project: Micro SaaS Web Application
Author: Dulani Lakmali
Course: System Administration & Maintenance | IT31023
Date: June 2025

1. Overview
This document outlines the technical architecture, components, technology stack, and key design decisions behind the Micro SaaS application built for the System Administration & Maintenance course.

2. Objectives
- Build a scalable, maintainable SaaS platform for multiple user roles: Admin, Consultant, and Seeker.
- Implement core DevOps practices: CI/CD, security scanning, modular design.
- Ensure clean separation between frontend (UI), backend (logic), and data storage.

3. Technology Stack
Frontend: HTML, CSS, JavaScript
Backend: Java Spring Boot (REST API)
Database: MySQL
Version Control: Git + GitHub
CI/CD: GitHub Actions
Security: CodeQL for static analysis
Infrastructure: Localhost (dev), GitHub-hosted (build)

4. System Architecture (C4 Model)

4.1 Context Diagram
Describes the system and external actors (Admin, Consultant, Seeker).

4.2 Container Diagram
Describes how components (frontend, backend, database) interact.

4.3 Component Diagram
Describes internal structure of the Spring Boot backend.

5. Backend Design
5.1 API Architecture
- RESTful APIs using Spring Boot
- Layered structure:
  - Controller Layer: Handles HTTP requests (e.g., /api/users)
  - Service Layer: Business logic
  - Repository Layer: Interfaces with MySQL via JPA

5.2 API Example
POST /api/users
{
  "username": "dulani123",
  "email": "dulani@example.com"
}

5.3 Security
- Placeholder for Spring Security or token-based auth
- External auth service supported (e.g., Firebase, OAuth)

6. Frontend Design
- Static frontend (HTML/CSS/JS)
- Interfaces with backend through REST API
- Deployed independently (can be hosted via GitHub Pages or Netlify)

7. Database Design
Tables (Simplified):
users: id, username, email, password_hash
roles: id, name (Admin/Consultant/Seeker)
consultations: id, consultant_id, seeker_id, status
Relationships:
- users ↔ roles: Many-to-one
- consultations: Join between users

8. CI/CD Design
- CI: GitHub Actions
  - Node.js matrix testing for frontend
  - CodeQL scanning for vulnerabilities

9. Testing Strategy
Frontend: Planned (Jest or manual)
Backend: Planned (JUnit with Spring Boot)
Security: Done (GitHub CodeQL)

10. Future Improvements
- Add authentication (Spring Security + JWT)
- Deploy backend to cloud (e.g., AWS/GCP)
- Enable real-time chat between consultant and seeker
- Add automated tests (JUnit + Jest)
