package org.ds.algos.practice.ds_algos.dp;

public class MemoizedFibonacci {
	// Memo to hold all the solutions to "common" subproblem
	static int[] memo = new int[100];
	public static int fibonacci(int n) {
		if(n>=100)
			return -1;
		memo[1]=1;
		memo[2]=1;
		if(n==1 || n==2)
			return 1;
		//------------------------------------------------------------
		if(memo[n]!=0) 			//considering indexes from 1
			return memo[n];
		int f = fibonacci(n-1)+fibonacci(n-2);
		memo[n]=f;
		return f;
	}
	
	public static void main(String args[]) {
		System.out.println("Result " + fibonacci(10));
		//------------------------------------------------------------
		System.out.println("Lets see the contents of our memo");
		for(int i : memo) {
			if(i!=0) {
				System.out.println(i);
			}
		}
	}
}
