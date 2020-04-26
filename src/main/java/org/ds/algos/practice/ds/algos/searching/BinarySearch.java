package org.ds.algos.practice.ds.algos.searching;

public class BinarySearch {
    private static boolean found;

    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int element = 89;
        binarySearch(arr, element, 0, arr.length - 1);
        System.out.println(found);
    }

    /**
     * Recursive approach to binary search. This is good.
     *
     * @param arr  : Array to be searched
     * @param e    : Element to be searched
     * @param low  : lower bound of the sub array
     * @param high : Higher bound of the sub array
     * @author pulgupta
     * @description : this is being implemented using recursion in case we can
     * also achieve the same thing using while loop
     * Also one or two things which I have realized using recursion that
     * we should avoid using return as this will just be the return of one of the many recursive call
     * and thus we will not achieve the desired result which we are trying to achieve
     */
    public static void binarySearch(int[] arr, int e, int low, int high) {
        int middle = (low + high) / 2;
        if (e == arr[middle]) {
            found = true;
        }
        if (low < high) {
            if (e > arr[middle])
                binarySearch(arr, e, middle + 1, high);
            else
                binarySearch(arr, e, low, middle - 1);
        }
    }
}
