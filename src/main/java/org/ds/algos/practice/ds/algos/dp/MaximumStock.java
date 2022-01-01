package org.ds.algos.practice.ds.algos.dp;
/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
import java.util.HashMap;
import java.util.Map;

/***********SOLVED DUDE ************/

public class MaximumStock {
    Map<String, Integer> dp;
    int k;
    int[] prices;
    public int maxProfit(int k, int[] prices) {
        this.k = k;
        this.prices = prices;
        dp = new HashMap<>();
        return dpFunc(0, k, false);
    }

    private int dpFunc(int i, int t, boolean h) {
        if(i>=prices.length || t <= 0) return 0;

        String key = i + "-" + t + " " + h; // used for memoization
        if(dp.get(key) != null) return dp.get(key);

        if(h) {
            // If we are holding the stock then we can do two things and consider the max one
            // 1. Sell the stock
            // 2. Do nothing
            dp.put(key, Math.max(prices[i] + dpFunc(i+1, t-1, false), dpFunc(i+1, t, h)));
        } else {
            // If we are not holding the stock then we can do two things and consider the max one
            // 1. buy the stock
            // 2. Do nothing
            dp.put(key, Math.max(-prices[i] + dpFunc(i+1, t, true), dpFunc(i+1, t, h)));
        }
        return dp.get(key);
    }
}
