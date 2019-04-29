package org.ds.algos.practice.ds_algos.sorting;

/**
 * Merge sort works by dividing the arrays into smaller arrays and
 * once they are broken down to a single element level we will then merge them
 * 
 * @author pulgupta
 *
 */
public class MergeSort {
	
	static int[] arr = {3,2,5,7,1,4,6};
	static int [] tempMergArr = new int[arr.length];
	
	public static void mergeSort(int low, int high) {
		
		if(high>low) {
			int middle = (low + high)/2;
			mergeSort(low ,middle);
			mergeSort(middle+1, high);
			// Merge the divided part
			merge(low, middle, high);
		}
	}
	
	public static void merge(int lowerIndex, int middle, int higherIndex) {
		// First get the elements into the temp array 
		// This helps as now we will not loose the data
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = arr[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        // Start from lower and middle as they will behave
        // as our two sub-arrays
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
        	// Always move K so that we can set the next element
            k++;
        }
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
	
	public static void main(String args[]) {
		mergeSort(0, arr.length-1);
		for (int  a : arr) {
			System.out.println(a);
		}
	}
}
