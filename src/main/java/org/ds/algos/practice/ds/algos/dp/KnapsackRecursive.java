package org.ds.algos.practice.ds.algos.dp;

/**
 * The idea is to check what is the maximum value we can achieve in the knapsack
 * There can be three major cases
 * 1) We cannot add an item as its weight is more
 * 2) We can add so we will increase the total value
 * 3) We can add but we will not as that is not a optimal solution
 */
public class KnapsackRecursive {

    public static int knapsack(int capacity, int n, int[] weights, int[] values) {
        if (capacity <= 0 || n == 0)
            return 0;
            // Weight of the next item is more than the capacity
            // So we can't add it to the knapsack
        else if (capacity - weights[n] < 0)
            return knapsack(capacity, n - 1, weights, values);
        else
            // We can add the item into the knapsack, however we have to check what is the maximum weight
            // we can achieve. 1) By adding the item, 2) By not adding this item
            return Math.max(values[n] + knapsack(capacity - weights[n], n - 1, weights, values),
                    knapsack(capacity, n - 1, weights, values));
    }
}
