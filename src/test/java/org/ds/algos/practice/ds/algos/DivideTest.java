package org.ds.algos.practice.ds.algos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {

    @Test
    void shouldReturnCorrectOutputForValidCase() {
        int divident = 100;
        int divisor = 5;
        assertEquals(20, Divide.divide(divident, divisor));
    }

    @Test
    void shouldHandleInvalidValueForDivisor() {
        int divident = 100;
        int divisor = 0;
        assertThrows(IllegalArgumentException.class, () -> Divide.divide(divident, divisor));
    }
}