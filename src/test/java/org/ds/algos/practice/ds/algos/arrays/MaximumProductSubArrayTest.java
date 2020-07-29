package org.ds.algos.practice.ds.algos.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MaximumProductSubArrayTest {

    @Test
    void shouldReturnMaximumForBreakingArray() {
        int[] arr = {2,3,-2,4,8};
        assertThat(new MaximumProductSubArray().maxProduct(arr), is(32));
    }

    @Test
    void shouldReturnMaximumForArrayWithZeroAsMinimum() {
        int[] arr = {-2,0,-9};
        assertThat(new MaximumProductSubArray().maxProduct(arr), is(0));
    }

    @Test
    void shouldReturnMaximumForAllNegativeArrayWithOddElements() {
        int[] arr = {-2,-3,-2,-4,-8};
        assertThat(new MaximumProductSubArray().maxProduct(arr), is(192));
    }

    @Test
    void shouldReturnMaximumForAllNegativeArrayWithEvenElements() {
        int[] arr = {-2,-3,-2,-4};
        assertThat(new MaximumProductSubArray().maxProduct(arr), is(48));
    }

    @Test
    void shouldReturnMaximumForSingleElementArray() {
        int[] arr = {-1};
        assertThat(new MaximumProductSubArray().maxProduct(arr), is(-1));
    }

}