package com.intersection.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by Tech Support on 1/29/2018.
 */
public class DemoApplicationImplTest {

    //2-Initializing a list of Integers using IntStream
    private List<Integer> list;


    @Before
    public void setUp() throws Exception {
        list = IntStream.range(1,21).distinct().boxed().collect(Collectors.toList());
    }

    @Test
    public void fizzBuzzStep1() throws Exception {

        String expectedValue1 = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
        String returnedValue1 = DemoApplicationImpl.FizzBuzzStep1(list);
        System.out.println("Expected value: " + expectedValue1);
        System.out.println("Result value  : " + returnedValue1);

        //Compare between the expected value and the returned
        assertEquals("Objects not equals", returnedValue1, expectedValue1);
    }

    @Test
    public void fizzBuzzStep2() throws Exception {

        String expectedValue2 = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz";
        String returnedValue2 = DemoApplicationImpl.FizzBuzzStep2(list);
        System.out.println("Expected value: " + expectedValue2);
        System.out.println("Result value  : " + returnedValue2);

        assertEquals("Objects not equals", returnedValue2, expectedValue2);
        //Print object.
        System.out.println(returnedValue2);
    }

    @Test
    public void fizzBuzzStep3() throws Exception {

        String expectedValue3 = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz\n" +
                "fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10";
        String returnedValue3 = DemoApplicationImpl.FizzBuzzStep3(list);
        assertEquals("Objects not equals", returnedValue3, expectedValue3);
        //Print object.
        System.out.println(returnedValue3);
    }

}