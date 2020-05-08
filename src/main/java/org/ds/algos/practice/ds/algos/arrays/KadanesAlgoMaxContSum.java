package org.ds.algos.practice.ds.algos.arrays;

/**
 * Kadane's Algorithm is used for finding the largest sum of a continuous sub array in an array.
 * The idea is simple, Start from zero and keep adding more elements to it. If the sum reaches zero then
 * start a fresh from that point. In the process keep track of the largest sum we have encountered till
 * this point.
 *
 * @author: pulgupta
 */
public class KadanesAlgoMaxContSum {

    private static int max_so_far = 0;
    private static int max_here = 0;

    public static int kadanesAlgorithm(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            max_here = max_here + arr[i]; // keep incrementing max_here to check for sum till now
            // If it is less than zero then we can neglect all the elements till now
            // and can start fresh. This is the point which helps us in moving the starting point of
            // our sub array forward
            if (max_here < 0)
                max_here = 0;
                // If we have reached a point where the sum is more than the sum encountered so far
            else if (max_here > max_so_far)
                max_so_far = max_here;
        }
        return max_so_far;
    }

    public static void main(String args[]) {
        int[] arr = {1, 5 - 8, -5, -3, 6, 1};
        System.out.println(KadanesAlgoMaxContSum.kadanesAlgorithm(arr));
    }
}
