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

    public static void main(String[] args) {

        int sortedArray[] = {3, 9, 45, 45, 88};
        int unsortedArray[] = {3, 9, 45, 1, 88};
        System.out.println(isSorted(sortedArray, 0));
        System.out.println(isSorted(unsortedArray, 0));

    }
}

