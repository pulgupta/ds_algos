package org.ds.algos.practice.ds.algos.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

class SpiralPrint2dMatrixTest {

    @Test
    void shouldPrintTheCorrectOrderForEmptyMatrix() {
        SpiralPrint2dMatrix spiralPrint2dMatrix = new SpiralPrint2dMatrix();
        int[][] arr = {};
        int[] result = {};
        MatcherAssert.assertThat(spiralPrint2dMatrix.findDiagonalOrder(arr), Is.is(result));
    }

    @Test
    void shouldPrintTheCorrectOrderFor_2X2_Matrix() {
        SpiralPrint2dMatrix spiralPrint2dMatrix = new SpiralPrint2dMatrix();
        int[][] arr = {{1, 2}, {3, 4}};
        int[] result = {1,2,3,4};
        MatcherAssert.assertThat(spiralPrint2dMatrix.findDiagonalOrder(arr), Is.is(result));
    }

    @Test
    void shouldPrintTheCorrectOrderFor_3X3_Matrix() {
        SpiralPrint2dMatrix spiralPrint2dMatrix = new SpiralPrint2dMatrix();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = {1,2,4,7,5,3,6,8,9};
        MatcherAssert.assertThat(spiralPrint2dMatrix.findDiagonalOrder(arr), Is.is(result));
    }

    @Test
    void shouldPrintTheCorrectOrderFor_4X3_Matrix() {
        SpiralPrint2dMatrix spiralPrint2dMatrix = new SpiralPrint2dMatrix();
        int[][] arr = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {7, 10, 11, 12}};
        int[] result = {1,2,5,7,6,3,4,7,10,11,8,12};
        MatcherAssert.assertThat(spiralPrint2dMatrix.findDiagonalOrder(arr), Is.is(result));
    }

    @Test
    void shouldPrintTheCorrectOrderFor_3X4_Matrix() {
        SpiralPrint2dMatrix spiralPrint2dMatrix = new SpiralPrint2dMatrix();
        int[][] arr = {{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9},
                       {10,11,12}};
        int[] result = {1,2,4,7,5,3,6,8,10,11,9,12};
        MatcherAssert.assertThat(spiralPrint2dMatrix.findDiagonalOrder(arr), Is.is(result));
    }

}