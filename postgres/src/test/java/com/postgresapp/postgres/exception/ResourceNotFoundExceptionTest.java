package com.postgresapp.postgres.exception;

import org.junit.jupiter.api.Test;

public class ResourceNotFoundExceptionTest {
  @Test
  public void returnExceptionMessage() {
    new ResourceNotFoundException("test");
  }
}