package com.akash.QuizApp.service;

import com.akash.QuizApp.Exception.NotFoundException;
import com.akash.QuizApp.Request.UpdateRequest;
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

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionByCategory(String categoryName) {
        return questionRepository.findByCategory(categoryName);
    }

    public Question addQuestion(Question question) {
       return questionRepository.save(question);
    }

   public Question UpdateQuestion(UpdateRequest question, Integer id) {
        return questionRepository.findById(id)
                .map(Exisquestion -> UpdateExistingQuestion(Exisquestion, question))
                .map(questionRepository::save)
                .orElseThrow(() -> new NotFoundException("Question Not Found!"));
   }
   public Question UpdateExistingQuestion(Question existingQuestion, UpdateRequest updateRequest) {
        existingQuestion.setQuestionTitle(updateRequest.getQuestionTitle());
        existingQuestion.setOption1(updateRequest.getOption1());
        existingQuestion.setOption2(updateRequest.getOption2());
        existingQuestion.setOption3(updateRequest.getOption3());
        existingQuestion.setOption4(updateRequest.getOption4());
        existingQuestion.setRightAnswer(updateRequest.getRightAnswer());
        existingQuestion.setDifficulty_level(updateRequest.getDifficulty_level());
        existingQuestion.setCategory(updateRequest.getCategory());
        return existingQuestion;
   }

    public void DeleteQuestion(Integer id) {
        questionRepository.findById(id).ifPresentOrElse(questionRepository::delete,
                () -> {
                    throw new NotFoundException("Question Not Found!");
                });
    }
}
