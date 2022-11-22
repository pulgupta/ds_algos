package org.ds.algos.practice.ds.algos.dp;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

class KnapsackRecursiveTest {

    @Test
    void shouldReturnTheCorrectMaxValue() {
        int[] weights = {11, 8, 7, 6, 5, 5};
        int[] values = {10, 8, 4, 3, 4, 2};
        MatcherAssert.assertThat(KnapsackRecursive.knapsack(20, 5, weights, values), Is.is(16));
    }

}