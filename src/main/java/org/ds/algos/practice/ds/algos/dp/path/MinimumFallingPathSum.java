package org.ds.algos.practice.ds.algos.dp.path;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * <p>
 * A falling path starts at any element in the first row and chooses the element in the next row that is either
 * directly below or diagonally left/right. Specifically, the next element from position (row, col) will be
 * (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        // For the first row the min sum is equal to the actual value
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        /*
         * Direction of movement if like below, so we have three min condition to cover all paths
         *         []
         *      /  |  \
         *    []  []  []
         */
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int result = Integer.MAX_VALUE;
                if (j > 0) {
                    result = Math.min(result, dp[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    result = Math.min(result, dp[i - 1][j + 1]);
                }
                result = Math.min(result, dp[i - 1][j]);
                dp[i][j] = result + matrix[i][j];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int el : dp[m - 1]) {
            result = Math.min(result, el);
        }
        return result;
    }
}
