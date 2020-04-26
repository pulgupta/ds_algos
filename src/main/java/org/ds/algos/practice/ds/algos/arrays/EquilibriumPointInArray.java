package org.ds.algos.practice.ds.algos.arrays;

/**
 * Find the point in an array where the left sum and right sum are equal
 * @author pulgupta
 */
public class EquilibriumPointInArray {

	public int getEquilibriumPoint(int[] arr) {
		int sum_left = 0;
		int sum_right = 0;
		for(int i=0;i<arr.length;i++) {
			sum_right+=arr[i];
		}
		// In this loop i is the pivot point
		for(int i=0;i<arr.length;i++) {
			sum_right-=arr[i];
			if(sum_left == sum_right)
				return i++;
			sum_left+= arr[i];
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 2, 2};
		EquilibriumPointInArray obj = new EquilibriumPointInArray();
		System.out.println(obj.getEquilibriumPoint(arr));
	}
}
