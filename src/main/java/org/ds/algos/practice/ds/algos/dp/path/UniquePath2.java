package org.ds.algos.practice.ds.algos.dp.path;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 */
public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1? 0: 1;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(obstacleGrid[i][j] == 1) {
                    // dp[i][j] will remain 0 and so we can say we can never reach this place
                    continue;
                }
                if(i>0) {
                    dp[i][j] += dp[i-1][j]; // we can either come from top
                }
                if(j>0) {
                    dp[i][j] += dp[i][j-1]; // and we can also come from left
                }
            }
        }
        return dp[m-1][n-1];
    }
}
