package org.ds.algos.practice.ds.algos.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MaxSubArrayWithGivenSumTest {

    @Test
    void shouldReturnMaxSubArray() {
        int[] arr = {2, 1, 7, 5, 3, 4};
        MaxSubArrayWithGivenSum obj = new MaxSubArrayWithGivenSum();
        int[] subArrayDetails = obj.getSubArrayDetails(arr, 12);
        assertThat(subArrayDetails, is(new int[]{3, 5}));
    }

}