package org.ds.algos.practice.ds.algos.arrays;

/**
 * A peak element is a element which is larger than its
 * adjacent elements. In case of first and last elements we
 * should consider only single adjacent element.
 * @author pulgupta
 *
 */
public class PeekElements {
	
	public static int countPeeks(int[] arr) {
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(i==0) {
				if(arr[i]>arr[i+1]) 
					count++;
			}
			else if(i==arr.length-1) {
				if(arr[i]>arr[i-1])
					count++;
			}
			else if (arr[i]>arr[i+1] && arr[i]>arr[i-1])
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,2,5,1,2};
		System.out.println(countPeeks(arr));
	}
}
