package org.ds.algos.practice.ds_algos.recursion;

public class TailRecursion {

	/**
	 * Tail recursion where we have saved the intermediate data not on the 
	 * stack but in a variable
	 * @param n : The number for which we have to find the factorial
	 * @param result : This parameter behaves as an accumulator
	 * @return : The factorial of the number
	 */
	private int factorial(int n, int result) {
		if(n == 1)
			return result; // As soon as we return this chain of returns start and we will get the final value
		return factorial(n-1, result*n);
	}
	
	//Overloaded method so that someone cannot call factorial accidently using a wrong result param
	public int factorial(int n) {
		return factorial(n, 1);
	}
	
	public static void main(String[] args) {
		TailRecursion tr = new TailRecursion();
		System.out.println(tr.factorial(5));
	}
}
