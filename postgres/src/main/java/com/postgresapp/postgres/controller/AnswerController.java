package com.postgresapp.postgres.controller;

import java.util.List;

import javax.validation.Valid;

import com.postgresapp.postgres.exception.ResourceNotFoundException;
import com.postgresapp.postgres.model.Answer;
import com.postgresapp.postgres.repository.AnswerRepository;
import com.postgresapp.postgres.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AnswerController {
  @Autowired
  private AnswerRepository answerRepository;
  @Autowired
  private QuestionRepository questionRepository;
  
  @GetMapping("/question/{questionId}/answer")
  public List<Answer> getAnswerByQuestionId(@PathVariable Long questionId) {
    return answerRepository.findByQuestionId(questionId);
  }
  @PostMapping("/question/{questionId}/answer")
  public Answer createAnswer(@PathVariable Long questionId, @Valid @RequestBody Answer answer) {
    return questionRepository.findById(questionId)
    .map(question -> {
      answer.setQuestion(question);
      return answerRepository.save(answer);
    }).orElseThrow(() -> new ResourceNotFoundException("question no found with id " + questionId));
  }
  @PutMapping("question/{questionId}/answer/{answerId}")
  public Answer updateAnswer(@PathVariable Long questionId, @PathVariable Long answerId,
  @Valid @RequestBody Answer answerRequest) {
    if(!questionRepository.existsById(questionId)) {
      throw new ResourceNotFoundException("Question not found with Id " + questionId);
    }
    return answerRepository.findById(answerId)
    .map(answer -> {
      answer.setText(answerRequest.getText());
      return answerRepository.save(answer);
    }).orElseThrow(() -> new ResourceNotFoundException("Question not found with Id " + questionId));
  }
  @DeleteMapping("/question/{questionid}/answer/{answerId}")
  public ResponseEntity<?> deleteAnswer(@PathVariable Long questionId, @PathVariable Long answerId) {
    if(!questionRepository.existsById(questionId)) {
      throw new ResourceNotFoundException("Question not found with Id " + questionId);
    }
    return answerRepository.findById(answerId)
    .map(answer -> {
      answerRepository.delete(answer);
      return ResponseEntity.ok().build();
    }).orElseThrow(() -> new ResourceNotFoundException("Answer not found with id " + answerId));
  }
}