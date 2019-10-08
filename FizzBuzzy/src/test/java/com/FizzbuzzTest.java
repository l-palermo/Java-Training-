package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class  FizzbuzzTest
{
    @Test
    public void shouldLeaveTheNormalNumbersUntouched()
    {
        Fizzbuzz fizzbuzz = new Fizzbuzz();
        assertEquals("1", fizzbuzz.convert(1));
        assertEquals("2", fizzbuzz.convert(2));
    }

    @Test
    public void returnsFizzforNumbersMultipleOf3()
    {
        Fizzbuzz fizzbuzz = new Fizzbuzz();
        assertEquals("fizz", fizzbuzz.convert(3));
    }
    @Test
    public void returnsBuzzforNumbersMultipleOf5()
    {
        Fizzbuzz fizzbuzz = new Fizzbuzz();
        assertEquals("buzz", fizzbuzz.convert(5));
    }
    @Test
    public void returnsFizzbuzzforNumbersMultipleOf15()
    {
        Fizzbuzz fizzbuzz = new Fizzbuzz();
        assertEquals("fizzbuzz", fizzbuzz.convert(15));
    }
}
