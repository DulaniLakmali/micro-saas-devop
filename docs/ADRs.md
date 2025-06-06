Architectural Decision Records (ADRs)

Project: Micro SaaS Web Application
Author: Dulani Lakmali
Course: System Administration & Maintenance | IT31023
Date: June 2025

ADR 1: Use of Java Spring Boot for Backend
Status: Accepted
Context: The backend needs a robust, enterprise-ready framework.
Decision: Java Spring Boot was chosen for its maturity, security, and strong ecosystem.
Consequences: Enables modular design, REST API support, but requires more memory and setup than lightweight frameworks.

ADR 2: Use of HTML/CSS/JavaScript for Frontend
Status: Accepted
Context: The frontend is a simple interface that does not require a modern JS framework.
Decision: Vanilla HTML/CSS/JS was chosen for simplicity and speed of development.
Consequences: Lightweight, fast to deploy, but lacks scalability and maintainability for complex UIs.

ADR 3: MySQL as the Primary Database
Status: Accepted
Context: The application needs a relational database with widespread support.
Decision: MySQL was chosen due to familiarity, open-source nature, and easy integration with Spring Boot.
Consequences: Strong consistency, easy to back up, but less flexible than NoSQL for highly dynamic schemas.

ADR 4: GitHub Actions for CI/CD
Status: Accepted
Context: The project requires continuous integration and testing on code push.
Decision: GitHub Actions was chosen due to its tight integration with GitHub and simplicity.
Consequences: Easy to manage workflows in-repo, no third-party CI tool required.
