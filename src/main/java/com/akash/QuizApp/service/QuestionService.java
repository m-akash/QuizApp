package com.akash.QuizApp.service;

import com.akash.QuizApp.model.Question;
import com.akash.QuizApp.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionRepository.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new ResponseEntity<>("UnSuccess", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> UpdateQuestion(Question question) {
        try {
            questionRepository.save(question);
            return new ResponseEntity<>("Question updated successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new ResponseEntity<>("Sorry, Updated Request Failed!", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> DeleteQuestion(Integer id) {
        try {
            questionRepository.deleteById(id);
            return new ResponseEntity<>("Delete Successfully!", HttpStatus.OK);
        } catch (Exception e){
            e.fillInStackTrace();
        }
        return new ResponseEntity<>("Unsuccessfull attemped!", HttpStatus.BAD_REQUEST);
    }
}
