package org.ds.algos.practice.ds_algos;

import java.util.Scanner;

public class FirstNonRepeatingString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		char[] charArray = input.toCharArray();
		int length = charArray.length;
		if(charArray[0] != charArray[1]) {
			System.out.println(charArray[0]);
			System.exit(0);
		}
		
		for(int i=1; i<length; i++) {
			if(charArray[i-1] != charArray[i] && charArray[i] != charArray[i+1]){
				System.out.println(charArray[i]);
				System.exit(0);
			}
		}
		
		if(charArray[length-2] != charArray[length-1]) {
			System.out.println(charArray[length-1]);
			System.exit(0);
		}
		in.close();
	}
}
