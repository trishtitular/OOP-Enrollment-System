package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.CacheRequest;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void shouldAddCorrectAnswer(){
        // Arrange
        /*Calculator calculator = new Calculator();*/ // use @BeforeEach para di magredundant

        //Act
//       calculator.add(10,2);
        //Assert
        assertEquals(12,calculator.add(10,2));
    }
    @Test
    void shouldSubtractTwoNumbers(){
        /*Calculator calculator = new Calculator();*/
      /*  calculator.subtraction(10,2);*/

        assertEquals(8,calculator.subtraction(10,2));

    }
    @Test
    void shouldMultiplyCorrectAnswer(){
        /*Calculator calculator = new Calculator();*/
        /*calculator.multiplication(5,2);*/
        assertEquals(10,calculator.multiplication(5,2));
    }
    @Test
    void shouldDivideCorrectAnswer(){
        /*Calculator calculator = new Calculator();*/
        /*calculator.division(10,2);*/
        assertEquals(5,calculator.division(10,2));
    }

}