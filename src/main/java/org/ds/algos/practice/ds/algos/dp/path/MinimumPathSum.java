package org.ds.algos.practice.ds.algos.dp.path;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes
 * the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i == 0) {
                    if(j > 0) dp[i][j] = dp[i][j-1] + grid[i][j]; // we can only come from left
                } else if(j == 0) {
                    if (i > 0) dp[i][j] = dp[i-1][j] + grid[i][j]; // we can only come from top
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j]; // if we can come from both then choose min
                }
            }
        }
        return dp[m-1][n-1];
    }
}
