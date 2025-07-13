# QuizApp

QuizApp is a backend service for managing quizzes, questions, and user responses. Built with Spring Boot, Spring Data JPA, and MySQL, it provides RESTful APIs for creating, managing, and taking quizzes.

## Features

- **Quiz Management:** Create, retrieve, and submit quizzes.
- **Question Management:** Add, update, delete, and list questions by category.
- **User Response Handling:** Submit and evaluate quiz answers.
- **Scoring System:** Automatically calculate and return quiz scores.
- **Database Integration:** Persistent storage using MySQL with Spring Data JPA.

## Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL Database

## Requirements

- Java Development Kit (JDK) 17 or higher
- Maven
- MySQL (or another supported database)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/m-akash/QuizApp.git
cd QuizApp
```

### 2. Configure the Database

Edit `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/QuizApp
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and Run the Project

```bash
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8080/` by default.

---

## API Endpoints

### Question Management

- **Get all questions**

  - `GET /question/allQuestion`
  - **Response:**
    ```json
    [
      {
        "id": 1,
        "questionTitle": "What is Java?",
        "option1": "Language",
        "option2": "OS",
        "option3": "IDE",
        "option4": "Browser",
        "rightAnswer": "Language",
        "difficulty_level": "Easy",
        "category": "Programming"
      }
    ]
    ```

- **Get questions by category**

  - `GET /question/category/{categoryName}`

- **Add a question**

  - `POST /question/add`
  - **Request Body:**
    ```json
    {
      "questionTitle": "What is Java?",
      "option1": "Language",
      "option2": "OS",
      "option3": "IDE",
      "option4": "Browser",
      "rightAnswer": "Language",
      "difficulty_level": "Easy",
      "category": "Programming"
    }
    ```

- **Update a question**

  - `PUT /question/update/{id}`
  - **Request Body:** (same as above)

- **Delete a question**
  - `DELETE /question/delete/{id}`

---

### Quiz Management

- **Create a quiz**

  - `POST /quiz/create?category={category}&numQ={numQ}&title={title}`
  - **Response:** `"Success"` or `"Unsuccessful attempt!"`

- **Get quiz questions**

  - `GET /quiz/get/{id}`
  - **Response:**
    ```json
    [
      {
        "id": 1,
        "questionTitle": "What is Java?",
        "option1": "Language",
        "option2": "OS",
        "option3": "IDE",
        "option4": "Browser"
      }
    ]
    ```

- **Submit quiz answers**
  - `POST /quiz/submit/{id}`
  - **Request Body:**
    ```json
    [
      { "id": 1, "response": "Language" },
      { "id": 2, "response": "Spring Boot" }
    ]
    ```
  - **Response:**
    ```json
    2
    ```
    (Number of correct answers)

---

## Data Models

### Question

| Field            | Type    | Description                          |
| ---------------- | ------- | ------------------------------------ |
| id               | Integer | Unique identifier                    |
| questionTitle    | String  | The question text                    |
| option1-4        | String  | Answer options                       |
| rightAnswer      | String  | Correct answer                       |
| difficulty_level | String  | Difficulty (e.g. Easy, Medium, Hard) |
| category         | String  | Category name                        |

### Quiz

| Field     | Type           | Description       |
| --------- | -------------- | ----------------- |
| id        | Integer        | Unique identifier |
| title     | String         | Quiz title        |
| questions | List<Question> | List of questions |

### Response

| Field    | Type    | Description   |
| -------- | ------- | ------------- |
| id       | Integer | Question ID   |
| response | String  | User's answer |

## 👨‍💻 Author

**Mehedi Hasan Akash**

- GitHub: [@m-akash](https://github.com/m-akash)
- LinkedIn: [Mehedi Hasan Akash](https://www.linkedin.com/in/mehedi-hasan-akash/)
