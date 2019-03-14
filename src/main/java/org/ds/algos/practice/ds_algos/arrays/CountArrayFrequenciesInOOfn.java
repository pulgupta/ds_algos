package org.ds.algos.practice.ds_algos.arrays;

public class CountArrayFrequenciesInOOfn {
	
	public static int[] calculateFrequencies(int[] arr) {
		
		int i=0;
		while(i < arr.length) {
			if(arr[i]<0) {
				i++;
			} else {
				int index = arr[i]-1;
				if(arr[index] < 0) {
					arr[index]--;
					arr[i]=0;
					i++;
				} else {
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
