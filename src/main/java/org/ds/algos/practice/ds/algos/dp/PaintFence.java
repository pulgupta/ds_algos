package org.ds.algos.practice.ds.algos.dp;

/**
 * https://leetcode.com/problems/paint-fence
 * You are painting a fence of n posts with k different colors. You must paint the posts following these rules:
 * Every post must be painted exactly one color.
 * There cannot be three or more consecutive posts with the same color.
 * Given the two integers n and k, return the number of ways you can paint the fence.
 */
public class PaintFence {
    /*
    The complete explanation of the problem can be found in my dp good-nodes (check the notes outline)
     */
    public int numWays(int n, int k) {
        if(n==1) return k;
        int[] dp = new int[n+1];
        dp[1] = k;
        dp[2] = k*k;
        for(int i=3; i<=n; i++) {
            dp[i] = (k-1) * (dp[i-1] + dp[i-2]);
        }
        return dp[n];
    }
}
