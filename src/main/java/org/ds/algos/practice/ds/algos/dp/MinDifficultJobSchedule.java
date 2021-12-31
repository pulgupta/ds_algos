package org.ds.algos.practice.ds.algos.dp;

/**
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e. To work on the ith job, you have to finish
 * all the jobs j where 0 <= j < i). You have to finish at least one task every day. The difficulty of a job schedule
 * is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job
 * done on that day. You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is
 * jobDifficulty[i].
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 */
public class MinDifficultJobSchedule {
    /* It is always better to take Integer array as else we can have issues if the dp value is zero.
    In such cases, we can't say that if dp[][] is not zero use the pre-calculated value as calculated
    value can itself be zero */
    Integer[][] dp;
    int[] maxAfter;
    int[] jobDifficulty;
    int d, n;

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        dp = new Integer[n][d+1];
        maxAfter = new int[n];
        this.jobDifficulty = jobDifficulty;
        this.d = d;
        this.n = n;
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, jobDifficulty[i]);
            maxAfter[i] = max;
        }
        return dpFunc(0, 1);
    }

    /*
    State variables:
        i   : state variables are the index to start the work from
        k : the current day
    dp function: dp(i, day): dp(0,1) will give us our result
    recurrence relation:
        We can do tasks from i to n - (d-k) index on any kth day
        For each day we should try to minimise the hardness so our dp looks like
        dp(i, k) = min(hardness, dp(j+1, d+1)) for all i<=j < n-(d-k)
        where hardness = min(jobDifficulty[k]) for all i <= k <= j
    base case:
        when k == d we can just return the max value in the array starting at index i
    */
    private int dpFunc(int i, int k) {
        if (k == d) return maxAfter[i];
        if (dp[i][k] != null) return dp[i][k];
        int hardness = jobDifficulty[i];
        int optimum = Integer.MAX_VALUE;
        for (int j = i; j < n - (d - k); j++) {
            hardness = Math.max(hardness, jobDifficulty[j]);
            optimum = Math.min(optimum, hardness + dpFunc(j+1, k+1));
        }
        dp[i][k] = optimum;
        return dp[i][k];
    }
}
