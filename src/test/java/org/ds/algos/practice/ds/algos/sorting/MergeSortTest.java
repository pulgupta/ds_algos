package org.ds.algos.practice.ds.algos.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    MergeSort mergeSort;

    public MergeSortTest() {
        mergeSort = new MergeSort();
    }

    @Test
    void shouldSortAnUnsortedArray() {
        int[] arr = {1,5,8,1,9};
        int[] sortedArray = {1,1,5,8,9};
        assertArrayEquals(sortedArray, mergeSort.sort(arr));
    }

    @Test
    void shouldSortAnAlreadtSortedArray() {
        int[] sortedArray = {1,1,5,8,9};
        assertArrayEquals(sortedArray, mergeSort.sort(sortedArray));
    }

    @Test
    void shouldHandleEmptyArrayWithoutError() {
        int[] sortedArray = {};
        assertArrayEquals(sortedArray, mergeSort.sort(sortedArray));
    }

    @Test
    void shouldThrowExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class, () -> mergeSort.sort(null));
    }

}