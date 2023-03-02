package com.uade.prograIII.tpo.algorithms;

import com.uade.prograIII.tpo.api.GrafoTDA;
import com.uade.prograIII.tpo.impl.GrafoMA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    private Dijkstra uut;

    private GrafoTDA grafo;

    @BeforeEach
    void setUp() {
        uut = new Dijkstra();
        grafo = new GrafoMA(6);
        grafo.agregarArista(0,5,5);
        grafo.agregarArista(0,4,10);
        grafo.agregarArista(0,2,40);
        grafo.agregarArista(5,4,10);
        grafo.agregarArista(5,1,20);
        grafo.agregarArista(4,3,20);
        grafo.agregarArista(3,2,5);
        grafo.agregarArista(2,4,5);
        grafo.agregarArista(2,1,10);
        grafo.agregarArista(1,3,5);
    }

    @Test
    void search_ShouldWorkAsExpected() {
        // Arrange
        Integer[] expected = {0, 2, 0, 4, 0, 0};
        // Act
        Integer[] actual = uut.search(grafo, 0);
        // Assert
        assertArrayEquals(expected,actual);
    }
}