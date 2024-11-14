package com.akash.QuizApp.controller;

import com.akash.QuizApp.Exception.NotFoundException;
import com.akash.QuizApp.Request.UpdateRequest;
import com.akash.QuizApp.Response.ApiResponse;
import com.akash.QuizApp.model.Question;
import com.akash.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestion")
    public List<Question> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @GetMapping("/category/{categoryName}")
    public List<Question> getQuestionByCategory(@PathVariable String categoryName){
        return questionService.getQuestionByCategory(categoryName);
    }

    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> UpdateQuestion(@PathVariable Integer id, @RequestBody UpdateRequest question){
        try {
            Question UpQuestion = questionService.UpdateQuestion(question, id);
            return ResponseEntity.ok(new ApiResponse("Question Update Successfully", UpQuestion));
        } catch (NotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> DeleteQuestion(@PathVariable Integer id){
        try {
            questionService.DeleteQuestion(id);
            return ResponseEntity.ok(new ApiResponse("Question deleted successfully", null));
        }
        catch (NotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
