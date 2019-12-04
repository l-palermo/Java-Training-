package com.postgresapp.postgres.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuestionTest {
  Question question;
  @BeforeEach
  public void initialize() {
    question = new Question();
  }
  @Test
  public void propertyId() {
    long id = 1100;
    question.setId(id);
    assertEquals(id, question.getId());
  }
  @Test
  public void propertyTitle() {
    String title = "test";
    question.setTitle(title);
    assertEquals(title, question.getTitle());
  }
  @Test
  public void propertyDescription() {
    String description = "test";
    question.setDescription(description);
    assertEquals(description, question.getDescription());
  }
}
