package com.postgresapp.postgres.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.postgresapp.postgres.model.Question;
import com.postgresapp.postgres.repository.QuestionRepository;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionControllerTest {
  @MockBean
  QuestionRepository questionRepositoryMock;
  @Autowired
  QuestionController questionController;

  Question questionMock;
  Optional<Question> questionOpt;

  @BeforeEach
  public void initialize() {
    questionMock = mock(Question.class);
    questionOpt = Optional.of(questionMock);
  }

  @Test
  public void getQuestions() {
    Page<Question> page = Page.empty();
    when(questionRepositoryMock.findAll(any(Pageable.class))).thenReturn(page);
    assertEquals(page, questionController.getQuestions(any(Pageable.class)));
  }
  @Test
  public void createQuestion() {
    when(questionRepositoryMock.save(questionMock)).thenReturn(questionMock);
    assertEquals(questionMock, questionController.createQuestion(questionMock));
  }
  @Test
  public void updateQuestion() {
    when(questionRepositoryMock.findById(anyLong())).thenReturn(questionOpt);
    doNothing().when(questionMock).setTitle(anyString());
    doNothing().when(questionMock).setDescription(anyString());
    when(questionRepositoryMock.save(questionMock)).thenReturn(questionMock);
    assertEquals(questionMock, questionController.updateQuestion(anyLong(), questionMock));
  }
  @Test
  public void deleteQuestion() {
    when(questionRepositoryMock.findById(anyLong())).thenReturn(questionOpt);
    doNothing().when(questionRepositoryMock).delete(questionMock);
    assertEquals(ResponseEntity.ok().build(), questionController.deleteQuestion(anyLong()));
  }
}