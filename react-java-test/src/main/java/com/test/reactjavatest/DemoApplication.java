package com.test.reactjavatest;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {
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
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
