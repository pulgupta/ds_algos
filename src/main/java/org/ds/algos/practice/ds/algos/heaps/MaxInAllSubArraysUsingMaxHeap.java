package org.ds.algos.practice.ds.algos.heaps;

import java.util.PriorityQueue;

/**
 * find the maximum element in each window of size k in an array
 * @author pulgupta
 */
public class MaxInAllSubArraysUsingMaxHeap {

	public static void getMaxInAllSubArray(int[] arr, int k) {
		// I am using a Priority Queue which is a min heap implementation
		// but will be adding the elements in their negative form to make it a
		// Max heap
		PriorityQueue<Integer> queue = new PriorityQueue<>();	
		for(int i=0; i<arr.length; i++) {
			if(queue.size()<k)
				queue.add(arr[i]*-1);
			else  {
				System.out.print(queue.peek()*-1 + " ");
				queue.remove(arr[i-k]*-1);
				queue.add(arr[i]*-1);
			}
		}
		System.out.print(queue.peek()*-1);
	}
	
	public static void main(String args[]) {
		int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		MaxInAllSubArraysUsingMaxHeap.getMaxInAllSubArray(arr, 4);
	}
}
