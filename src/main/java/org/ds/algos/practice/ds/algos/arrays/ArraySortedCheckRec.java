package org.ds.algos.practice.ds.algos.arrays;

/**
 * This class checks if the array is sorted or not using recursion
 *
 * @author pulgupta
 */
public class ArraySortedCheckRec {

    public static boolean isSorted(int[] arr, int index) {
        if (arr == null || arr.length == 0) {
            return true;
        }
        if (index == arr.length - 1) {
            return true;
        }
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        return isSorted(arr, index + 1);
    }
}

