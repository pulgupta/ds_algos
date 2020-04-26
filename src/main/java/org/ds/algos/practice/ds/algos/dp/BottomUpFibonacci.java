package org.ds.algos.practice.ds.algos.dp;

public class BottomUpFibonacci {

	private static long[] array = new long[100];
	
	private static long fibonacci(int n) {
		
		if(n>=100)
			return -1;
		if(n==1 || n==2)
			return 1;
		array[1] = array[2] = 1;
		for (int i=3;i<=n;i++) {
			array[i] = array[i-1] + array[i-2];
		}
		return array[n];
	}
	
	public static void main(String args[]) {
		System.out.println("Result " + fibonacci(99));
		System.out.println("Array contents");
		for(long i: array) 
			if(i!=0)
				System.out.println(i);
		
	}
}
