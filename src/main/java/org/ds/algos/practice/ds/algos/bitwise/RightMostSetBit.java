package org.ds.algos.practice.ds.algos.bitwise;

public class RightMostSetBit {

	public static int rightMost(int num) {
		int pos = 1;
		int m = 1;
		
		while((m & num) == 0) {
			m = m << 1;
			pos++;
		}
		return pos;
	}
	
	public static void main(String[] args) {
		System.out.println(rightMost(8)); 
		System.out.println(rightMost(8)); 
	}
}
