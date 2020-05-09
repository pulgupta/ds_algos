package org.ds.algos.practice.ds.algos.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountArrayFrequenciesIn_OnTest {

    @Test
    void shouldCountArrayFrequenciesCorrectly() {
        int[] arr = {1,8,4,6,2,8,7,1};
        int[] result = {2,1,0,1,0,1,1,2};
        assertArrayEquals(result, CountArrayFrequenciesIn_On.calculateFrequencies(arr));
    }

}