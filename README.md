# QuizApp

A backend service for managing quizzes, questions, and user responses. Built using Spring Boot and Spring Data JPA and MySQL, this project provides RESTful APIs for a Quiz Application.

# Features

Quiz Management: Create, update, and delete quizzes.
Question Management: Add, edit, and remove questions for quizzes.
User Response Handling: Submit and evaluate quiz answers.
Scoring System: Automatically calculate and store quiz scores.
Database Integration: Persistent storage using MySQL with Spring Data JPA.

# Technologies Used

Spring Boot
Spring Data JPA
Hibernate
MySQL Database
Java 17 (or any supported version)

# Requirements

To run the project locally, ensure you have the following installed:

Java Development Kit (JDK) 17 or higher
Maven (for dependency management)
Optional: MySQL (if not using H2)

# Clone the Repository

git clone https://github.com/m-akash/QuizApp.git

# Configure Database

Update application.properties with your MySQL configurations:

spring.datasource.url=jdbc:mysql://localhost:3306/your_database  
spring.datasource.username=your_username  
spring.datasource.password=your_password  
spring.jpa.hibernate.ddl-auto=update  

# Build and Run the Project

mvn clean install  
mvn spring-boot:run  
