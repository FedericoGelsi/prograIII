package com.uade.prograIII.tpo.impl;

import com.uade.prograIII.tpo.api.GrafoTDA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrafoMATest {

    private GrafoTDA uut;
    @BeforeEach
    void setUp() {
        uut = new GrafoMA(7);
    }

    @Test
    void imprimirMatriz() {
        // Arrange
        uut.agregarArista(1,6,5);
        uut.agregarArista(1,5,10);
        uut.agregarArista(1,3,40);
        uut.agregarArista(6,5,10);
        uut.agregarArista(6,2,20);
        uut.agregarArista(5,4,20);
        uut.agregarArista(4,3,5);
        uut.agregarArista(3,5,5);
        uut.agregarArista(3,2,10);
        uut.agregarArista(2,4,5);

        // Act
        System.out.println(uut.pesoArista(2,4));
    }
}