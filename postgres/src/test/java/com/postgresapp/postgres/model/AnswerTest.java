package com.postgresapp.postgres.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnswerTest {
  Answer answer;
  @BeforeEach
  public void initialize() {
    answer = new Answer();
  }
  @Test
  public void propertyId() {
    long id = 1001;
    answer.setId(id);
    assertEquals(id , answer.getId());
  }
  @Test
  public void propertyText() {
    String string = "test";
    answer.setText(string);
    assertEquals(string, answer.getText());
  }
  @Test
  public void propertyQuestion() {
    Question questionMock = mock(Question.class);
    answer.setQuestion(questionMock);
    assertEquals(questionMock, answer.getQuestion());
  }
}
