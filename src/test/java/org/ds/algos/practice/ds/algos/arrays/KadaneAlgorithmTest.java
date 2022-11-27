package org.ds.algos.practice.ds.algos.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

class KadaneAlgorithmTest {
    @Test
    void shouldReturnMinNumberInAllNegativeArray() {
        int result = KadaneAlgorithm.algorithm(new int[]{-10, -4, -9, -2, -5});
        MatcherAssert.assertThat(result, Is.is(-2));
    }

    @Test
    void shouldReturnCorrectResultInMixedArray() {
        int result = KadaneAlgorithm.algorithm(new int[]{-13, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4});
        MatcherAssert.assertThat(result, Is.is(19));
    }
}