package com.postgresapp.postgres.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import com.postgresapp.postgres.model.Question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class QuestionRepositoryTest {

  @Autowired
  public QuestionRepository questionRepository;

  Question question;

  @BeforeEach
  public void initialize() {
    question = new Question();
    question.setTitle("test");
    question.setDescription("test");
    questionRepository.save(question);
  }

  @Test
  public void getQuestion() {
    Question questionDB = questionRepository.findAll().get(0);
    assertEquals(question, questionDB);
  }
  @Test
  public void createQuestion() {
    boolean questionExist = questionRepository.existsById(question.getId());
    assertEquals(true, questionExist);
  }
  @Test
  public void updateQuestion() {
    Question questionDB = questionRepository.getOne(question.getId());
    questionDB.setDescription("test1");
    questionRepository.save(question);
    Question updatedQuestion = questionRepository.getOne(question.getId());
    assertEquals("test1", updatedQuestion.getDescription());
  }
  @Test
  public void deleteQuestion() {
    questionRepository.deleteById(question.getId());
    boolean doNotExist = questionRepository.existsById(question.getId());
    assertEquals(false, doNotExist);
  }
}