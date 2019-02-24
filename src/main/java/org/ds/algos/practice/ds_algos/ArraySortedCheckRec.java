package org.ds.algos.practice.ds_algos;

/**
 * This class checks if the array is sorted or not using recursion
 * @author pulgupta
 *
 */
public class ArraySortedCheckRec {

	public boolean checkIfSorted(int[] arr, int index) {
		
		if(index == arr.length-1)
			return true;
		if(arr[index] > arr[index+1])
			return false;
		return checkIfSorted(arr, index);
	}
	
	public static void main(String[] args) {
		int arr[] = {3,9,45,1,88};
		ArraySortedCheckRec ascr = new ArraySortedCheckRec();
		System.out.println(ascr.checkIfSorted(arr, 0));
	}
}

