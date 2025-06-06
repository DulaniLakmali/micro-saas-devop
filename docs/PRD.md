📘 Product Requirements Document (PRD)
Project: Micro SaaS Web Application
Author: Dulani Lakmali
Course: System Administration & Maintenance | IT31023
Date: June 2025

1. Executive Summary
This Micro SaaS platform connects Consultants with Seekers through a simplified booking and profile system. Admins manage users and system configurations. The product supports role-based access and scalable backend architecture, integrating DevOps best practices for maintainability and deployment.

2. Problem Statement
There is a lack of simple, affordable platforms for consultants to offer services to clients directly. Existing platforms are either too generic or overly complex. This project offers a minimal but functional platform that can be extended into a real-world SaaS solution.

3. Goals and Objectives
- Build a fully functional MVP for a SaaS app with Admin, Consultant, and Seeker roles.
- Implement core DevOps practices: CI/CD, security scanning, modular design.
- Ensure clean separation between frontend (UI), backend (logic), and database (storage).

4. Target Users

Seeker:
- Wants to find and book consultants
- Uses a web browser
- Views consultant profiles and submits requests

Consultant:
- Offers services (e.g., advice, coaching)
- Logs in to manage profile and view bookings
- Receives notifications of new consultation requests

Admin:
- Manages users (approve, ban, assign roles)
- Views system statistics
- Maintains system settings

5. User Journey 
Seeker → Browse consultants → View profile → Submit booking request → Wait for response
Consultant → Login → View dashboard → Accept/reject requests
Admin → Login → View user list → Approve or disable accounts

6. Features
- User registration/login
- Role-based dashboard
- Consultant profile management
- Consultation request system
- Admin user management
- Responsive web interface

7. MVP Scope
In-Scope:
- Static frontend
- Spring Boot backend
- MySQL DB
- Manual authentication (optional)
- Basic request flow

Out-of-Scope:
- Real-time chat
- Online payments
- Notifications (email/SMS)

8. Assumptions and Constraints
- Internet access is required for users
- Platform is currently not monetized
- Single-language UI (English)
- Deployment is manual or local for MVP

9. Success Criteria
- App deploys and functions without critical bugs
- CI/CD runs without errors on every push
- PRD + technical docs completed and submitted
- Architecture follows modular DevOps principles
