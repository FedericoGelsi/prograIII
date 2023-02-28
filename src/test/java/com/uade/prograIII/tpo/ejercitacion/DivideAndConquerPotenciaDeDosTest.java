package com.uade.prograIII.tpo.ejercitacion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DivideAndConquerPotenciaDeDosTest {

    private DivideAndConquer uut;

    @BeforeEach
    void setUp() {
        uut = new DivideAndConquer();
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "5,16,152587890625",
                    "2,8,256",
                    "2,32,4294967296"
            }
    )
    void potenciaDeDos_ShouldWorkAsExpected(long a, long n, long expected) {
        // Arrange

        // Act
        long actual = uut.potenciaDeDos(a, n);

        // Assert
        assertEquals(expected, actual);
    }
}