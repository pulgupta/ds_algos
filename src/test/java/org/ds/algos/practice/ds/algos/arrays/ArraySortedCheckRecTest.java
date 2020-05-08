package org.ds.algos.practice.ds.algos.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortedCheckRecTest {

    @Test
    void shouldReturnTrueForSortedArray() {
        int sortedArray[] = {3, 9, 45, 45, 88};
        assertTrue(ArraySortedCheckRec.isSorted(sortedArray, 0));
    }

    @Test
    void shouldReturnFalseForSortedArray() {
        int sortedArray[] = {3, 7, 45, 41, 88};
        assertFalse(ArraySortedCheckRec.isSorted(sortedArray, 0));
    }
}