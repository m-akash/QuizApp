package com.akash.QuizApp.Response;

import com.akash.QuizApp.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private Question Data;
}
