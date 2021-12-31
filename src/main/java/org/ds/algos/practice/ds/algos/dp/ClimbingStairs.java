package org.ds.algos.practice.ds.algos.dp;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    /**
     * dp[1] = 1
     * dp[2] = 2 (direct to 2 or one-one step to 2)
     * dp[3] = dp[1] + dp[2] as we can only reach three from 1st or 2nd stair, so
     * the number of ways to reach 3 is nothing but number of ways to reach 1 plus the number of ways to reach 2
     * General Equation: dp[i] = dp[i-1] + dp[i-2]
     **/
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}