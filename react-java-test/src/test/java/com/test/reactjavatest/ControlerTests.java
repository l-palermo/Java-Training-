package com.test.reactjavatest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ControlerTests {
	Controler controler;

	@BeforeEach
	public void initialize()
	{
		controler = new Controler();
	}
	@Test
	void helloFunction() {
		String response = "Hello, we are finally online" + new Date();
		assertEquals(response, controler.hello());
	}
	@Test
	void ciaoFunction() {
		String response = "this is the backend data from the above route";
		assertEquals(response, controler.ciao());
	}
}
