package org.ds.algos.practice.ds_algos.arrays;

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
            // Start with the mid element
            switch (arr[mid]) {
                // If mid is zero we need to swap it to the left
                case 0:
                    // Swap low and mid
                    int temp = arr[mid];
                    arr[mid] = arr[low];
                    arr[low] = temp;
                    low++;
                    mid++;
                    break;
                // If mid is 1 this means it is in the right place
                // Lets analyse the next element
                case 1:
                    mid++;
                    break;
                // If mid == 2 we will have to swap it to the right and
                // because we are not sure what will be the value at the right
                // we do not increment mid
                case 2:
                    // Swap mid and high
                    int temp1 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp1;
                    high--;
                    break;
            }
        }
        return arr;
    }

    public static void main(String args[]) {
        int[] arr = {2, 1, 2, 0, 1, 1, 0, 2, 2, 1, 0};
        DutchNationalFlagProblem obj = new DutchNationalFlagProblem();
        obj.sortArray(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
