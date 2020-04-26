package org.ds.algos.practice.ds.algos.sorting;

public class InsetionSort {
	public static void main(String[] args) {
		insertionSort();
		
	}

	private static void insertionSort() {
		int[] arr = {9,2,4,1,8};
		int key, current;
		//Pick an element and then check it with the next left element.
		//If the next left element is smaller just swap the elements
		//Continue this till the very left and you are sorted.
		for(int i=1;i <arr.length;i++) {
			//we will compare the next element with the already sorted sub array
			key = i-1;
			current = i;
			while(key>=0 && arr[key] > arr[current]) { 
				int temp = arr[current];
				arr[current] = arr[key];
				arr[key] = temp;
				key--;
				current--;
			}
		}
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
}
