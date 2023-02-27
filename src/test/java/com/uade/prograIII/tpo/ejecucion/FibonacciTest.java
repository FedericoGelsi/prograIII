package com.uade.prograIII.tpo.ejecucion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    private Fibonacci uut;

    @BeforeEach
    void setUp() {
        uut = new Fibonacci();
    }

    @Test
    public void fibonacci_ShouldThrowIllegalArgumentException_WhenNisNegative(){
        // Arrange
        int negativeValue = -1;
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> uut.fibonacci(negativeValue));
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,1", "3,2", "4,3", "5,5", "6,8", "7,13", "8,21", "15,610"})
    public void fibonacci_shouldReturnExpectedValues(int inputValue, int expected){
        // Act
        int actual = uut.fibonacci(inputValue);
        // Assert
        assertEquals(expected, actual);
    }
}