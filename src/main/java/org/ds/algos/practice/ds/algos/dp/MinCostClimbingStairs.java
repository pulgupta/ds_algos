package org.ds.algos.practice.ds.algos.dp;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 */
public class MinCostClimbingStairs {
    Integer[] dp;

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        dp = new Integer[len];
        calc(len - 1, cost);
        return (Math.min(dp[len - 1], dp[len - 2]));
    }

    private int calc(int i, int[] cost) {
        if (i < 0) return 0;
        if (dp[i] != null) {
            return dp[i];
        }
        /*
         * You can reach i from either i-1 or i-2
         * Since we have to consider the minimum cost we will consider the
         * min value to reach i and then add the cost of i
         */
        dp[i] = Math.min(calc(i - 1, cost), calc(i - 2, cost)) + cost[i];
        return dp[i];
    }
}