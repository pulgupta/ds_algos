package org.ds.algos.practice.ds_algos.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Print a long integer denoting the number of ways we can get a sum of N from the given infinite supply of M types of coins.
 * coins = {1, 2, 3}
 * Amount = 4
 * Answer = 4
 * Reason: {1,1,1,1} {1,1,2} {2,2} {1,3}
 */

/**
 * Approach :
 * If we do not include coin[i] then we move 1 row above and if we include the coin[i]
 * then we nove to dp[i][j- coin[i]] as we have found one more way to make up the amount
 * coin / Amt->|  0  |  1  |  2  |  3  |  4  |
 * -------------------------------------------
 *  []         |  1  |  0  |  0  |  0  |  0  |
 * -------------------------------------------
 *  [1]        |  1  |  1  |  1  |  1  |  1  |
 * -------------------------------------------
 *  [1,2]      |  1  |  1  |  2  |  2  |  3  |
 * -------------------------------------------
 *  [1,2,3]    |  1  |  1  |  2  |  3  |  4  |
 */
public class CoinChange2 {
    public static long getWays(int n, List<Integer> c) {
        c.sort(Integer::compareTo);
        // Write your code here
        int[][] dp = new int[c.size()+1][n+1];
        // Filling up the first column and first row
        for(int i=0;i<=n;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<=c.size();i++) {
            dp[i][0] = 1;
        }

        // Iterate considering one coin at a time
        for(int i=1;i<=c.size();i++) {
            // Iterate to find answer for each amount from 0...to n
            int coinAtHand = c.get(i-1);
            for(int j=1;j<=n;j++){
                if(coinAtHand<=j) {
                    // if we not choose the coin + if we choose the coin
                    dp[i][j] = dp[i-1][j] + dp[i][j-coinAtHand];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[c.size()][n];
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);list.add(5);list.add(3);list.add(6);
        System.out.print(getWays(10, list));
    }

}
