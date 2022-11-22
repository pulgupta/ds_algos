package org.ds.algos.practice.ds.algos.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Knapsack {

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] memo = new int[items.length + 1][capacity + 1];
        dp(memo, items, capacity);
        List<Integer> totalValue = List.of(memo[items.length][capacity]);
        List<Integer> finalItems = findIncludedElements(memo, capacity, items);
        var result = new ArrayList<List<Integer>>();
        result.add(totalValue);
        result.add(finalItems);
        return result;
    }

    static void dp(int[][] memo, int[][] items, int capacity) {
        for (int i = 1; i < items.length + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                int value = items[i - 1][0];
                int weight = items[i - 1][1];
                if (weight <= capacity && j - weight >= 0) {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][j - weight] + value);
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
    }

    static List<Integer> findIncludedElements(int[][] memo, int capacity, int[][] items) {
        Stack<Integer> result = new Stack<>();
        int row = items.length;
        int col = capacity;
        while (row > 0 && col > 0) {
            if (memo[row][col] != memo[row - 1][col]) {
                result.push(row - 1);
                col = col - items[row - 1][1];
            }
            row--;
        }
        List<Integer> r = new ArrayList<>();
        while (!result.isEmpty()) r.add(result.pop());
        return r;
    }

}
