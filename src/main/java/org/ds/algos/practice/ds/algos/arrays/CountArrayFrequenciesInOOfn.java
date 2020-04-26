package org.ds.algos.practice.ds.algos.arrays;

/**
 * In an array of size n and containing numbers from 1...n calculate
 * the frequencies of all the numbers
 * @author pulgupta
 */
public class CountArrayFrequenciesInOOfn {
	
	public static int[] calculateFrequencies(int[] arr) {
		/*
		 * The idea here is to store all the counts as negatives
		 */
		int i=0;
		while(i < arr.length) {
			// If the index has negative value then we already have a count 
			if(arr[i]<0) {
				i++;
			} else {
				int index = arr[i]-1;
				// We can increment the count 
				if(arr[index] < 0) {
					arr[index]--;
					arr[i]=0;
					i++;
				} else {
					// Swap the number to current, and set -1 as the count
					arr[i] = arr[index];
					arr[index] = -1;
				}
			}
		}
		
		return arr;
	}
	
	public static void main(String args[]) {
		
		int arr[] = {5, 4, 5, 3, 1, 1, 4};
 		arr = calculateFrequencies(arr);
 		for(int i: arr) {
 			System.out.print(i * -1 + " ");
 		}
	}

}
