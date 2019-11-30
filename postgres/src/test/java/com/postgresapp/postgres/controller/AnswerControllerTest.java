package com.postgresapp.postgres.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.postgresapp.postgres.model.Answer;
import com.postgresapp.postgres.repository.AnswerRepository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerControllerTest {

  @MockBean
  public AnswerRepository answerRepositoryMock;

  @Autowired
  AnswerController answerController;

  @Test
  public void returnAnswerGivenId() {
    long numb = 110101;
    List<Answer> answers = new ArrayList<Answer>();;
    System.out.println(answerRepositoryMock);
    when(answerRepositoryMock.findByQuestionId(anyLong())).thenReturn(answers);
    assertEquals(answerController.getAnswerByQuestionId(numb), answers);
  }
}