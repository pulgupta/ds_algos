package org.ds.algos.practice.ds.algos.dp;

/**
 * https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
 * You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
 * Choose one integer x from either the start or the end of the array nums.
 * Add multipliers[i] * x to your score.
 * Remove x from the array nums.
 * Return the maximum score after performing m operations.
 */
public class MaxMultiplicationSum {
    int[] n;
    int[] m;
    int dp[][];

    public int maximumScore(int[] nums, int[] multipliers) {
        this.n = nums;
        this.m = multipliers;
        dp = new int[m.length][m.length];
        /*
        Since we do not know what will be the value of left once we reach i=m, we will start
        from the initial state and will recurse to find all the subsequent states. Finally,
        the complete recursion will give us the value as our answer.
         */
        return dpFun(0, 0);
    }

    int dpFun(int i, int left) {
        if (i == m.length) return 0;
        /*
        Since if we have done n operation out of which left is x we can easily calculate right operations
        In a naive approach, we could have taken three state variables
        right, left and the index but by deriving right from other state variable we have greatly reduced the number
        of possible states and thus both the time and state complexity as both are directly proportional to the number
        of states in a DP.
         */
        int right = n.length - 1 - (i - left);
        if (dp[i][left] != 0) {
            return dp[i][left];
        }
        /*
        we can move forward by either removing left or by removing right, and so we will
        try both the cases and will choose the optimum solution out of the two
         */
        dp[i][left] = Math.max(m[i] * n[left] + dpFun(i + 1, left + 1), m[i] * n[right] + dpFun(i + 1, left));
        return dp[i][left];
    }
}
