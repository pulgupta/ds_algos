package org.ds.algos.practice.ds.algos.sorting;

/**
 * In merge sort all the processing is in the merge step.
 * In the normal step we just recursively divide the problem into smaller problems.
 * However in case of quick sort we do all the processing in dividing the problems 
 * into smaller problems. The merge step is a fairly simple affair
 * @author pulgupta
 */
public class QuickSort {

	static int[] arr = {2,9,4,7,8,1,3};
	
	public static void quickSort(int low, int high) {
		
		if(low<high) {
			int pivot = partition(low, high);
			quickSort(low, pivot);
			quickSort(pivot+1, high);
		}
	}
	/**
	 * The idea is to start two pointers 
	 * 1 for iterating the array and the second to mark the 
	 * location before which all elements are smaller than the 
	 * pivot. Once i reaches pivot location swap the pivot to its 
	 * correct position
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partition(int low, int high) {
		//in this step we will just pick the last element as the pivot
		int pivot = arr[high-1];
		System.out.print("\n\nPivot is " + pivot);
		//lets bring the pivot to the right position
		int pivotpos=low-1;
		int i=low;
		while(i < high) {
			if(arr[i] < pivot ) {
				pivotpos++;
				int temp = arr[pivotpos];
				arr[pivotpos] = arr[i];
				arr[i] = temp;
				
			}
			i++;
		}
		arr[high-1] = arr[pivotpos+1];
		arr[pivotpos+1] = pivot;
		
		System.out.println("\nArray after this iteration");
		for (int ii : arr) {
			System.out.print(ii+ " " );
		}
		
		return pivotpos+1;
	}
	public static void main(String[] args) {
		quickSort(0, arr.length);
		System.out.println("\nArray after this iteration");
		for (int ii : arr) {
			System.out.print(ii+ " " );
		}
	}
}
