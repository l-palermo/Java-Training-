package com.postgresapp.postgres.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class AuditModelTest {
  AuditModel auditModel;
  Date date;

  @BeforeEach
  public void initialize() {
    auditModel = mock(AuditModel.class, Mockito.CALLS_REAL_METHODS);
    date = new Date();
  }
  @Test
  public void propertyCreatedAt() {
    auditModel.setCreatedAt(date);
    assertEquals(date, auditModel.getCreatedAt());
  }
  @Test
  public void propertyUpdatedAt() {
    auditModel.setUpdatedAt(date);
    assertEquals(date, auditModel.getUpdatedAt());
  }
}
