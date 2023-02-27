package com.uade.prograIII.tpo.ejecucion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    private Factorial uut;

    @BeforeEach
    void setUp() {
        uut = new Factorial();
    }

    @Test
    void factorial_ShouldThrowIllegalArgumentException_WhenNisNegative() {
        // Arrange
        int negativeValue = -1;
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> uut.factorial(negativeValue));
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,6", "4,24", "5,120", "10,3628800"})
    public void factorial_shouldReturnExpectedValues(int inputValue, int expected){
        // Act
        int actual = uut.factorial(inputValue);
        // Assert
        assertEquals(expected, actual);
    }
}