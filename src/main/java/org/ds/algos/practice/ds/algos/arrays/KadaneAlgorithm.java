package org.ds.algos.practice.ds.algos.arrays;

/**
 * Kadane's Algorithm is used for finding the largest sum of a continuous sub array in an array.
 * The idea is simple, Start from zero and keep adding more elements to it. If the sum reaches zero then
 * start a fresh from that point. In the process keep track of the largest sum we have encountered till
 * this point.
 *
 * @author: pulgupta
 */
public class KadaneAlgorithm {

    public static int algorithm(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int sum = 0;
        for (int j : arr) {
            sum = sum + j;
            if (sum > maxSoFar)
                maxSoFar = sum;
            if (sum < 0)
                sum = 0;
        }
        return maxSoFar;
    }
}
