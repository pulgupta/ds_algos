package org.ds.algos.practice.ds.algos.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/diagonal-traverse/
 * https://assets.leetcode.com/uploads/2018/10/12/diagonal_traverse.png
 **/
public class SpiralPrint2dMatrix {
    public int[] findDiagonalOrder(int[][] matrix) {
        int[] result = matrix.length != 0 ? new int[matrix.length * matrix[0].length] : new int[0];
        if (matrix.length == 0) return result;
        int pointer = 0;
        boolean odd = true;
        for (int i = 0; i < matrix[0].length; i++) {
            int row = 0;
            int col = i;
            List<Integer> list = new ArrayList<>();
            while (row < matrix.length && col >= 0) {
                list.add(matrix[row++][col--]);
            }
            if (odd) Collections.reverse(list);
            odd = !odd;
            for (int el : list)
                result[pointer++] = el;
        }
        for (int i = 1; i < matrix.length; i++) {
            int row = i;
            int col = matrix[i].length - 1;
            List<Integer> list = new ArrayList<>();
            while (row < matrix.length && col >= 0) {
                list.add(matrix[row++][col--]);
            }
            if (odd) Collections.reverse(list);
            odd = !odd;
            for (int el : list)
                result[pointer++] = el;
        }
        return result;
    }
}
