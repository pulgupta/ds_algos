package org.ds.algos.practice.ds.algos.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ThreeNumberSumTest {

    @Test
    void shouldReturnCorrectTriplets() {
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        List<Integer[]> result = ThreeNumberSum.threeNumberSum(array, 0);
        assertThat(result.size(), is(3));
        int[] arr1 = {-8, 2, 6};
        assertThat(result.get(0), is(arr1));
    }


}