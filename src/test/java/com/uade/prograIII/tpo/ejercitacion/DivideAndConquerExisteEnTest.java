package com.uade.prograIII.tpo.ejercitacion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DivideAndConquerExisteEnTest {

    private DivideAndConquer uut;

    @BeforeEach
    void setUp() {
        uut = new DivideAndConquer();
    }

    @Test
    void existeEn_ShouldThrowIllegalArgumentException_WhenOrigenisNegative() {
        // Arrange
        List<Character> arr = new ArrayList<>();
        int negativeValue = -1;
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> uut.esOrdenadoAlfabeticamente(arr, negativeValue, 1));
    }

    @Test
    void existeEn_ShouldThrowIllegalArgumentException_WhenDestinoisNegative() {
        // Arrange
        List<Character> arr = new ArrayList<>();
        int negativeValue = -1;
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> uut.esOrdenadoAlfabeticamente(arr, 1, negativeValue));
    }

    @Test
    void existeEn_ShouldReturnFalse_WhenXisNotInArr() {
        // Arrange
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        boolean expected = false;
        Integer x = 5;
        // Act
        boolean actual = uut.existeEn(arr, 0, arr.size()-1, x);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void existeEn_ShouldReturnTrue_WhenXisInArr() {
        // Arrange
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        boolean expected = true;
        Integer x = 2;
        // Act
        boolean actual = uut.existeEn(arr, 0, arr.size()-1, x);
        // Assert
        assertEquals(expected, actual);
    }
}