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
 * then we add 1 to coin[j- coin[i]] as we have found one more way to make up the amount
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
    public static long getWays(int n, List<Long> c) {
        // Write your code here


        return 0L;
    }

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(1L);list.add(2L);list.add(3L);
        System.out.print(getWays(4, list));
    }

}
