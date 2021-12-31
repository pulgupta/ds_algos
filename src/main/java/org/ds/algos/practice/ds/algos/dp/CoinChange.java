package org.ds.algos.practice.ds.algos.dp;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */

import java.util.Arrays;

/**
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        /**
         * The idea here is to break the problem into sub problems
         * So we have to find the optimal solution for amount which can be broken into sub-problems
         * Which means if we can find optimal solution for 0..1..2...... we can eventually find the optimal
         * Solution for N
         */
        // Create a memo to avoid recomputations
        int[] dp = new int[amount + 1];
        // We do not know if it is even possible to added MAX into each place
        Arrays.fill(dp, amount + 1);
        // Sorted the array to make checking efficient
        Arrays.sort(coins);
        dp[0] = 0;
        // Compute optimal solution for each coin
        for (int i = 0; i <= amount; i++) {
            // check each coin for finding the optimal solution
            for (int j = 0; j < coins.length; j++) {
                // Only if the current coin is less than the amount we are checking then we can try putting it in
                if (coins[j] <= i) {
                    // This basically means that try to find the minimum for amount - coin at hand and if that is
                    // minimum than the current, we have a new optimal solution.
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                    /**
                     * consider this say in current iteration iAmount is being calculated
                     * the coin at hand is X
                     * so if I want to find the optimal solution of this setup
                     * I can find the best solution to iAmount-X and then take X coin as well
                     * To get the best solution to iAmount-X I have my memo. Now as I am adding one coin
                     * of X to the mix I have 1+dp[iAmount-X] as the best solution for iAmount.
                     * This is what we have done above.
                     */
                }
            }
        }

        return dp[amount] < amount + 1 ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }
}
