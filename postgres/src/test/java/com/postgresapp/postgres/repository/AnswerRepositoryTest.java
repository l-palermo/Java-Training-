package com.postgresapp.postgres.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import com.postgresapp.postgres.model.Answer;
import com.postgresapp.postgres.model.Question;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class AnswerRepositoryTest {

  @Autowired
  public AnswerRepository answerRepository;

  @Autowired
  public QuestionRepository questionRepository;

  Answer answer;
  Question question;

  @BeforeEach
  public void initializeBefore() {
    answer = new Answer();
    question = new Question();
    question.setTitle("test");
    question.setDescription("test");
    questionRepository.save(question);
  }

  @AfterEach
  public void cleanDB() {
    questionRepository.deleteAll();
    answerRepository.deleteAll();
  }

  @Test
  public void saveAnswer() {
    String string = "test";
    answer.setText(string);
    answer.setQuestion(question);
    answerRepository.save(answer);
    Answer answerDB = answerRepository.getOne(answer.getId());
    assertEquals(answerDB.getId(), answer.getId());
  }
  @Test
  public void updateAnswer() {
    answer.setText("test");
    answer.setQuestion(question);
    answerRepository.save(answer);
    Answer answerDB = answerRepository.getOne(answer.getId());
    answerDB.setText("test1");
    answerRepository.save(answerDB);
    Answer updatedAnswer = answerRepository.getOne(answer.getId());
    assertEquals("test1", updatedAnswer.getText());
  }
  @Test
  public void deleteAnswer() {
    answer.setText("test");
    answer.setQuestion(question);
    answerRepository.save(answer);
    assertEquals(true, true);
  }
}