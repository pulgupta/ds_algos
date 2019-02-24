package org.ds.algos.practice.ds_algos;

public class MaximumSubArray {
	public static void main(String[] args) {
		int[] arr = {100,1,-10,2,-150,-1,32,98};
		int max_so_far = 0, max_ending_here = 0;
		for(int i=0;i<arr.length;i++) {
			max_ending_here+=arr[i]; 
			if(max_ending_here < 0)
				max_ending_here = 0;
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		
		System.out.println(max_so_far);
	}
}
