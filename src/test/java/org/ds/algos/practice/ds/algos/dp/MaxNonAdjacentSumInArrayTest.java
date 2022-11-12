package org.ds.algos.practice.ds.algos.dp;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

class MaxNonAdjacentSumInArrayTest {

    @Test
    void shouldReturnMaxSumForAnArray() {
        int[] arr = {75, 105, 120, 75, 90, 135};
        int result = MaxNonAdjacentSumInArray.maxSubsetSumNoAdjacent(arr);
        MatcherAssert.assertThat(result, Is.is(330));
    }

    @Test
    void shouldReturnZeroIfInputArrayIsEmpty() {
        int[] arr = {};
        int result = MaxNonAdjacentSumInArray.maxSubsetSumNoAdjacent(arr);
        MatcherAssert.assertThat(result, Is.is(0));
    }

}