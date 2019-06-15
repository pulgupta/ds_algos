package org.ds.algos.practice.ds_algos.arrays;

class Result {
	int startIndex;
	int endIndex;
	
	public Result(int startIndex, int endIndex) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	@Override
	public String toString() {
		return "Result [startIndex=" + startIndex + ", endIndex=" + endIndex + "]";
	}
	
	
}
/**
 * Find the continuous sub array in an array with the sum equal to X
 * The trick here is to move the left and right pointer in a single iteration
 * @author pulgupta
 */
public class SumOfContinousSubArray {

	public Result getSubArrayDetails(int[] arr, int sum) {
		int startIndex = 0;
		int endIndex = 0;
		int sumSoFar = arr[0];
		while(startIndex >= 0 && endIndex >= startIndex && endIndex < arr.length) {
			if(sumSoFar == sum)
				return new Result(startIndex+1, endIndex+1);
			// In the sum is smaller keep adding the next element
			if(sumSoFar < sum) {
				endIndex++;
				sumSoFar+=arr[endIndex];
			}
			// In case the sum is getting bigger we are moving the left pointer ahead
			if(sumSoFar > sum) {
				sumSoFar-= arr[startIndex];
				startIndex++;
			}
		}
		return null;
	}
	
	public static void main(String args[]) {
		int[] arr = { 2, 1, 7, 5, 3 };
		SumOfContinousSubArray obj = new SumOfContinousSubArray();
		System.out.println(obj.getSubArrayDetails(arr, 12));
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(obj.getSubArrayDetails(arr1, 15));
	}
}
