package com.postgresapp.postgres.repository;

import com.postgresapp.postgres.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}