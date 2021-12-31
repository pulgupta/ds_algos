package org.ds.algos.practice.ds.algos.dp;

/**
 * https://leetcode.com/problems/house-robber/
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    Integer[] dp;

    public int rob(int[] values) {
        dp = new Integer[values.length + 2];
        return rob(values.length - 1, values);
    }

    public int rob(int i, int[] values) {
        if (i < 0) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        /* Either we can skip the current house, in which case the value will be same as the previous house dp[i-1]
         * or we can rob this house in which case the value will be sum of current value and the value from the i-2 house
         * Since we have to optimise it, we will take a max of both the possibilities
         */
        dp[i] = Math.max(rob(i - 1, values), rob(i - 2, values) + values[i]);
        return dp[i];
    }
}
