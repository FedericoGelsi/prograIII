package com.uade.prograIII.tpo.algorithms;

import com.uade.prograIII.tpo.TestUtils;
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
        grafo = new TestUtils().setupGrafo();
    }

    @Test
    void search_ShouldWorkAsExpected() {
        // Arrange
        int[] expected = {0, 25, 35, 30, 10, 5};
        // Act
        int[] actual = uut.search(grafo, 0);
        // Assert
        assertArrayEquals(expected,actual);
    }
}