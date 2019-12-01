package com.postgresapp.postgres.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.postgresapp.postgres.model.Answer;
import com.postgresapp.postgres.model.Question;
import com.postgresapp.postgres.repository.AnswerRepository;
import com.postgresapp.postgres.repository.QuestionRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerControllerTest {

  @MockBean
  public AnswerRepository answerRepositoryMock;
  @MockBean
  public QuestionRepository questionRepositoryMock;
  @Autowired
  AnswerController answerController;

  Question questionMock;
  Answer answerMock;

  @BeforeEach
  public void initialize() {
    questionMock = mock(Question.class);
    answerMock = mock(Answer.class);
  }
  @Test
  public void returnAnswersGivenQuestionId() {
    List<Answer> answers = new ArrayList<Answer>();
    when(answerRepositoryMock.findByQuestionId(anyLong())).thenReturn(answers);
    assertEquals(answers, answerController.getAnswerByQuestionId(anyLong()));
  }
  @Test
  public void createAnswer() {
    Optional<Question> question = Optional.of(questionMock);
    when(questionRepositoryMock.findById(anyLong())).thenReturn(question);
    doNothing().when(answerMock).setQuestion(any(Question.class));
    when(answerRepositoryMock.save(any(Answer.class))).thenReturn(answerMock);
    assertEquals(answerMock, answerController.createAnswer(anyLong(), answerMock));
  }
}