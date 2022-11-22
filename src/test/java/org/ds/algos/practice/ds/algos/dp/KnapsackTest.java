package org.ds.algos.practice.ds.algos.dp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class KnapsackTest {

    @Test
    void findMaxValue() {
        int[][] arr = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        List<List<Integer>> lists = Knapsack.knapsackProblem(arr, 10);
        assertThat(lists.get(0).get(0), is(10));
        assertThat(lists.get(1).get(0), is(1));
        assertThat(lists.get(1).get(1), is(3));
    }

    @Test
    void findMaxValueForLargeDataSet() {
        int[][] arr = {
                {465, 100},
                {400, 85},
                {255, 55},
                {350, 45},
                {650, 130},
                {1000, 190},
                {455, 100},
                {100, 25},
                {1200, 190},
                {320, 65},
                {750, 100},
                {50, 45},
                {550, 65},
                {100, 50},
                {600, 70},
                {240, 40}};
        List<List<Integer>> lists = Knapsack.knapsackProblem(arr, 200);
        assertThat(lists.get(0).get(0), is(1500));
        assertThat(lists.get(1).get(0), is(3));
        assertThat(lists.get(1).get(1), is(12));
        assertThat(lists.get(1).get(2), is(14));
    }


}