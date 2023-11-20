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
                case 0:
                    swap(arr, mid, low);
                    // increment low as we have set zero correctly and all elements before low are zeros
                    low++;
                    // increment mid as we are sure that low was at one, just after all the zeros
                    // incrementing mid will move mid to next element of 1 so all elements on left are sorted correctly
                    mid++;
                case 1:
                    mid++;
                    break;
                case 2:
                    // Swap mid and high
                    swap(arr, mid, high);
                    // Since we have moved two to high lets decrement high to the next candidate for swap
                    high--;
                    // because we are not sure what will be the value at the right, we do not increment mid
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
