package com;

import org.junit.*;

public class RunFizzbuzzTest
{
  @Test
  public void returnsFizzbuzzes()
  {
    Fizzbuzz fizzbuzz = new Fizzbuzz();

    for(int i=1; i<=100; i++) {
      System.out.println(fizzbuzz.convert(i));
    }
  }
}