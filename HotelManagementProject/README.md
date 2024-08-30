##  Hotel Management System Project

### Contributors
- Sammak Ahmed
- Bilal Nazar
- Russel Ngo
- Sandeep Virk
- Jared Batallones

### Video
[![Demo](https://drive.google.com/file/d/1lNEvZy95et4TXu6dPgeJXw4l95Sj5X8T/view?usp=drive_link)](https://drive.google.com/file/d/1lNEvZy95et4TXu6dPgeJXw4l95Sj5X8T/view?usp=drive_link)
### Important Instructions

- **Submission Deadline:** April 4, 2024
- **Submission Method:** Submit the .zip file of the project on Canvas. Each team member must submit individually.
- **Presentation Date:** April 4, 2024 (In-person presentation schedule will be provided later).

### 1. Project Introduction

Welcome to the Hotel Management System project for CSCI 3240 Web Application Development course. This project aims to introduce you to web application development fundamentals using Spring Boot, HTML, CSS, Object-Oriented Programming, and Database concepts. You will develop a comprehensive system to manage hotel operations, including room handling, bookings, customer management, and service provision.

#### 1.1 Project General Requirements

- **IDE:** VS Code, Eclipse
- **Build Tool:** Maven
- **Backend Framework:** Spring Boot
- **Database:** H2
- **ORM:** Spring Data JPA
- **Frontend:** Thymeleaf, HTML, CSS
- **Java Version:** 8 or above

#### 1.2 Project Specification

Your application must include the following components:

**Models:**
- Customer
- Room
- Booking
- ProvidedService

**Repositories:**
- Interfaces for each model to extend JpaRepository.

**Services:**
- Service classes for business logic related to each model.

**Controllers:**
- Controllers to handle HTTP requests for each model.

**Templates:**
- Thymeleaf templates for displaying and managing each model.

**Tables:**
- H2 database tables corresponding to each model.

### 4. Project Rubric

Total Marks Available: 34%

#### 4.1 Backend Development (Total Marks = 18.8%)

- Model Classes (5%)
- Repository Interfaces (4%)
- Service Classes (4%)
- Controller Classes (5.8%)

#### 4.2 Frontend Development with HTML and CSS (Total Marks = 10.2%)

- HTML Templates (6%)
- Navigation and Usability (2%)
- Styling with CSS (2.2%)

#### 4.3 Code Quality and Organization (5%)

- Readability (2.5%)
- Structure (2.5%)

#### 4.4 Submission Requirements

Submit your project as a `.zip` file through Canvas, including all source code for both backend and frontend components, along with any additional resources utilized. Ensure your submission includes a `README.md` file detailing instructions on how to run your project and any other relevant documentation.

### 5. How to Run
- First, export project onto Eclipse or other IDE (Assuming Eclipse)
- Then, Right Click project and Run As Maven Clean
- Then, Run As Maven Install
- Then, Run as Maven Build and put "compile" in the text box
- Then, Run As Java Application and locate HotelManagementProjectApplication
- Let it run, and it should say that server started on localhost:8080 or something along those lines
- Just go to localhost:8080 on your browser and the website should be up and running.

