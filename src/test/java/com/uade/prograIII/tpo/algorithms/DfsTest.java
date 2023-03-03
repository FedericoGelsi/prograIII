package com.uade.prograIII.tpo.algorithms;

import com.uade.prograIII.tpo.TestUtils;
import com.uade.prograIII.tpo.api.GrafoTDA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DfsTest {

    private Dfs uut;

    private GrafoTDA grafo;

    @BeforeEach
    void setUp() {
        uut = new Dfs();
        grafo = new TestUtils().setupGrafo();
    }

    @Test
    void search_ShouldWorkAsExpected() {
        // Arrange
        int[] expected = {0, 2, 0, 1, 2, 0};
        // Act
        int[] actual = uut.search(grafo, 0);
        // Assert
        assertArrayEquals(expected,actual);
    }
}