package com;

public class Fizzbuzz 
{
    public String convert( int number )
    {
        if(number%15==0) { return "fizzbuzz"; }
        if(number%3==0) { return "fizz"; }
        if(number%5==0) { return "buzz"; }
        return String.valueOf(number);
    }
}
