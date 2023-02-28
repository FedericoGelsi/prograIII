package com.uade.prograIII.tpo.ejercitacion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DivideAndConquerEsOrdenadoAlfabeticamenteTest {

    private DivideAndConquer uut;

    @BeforeEach
    void setUp() {
        uut = new DivideAndConquer();
    }

    @Test
    void esOrdenadoAlfabeticamente_ShouldThrowIllegalArgumentException_WhenOrigenisNegative() {
        // Arrange
        List<Character> arr = new ArrayList<>();
        int negativeValue = -1;
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> uut.esOrdenadoAlfabeticamente(arr, negativeValue, 1));
    }

    @Test
    void esOrdenadoAlfabeticamente_ShouldThrowIllegalArgumentException_WhenDestinoisNegative() {
        // Arrange
        List<Character> arr = new ArrayList<>();
        int negativeValue = -1;
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> uut.esOrdenadoAlfabeticamente(arr, 1, negativeValue));
    }

    @Test
    void esOrdenadoAlfabeticamente_ShouldFail_WhenArrIsNotOrdered() {
        // Arrange
        List<Character> arr = new ArrayList<>();
        arr.add('A');
        arr.add('B');
        arr.add('D');
        arr.add('C');
        boolean expected = false;
        // Act
        boolean actual = uut.esOrdenadoAlfabeticamente(arr, 0, arr.size()-1);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void esOrdenadoAlfabeticamente_ShouldSucceed_WhenArrIsOrdered() {
        // Arrange
        List<Character> arr = new ArrayList<>();
        arr.add('A');
        arr.add('B');
        arr.add('C');
        arr.add('D');
        boolean expected = true;
        // Act
        boolean actual = uut.esOrdenadoAlfabeticamente(arr, 0, arr.size()-1);
        // Assert
        assertEquals(expected, actual);
    }
}