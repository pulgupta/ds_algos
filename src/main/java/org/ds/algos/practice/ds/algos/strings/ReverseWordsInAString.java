package org.ds.algos.practice.ds.algos.strings;

/**
 * ALGORITHM
 * 1) Reverse the individual words, we get the below string.
 *    "i ekil siht margorp yrev hcum"
 * 2) Reverse the whole string from start to end and you get the desired output.
 *    "much very program this like i"
 * @author pulgupta
 *
 */
public class ReverseWordsInAString {
	
	public static void reverseWords(String message) {
		// Pass 1 
		// Reverse the characters within a word
		char[] arr = message.toCharArray();
		int starting=0;
		int ending=-1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i] == ' ' || i==arr.length-1) {
				if(i==arr.length-1)
					ending = i;
				else
					ending=i-1;
				for(int j=starting;j<=ending;j++, ending--) {
					char temp = arr[j];
					arr[j] = arr[ending];
					arr[ending]=temp;
				}
				starting=i+1;
			}
			
		}
		
		// Second Pass
		// Reverse the complete string
		for(int i=0; i<arr.length/2; i++) {
			char temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
		for(char i : arr)
			System.out.print(i);
		System.out.println();
	}
	public static void main(String[] args) {
		reverseWords("like codes");
		reverseWords("I like to code program");
		reverseWords("Lets test this a bit more");
		reverseWords("This program is proving to be wonderful");
	}

}
