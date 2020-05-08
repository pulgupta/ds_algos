package org.ds.algos.practice.ds.algos.sorting;

/**
 * Merge sort works by dividing the arrays into smaller arrays and
 * once they are broken down to a single element level we will then merge them
 *
 * @author pulgupta
 */
public class MergeSort {

    // Merge sort will require a temp array in case of arrays.
    // We could have avoided it if we were using linked lists and this is the reason
    // merge sort is better for sorting linkedLists
    private int[] tempMergArr;

    public int[] sort(int[] arr) {
        tempMergArr = new int[arr.length];
        this.mergeSort(0, arr.length-1, arr);
        return arr;
    }
    private void mergeSort(int low, int high, int[] arr) {
        if (high > low) {
            int middle = (low + high) / 2; // Divide the array into two equal part

            mergeSort(low, middle, arr);
            mergeSort(middle + 1, high, arr);

            // Merge the two sub arrays
            merge(low, middle, high, arr);
        }
    }

    /*
        One important point to consider here is that the array lower bound is not a Zero
        For this reason we will take three params
        @param lowerIndex: Starting index of the first subarray
        @param middle: Ending index of the first subarray
            middle+1 will be the starting index of the second array
        @param higherIndex: last index of the second subarray
    */
    private void merge(int lowerIndex, int middle, int higherIndex, int[] arr) {

        // First get the elements into the temp array
        // This helps as now we will not loose the data
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = arr[i];
        }

        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        // Start from lower and middle as they will behave as our two sub-arrays
        while (i <= middle && j <= higherIndex) {
            // Use the temp array for comparing as its data is never shifted
            if (tempMergArr[i] <= tempMergArr[j]) {
                // put the smaller element at the lower part
                arr[k] = tempMergArr[i];
                // as we have added element from the left side so shift our pointer
                // to next element
                i++;
            } else {
                arr[k] = tempMergArr[j];
                j++;
            }
            // Always move K so that we can move to the next element
            k++;
        }
        // Handle the cases where one of the array is over so we will
        // put the remaining index from the second array
        while (i <= middle) {
            arr[k] = tempMergArr[i];
            k++;
            i++;
        }
        while (j <= higherIndex) {
            arr[k] = tempMergArr[j];
            k++;
            j++;
        }
    }
}
