package org.ds.algos.practice.ds.algos.arrays;

public class SortArrayOf0And1 {
	
	public static int[] sort(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while(low<high) {
			if(arr[low] == 0)
				low++;
			else {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				high--;
			}
				
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 0, 1, 1, 0, 1, 0, 0, 1};
		arr = sort(arr);
		for(int i: arr)
			System.out.print(i + " ");
	}

}
