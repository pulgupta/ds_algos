package org.ds.algos.practice.ds_algos.dp;

public class MinimumJumps {

	int minJumpsDp(int[] arr) {
		int n = arr.length;
		int jumps[] = new int[n];
		int i, j;

		if (n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE; 

		jumps[0] = 0;

		for (i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (j = 0; j < i; j++) {
				if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}
		return jumps[n - 1];
	}

	/**
	 * The idea here is to get the maximum ladder.
	 * If we have the maximum ladder we will very well be able to 
	 * try all ladders. Also we are not jumping to the maximum.
	 * We are keeping it to get our reach and then we try all the cases 
	 * in that reach. 
	 * @param arr
	 * @return
	 */
	int minJumpsIterative(int[] arr) {
		int n = arr.length;
		if (n == 0 || arr[0] == 0)
			return -1;
		int ladder = arr[0];
		int stairs = arr[0];
		int jump = 1;
		for(int i=1; i<n; i++) {
			if(i==n-1)
				return jump;
			// Try to get the maximum ladder while on the current ladder
			if(i + arr[i] > ladder)
				ladder = i + arr[i];
			stairs--;
			if (stairs == 0) {
				jump++;
				stairs = ladder - i;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		MinimumJumps obj = new MinimumJumps();
		int[] arr = { 1, 3, 5, 9, 8, 2, 6, 7 };
		System.out.println(obj.minJumpsDp(arr));
		System.out.println(obj.minJumpsIterative(arr));
	}

}
