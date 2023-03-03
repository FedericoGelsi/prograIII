package com.uade.prograIII.tpo.impl;

import com.uade.prograIII.tpo.api.GrafoTDA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrafoMATest {

    private GrafoTDA uut;
    @BeforeEach
    void setUp() {
        uut = new GrafoMA(6);
    }

    @Test
    void grafoMA_ShouldBeCreatedSuccessfully() {
        // Arrange
        uut.agregarArista(0,5,5);
        uut.agregarArista(0,4,10);
        uut.agregarArista(0,2,40);
        uut.agregarArista(5,4,10);
        uut.agregarArista(5,1,20);
        uut.agregarArista(4,3,20);
        uut.agregarArista(3,2,5);
        uut.agregarArista(2,4,5);
        uut.agregarArista(2,1,10);
        uut.agregarArista(1,3,5);
        List<Integer> expected = Arrays.asList(0,1,2,3,4,5);
        // Act
        List<Integer> actual = uut.vertices();

        // Assert
        assertNotNull(uut);
        assertEquals(expected,actual);
    }
}