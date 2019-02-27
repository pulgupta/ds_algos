package org.ds.algos.practice.ds_algos.heaps;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {
	//This array will store the heap elements
	static List<Integer> heap;
	
	static{
		heap = new ArrayList<Integer>();
	}
	
	//Returns the minimum element of the heap
	public int getMin() {
		return heap.get(0);
	}
	
	public int peek() {
		heap.set(1,  null);//removed the first element
		//swapping the last element with the first
		heap.set(1, heap.get(heap.size()));
		return 0;
	}
	
	public static void main(String[] args) {
		//Main method to call the heap operations
		
	}
}
