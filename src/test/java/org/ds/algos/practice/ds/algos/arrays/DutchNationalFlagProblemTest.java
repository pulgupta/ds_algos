package org.ds.algos.practice.ds.algos.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

class DutchNationalFlagProblemTest {

    @Test
    void shouldSortTheArrayCorrectly() {
        int[] arr = {2, 1, 2, 0, 1, 1, 0, 2, 2, 1, 0};
        DutchNationalFlagProblem obj = new DutchNationalFlagProblem();
        int[] ints = obj.sortArray(arr);
        MatcherAssert.assertThat(ints, Is.is(new int[]{0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}));
    }
}