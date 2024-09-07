package com.akash.QuizApp.controller;

import com.akash.QuizApp.model.Question;
import com.akash.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestion")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("/update")
    public ResponseEntity<String> UpdateQuestion(@RequestBody Question question){
      return questionService.UpdateQuestion(question);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteQuestion(@PathVariable Integer id){
       return questionService.DeleteQuestion(id);
    }
}
