package org.ds.algos.practice.ds.algos.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

class ReplaceZeroForMaxSubArrayTest {

    @Test
    void shouldReturnCurrentLength() {
        int[] array = new int[]{0, 1, 0, 1, 1, 1, 0, 1, 1};
        ReplaceZeroForMaxSubArray object = new ReplaceZeroForMaxSubArray();
        MatcherAssert.assertThat(object.findMaxSubArrayLength(array), Is.is(6));
    }

}