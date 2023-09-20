package fr.test.numbers;


import  org.junit.jupiter.api.*;
import  static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberWorkerTest {

    private final NumberWorker underTest; // Declare the object at the class level

    public NumberWorkerTest() {
        underTest = new NumberWorker(); // Instantiate the object in the constructor
    }
    @ParameterizedTest
    @ValueSource(ints = { 3 , 5, 7})
    void shouldReturnTrueForPrimes(int number) {
        //given
        //when
        boolean expected = underTest.isPrime(number);

        //expected
        assertTrue(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = { 4 , 6, 10})
    void shouldReturnFalseForNotPrimes(int number) {
        //given
        //when
        boolean expected = underTest.isPrime(number);

        //expected
        assertFalse(expected);
    }
    @ParameterizedTest
    @ValueSource(ints = {0, 1, -10})
    void shouldThrowIllegalArgumenExceptionForIncorrectNumbers(int number) {
        assertThrows(IllegalArgumentException.class, () -> {
            underTest.isPrime(number);
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv") // Path to your CSV file
    void shouldReturnCorrectDigitsSum(int number , int expected) {
        //given
        //when
        int result = underTest.digitsSum(number);

        //expected
        assertEquals(expected, result);
    }
}