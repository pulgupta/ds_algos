package org.ds.algos.practice.ds_algos;

public class BackTrack_ArrayFill {

	public boolean arrayFill(int n, int[] arr, int current) {
		if(current == 0)
			return true;
		
		//Lets try for each and ever situation
		for(int i=0; i<n ; i++){
			if(arr[i] == 0 && arr[i+current+1] ==0) {
				arr[i] = current;
				arr[i+current+1] = current;
			}
			
			this.printArray(arr);
			
			if(arrayFill(i, arr, current-1))
				return true;
			
			//This possibility of putting current from i has failed
			//we will back track
			arr[i] = 0;
			arr[i+current+1] = 0;
				
		}
		return false;
	}
	
	public void printArray(int[] arr) {
		System.out.println("Status of array at this point");
		for (int val : arr) {
			System.out.println(val);
		}
	}
	public static void main (String[] args) {
		BackTrack_ArrayFill af = new BackTrack_ArrayFill();
		int n = 3;
		int[] arr = new int[2*n];
		System.out.println(af.arrayFill(n, arr, n));
	}
}
