package com.test.reactjavatest;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
  @GetMapping("/api")
  public String hello()
  {
    return "Hello, we are finally online" + new Date();
  }
  @GetMapping("/first")
  public String ciao()
  {
    return "this is the backend data from the above route";
  }
}