package org.ds.algos.practice.ds_algos;

public class KadanesAlgoMaxContSum {
	
	private static int max_so_far=0;
	private static int max_here=0;
	public static int kadanesAlgorithm(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			max_here = max_here+arr[i];
			if(max_here<0)
				max_here=0;
			else if (max_here>max_so_far)
				max_so_far=max_here;
		}
		return max_so_far;
	}

	public static void main(String args[]) {
		int[] arr = {1, 5 -8, -5, -3, 6, 1};
		System.out.println(KadanesAlgoMaxContSum.kadanesAlgorithm(arr));
	}
}
