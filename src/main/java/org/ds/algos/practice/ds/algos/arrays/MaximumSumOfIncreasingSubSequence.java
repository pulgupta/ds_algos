package org.ds.algos.practice.ds.algos.arrays;

public class MaximumSumOfIncreasingSubSequence {

	public static int getMaximumSumOfInscreasingSubArray(int[] arr) {
		int length = arr.length;
		int[] maxSum = new int[length];
		maxSum[0] = arr[0];
		// iterate over the loop
		for(int i=1; i<length; i++ ) {
			// Iterate on the already calculated values
			for(int j=i;j>=0;j--) {
				// If the previous element is smaller than add its sum and 
				// break to prevent moving to even smaller value
				if(arr[j]<arr[i]) {
					maxSum[i] = maxSum[j]+arr[i];
					break;
				}
				// if no value is less in the sub array then use the 
				// current value as the sum
				maxSum[i]=arr[i];
			}
		}
		int result=0;
		for(int i: maxSum)
			if(result<i)
				result = i;
		return result;
	}
	
	public static void main(String args[]) {
		 int[] arr = {1, 101, 2, 3, 100, 4, 5 };
		 System.out.println(MaximumSumOfIncreasingSubSequence.getMaximumSumOfInscreasingSubArray(arr));
	}
}
