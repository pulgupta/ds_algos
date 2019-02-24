package org.ds.algos.practice.ds_algos.sorting;

/**
 * Merge sort works by dividing the arrays into smaller arrays and
 * once they are broken down to a single element level we will then merge them
 * 
 * @author pulgupta
 *
 */
public class MergeSort {
	
	static int[] arr = {3,2,5,7,1};
	static int [] tempMergArr = new int[arr.length];
	
	public static void mergeSort(int low, int high) {
		
		if(high>low) {
			int middle = (low + high)/2;
			mergeSort(low ,middle);
			mergeSort(middle+1, high);
			merge(low, middle, high);
		}
	}
	
	public static void merge(int lowerIndex, int middle, int higherIndex) {
		for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = arr[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                arr[k] = tempMergArr[i];
                i++;
            } else {
                arr[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            arr[k] = tempMergArr[i];
            k++;
            i++;
        }
	}
	
	public static void main(String args[]) {
		mergeSort(0, arr.length-1);
		for (int  a : arr) {
			System.out.println(a);
		}
	}
}
