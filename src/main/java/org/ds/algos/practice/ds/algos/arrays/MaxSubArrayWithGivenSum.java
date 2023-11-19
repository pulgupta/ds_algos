package org.ds.algos.practice.ds.algos.arrays;

/**
 * Find the continuous sub array in an array with the sum equal to X
 * The trick here is to move the left and right pointer in a single iteration
 *
 * @author pulgupta
 */
public class MaxSubArrayWithGivenSum {

    public int[] getSubArrayDetails(int[] arr, int sum) {
        int[] result = new int[2];
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int windowSum = 0;
        while (j >= i && j < arr.length) {
            windowSum += arr[j];
            if (windowSum < sum) {
                j++;
            }
            if (windowSum == sum) {
                if (j - i + 1 > max) {
                    result[0] = i;
                    result[1] = j;
                    max = j - i + 1;
                }
                j++;
            }

            if (windowSum > sum) {
                while (windowSum > sum && i <= j) {
                    windowSum -= arr[i++];
                }
                if (windowSum == sum) {
                    if (j - i + 1 > max) {
                        result[0] = i;
                        result[1] = j;
                        max = j - i + 1;
                    }
                }
                j++;
            }
        }
        return result;
    }
}
