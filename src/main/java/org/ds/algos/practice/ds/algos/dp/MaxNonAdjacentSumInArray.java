package org.ds.algos.practice.ds.algos.dp;

/**
 * Returns maximum sum af non-adjacent sum in an array
 */
public class MaxNonAdjacentSumInArray {
    //Bottom up approach
    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Edge cases
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int[] dp = new int[array.length];
        // Base conditions
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            // Recurrence relation
            dp[i] = Math.max(dp[i - 2] + array[i], dp[i - 1]);
        }
        return dp[array.length - 1];
    }


    // Top down approach
    public static int maxSubsetSumNoAdjacentTopDown(int[] array) {
        // Write your code here
        if (array.length == 0) return 0;
        return dp(array, array.length - 1);
    }

    static int dp(int[] array, int i) {
        if (i <= 0) return array[0];
        if (i == 1) return Math.max(array[0], array[1]);
        return Math.max(dp(array, i - 1), dp(array, i - 2) + array[i]);
    }

}
