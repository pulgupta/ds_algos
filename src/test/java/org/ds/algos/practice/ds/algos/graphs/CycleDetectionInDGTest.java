package org.ds.algos.practice.ds.algos.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CycleDetectionInDGTest {

    @Test
    void shouldDetectCycleSuccessfully() {
        /*

         */
        int[][] edges = {
                {1, 3},
                {2, 3, 4},
                {0},
                {},
                {2, 5},
                {}
        };
        CycleDetectionInDG cycleDetectionInDG = new CycleDetectionInDG();
        boolean b = cycleDetectionInDG.cycleInGraph(edges);
        Assertions.assertTrue(b);
    }

    @Test
    void shouldNotDetectCycleSuccessfullyIfNotPresent() {
        /*

         */
        int[][] edges = {
                {1, 2},
        {2},
        {}
        };
        CycleDetectionInDG cycleDetectionInDG = new CycleDetectionInDG();
        boolean b = cycleDetectionInDG.cycleInGraph(edges);
        Assertions.assertFalse(b);
    }

    @Test
    void shouldDetectCycleSuccessfullyIfPresent() {
        /*

         */
        int[][] edges = {
                {1, 2},
                {2},
                {1}
        };
        CycleDetectionInDG cycleDetectionInDG = new CycleDetectionInDG();
        boolean b = cycleDetectionInDG.cycleInGraph(edges);
        Assertions.assertTrue(b);
    }
}