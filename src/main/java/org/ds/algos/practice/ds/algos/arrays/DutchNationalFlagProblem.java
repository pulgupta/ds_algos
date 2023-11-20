package org.ds.algos.practice.ds.algos.arrays;

/**
 * Sort an array containing red, white, blue color balls
 *
 * @author pulgupta
 */
public class DutchNationalFlagProblem {

    public int[] sortArray(int[] arr) {
        int low = 0, mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            // Start with the middle element
            switch (arr[mid]) {
                // If mid is zero we need to swap it to the left
                case 0:
                    // Swap low and mid
                    swap(arr, mid, low);
                    low++;
                    mid++;
                    break;
                // If mid is 1 this means it is in the right place, lets analyse the next element
                case 1:
                    mid++;
                    break;
                // If mid == 2 we will have to swap it to the right and
                // because we are not sure what will be the value at the right, we do not increment mid
                case 2:
                    // Swap mid and high
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int a, int b) {
        int temp1 = arr[a];
        arr[a] = arr[b];
        arr[b] = temp1;
    }
}
