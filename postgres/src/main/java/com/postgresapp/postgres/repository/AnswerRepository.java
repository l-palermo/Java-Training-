package com.postgresapp.postgres.repository;

import java.util.List;

import com.postgresapp.postgres.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
  List<Answer> findByQuestionId(Long questionId);
}