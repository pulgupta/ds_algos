package org.ds.algos.practice.ds.algos.recursion;

/**
 * The idea is to check what is the maximum value we can achieve in the knapsack
 * There can be three major cases
 * 1) We cannot add an item as its weight is more
 * 2) We can add so we will increase the total value
 * 3) We can add but we will not as that is not a optimal solution
 */
public class KnapsackProblem {

    public static int knapsack(int capacity, int n, int[] weights, int[] values) {
        if(capacity <= 0 || n ==0)
            return 0;
        // Weight of the next item is more than the capacity
        // So we can't add it to the knapsack
        else if(capacity - weights[n] < 0)
            return knapsack(capacity, n-1, weights, values);
        else
            // We can add the item into the knapsack, however we have to check what is the maximum weight
            // we can achieve. 1) By adding the item, 2) By not adding this item
            return Math.max( values[n] + knapsack(capacity-weights[n], n-1, weights, values),
                    knapsack(capacity, n-1, weights, values));
    }

    public static void main(String[] args) {
        // Sorted in terms of weight. So the first element will have more value then the next
        // We have two items with same weight but we can see that their values are different
        int[] weights = {11, 8, 7, 6, 5, 5};
        int[] values = {10, 8, 4, 3, 4, 2};
        System.out.println(knapsack(20, 5, weights, values));
    }
}
