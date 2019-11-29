package com.postgresapp.postgres.controller;

import javax.validation.Valid;

import com.postgresapp.postgres.exception.ResourceNotFoundException;
import com.postgresapp.postgres.model.Question;
import com.postgresapp.postgres.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
  @Autowired
  private QuestionRepository questionRepository;
  
  @GetMapping("/questions")
  public Page<Question> getQuestions(Pageable pageable) {
    return questionRepository.findAll(pageable);
  }
  @PostMapping("/questions")
  public Question createQuestion(@Valid @RequestBody Question question) {
    return questionRepository.save(question);
  }
  @PutMapping("/question/{questionId}")
  public Question updateQuestion(@PathVariable Long questionId,
    @Valid @RequestBody Question questionRequest) {
    return questionRepository.findById(questionId)
    .map(question -> {
      question.setTitle(questionRequest.getTitle());
      question.setDescription(questionRequest.getDescription());
      return questionRepository.save(question);
    }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
  }
  @DeleteMapping("/question/{questionId}")
  public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
    return questionRepository.findById(questionId)
    .map(question -> {
      questionRepository.delete(question);
      return ResponseEntity.ok().build();
    }).orElseThrow(() -> new ResourceNotFoundException("question not found with Id" + questionId));
  }
}