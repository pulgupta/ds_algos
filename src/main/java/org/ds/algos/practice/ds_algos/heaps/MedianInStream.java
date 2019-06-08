package org.ds.algos.practice.ds_algos.heaps;

import java.util.PriorityQueue;

/**
 * To calculate the median in a running stream, the idea is to keep on adding numbers
 * from the stream into a min heap and a max heap.
 * @author pulgupta
 * 
 */
public class MedianInStream {

	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;
	int median;
	
	public MedianInStream() {
		maxHeap = new PriorityQueue<Integer>();
		minHeap = new PriorityQueue<Integer>();
		median = Integer.MAX_VALUE;
	}

	public void printMedian(int num) {
		int maxHeapSize = maxHeap.size();
		int minHeapSize = minHeap.size();
		if(num > median) {
			// check if it need shifting
			if(minHeapSize-maxHeapSize == 1) {
				maxHeap.add(minHeap.poll() * -1);
				minHeap.add(num);
			} else {
				minHeap.add(num);
			}	
			median = getMedian();
		} else {
			// same check to see if we need shifting
			if(maxHeapSize-minHeapSize == 1) {
				minHeap.add(maxHeap.poll() * -1);
				maxHeap.add(num * -1);
			} else {
				maxHeap.add(num * -1);
			}
			median = getMedian();
		}
		System.out.println(median);
	}
	
	public int getMedian() {
		int maxHeapSize = maxHeap.size();
		int minHeapSize = minHeap.size();
		if(maxHeapSize == minHeapSize)
			return ((maxHeap.peek()*-1) + minHeap.peek())/2;
		else if(maxHeapSize>minHeapSize)
			return maxHeap.peek()*-1;
		else
			return minHeap.peek();
	}

	public static void main(String[] args) {
		int[] arr = {2,4,6,1,5,3,5,1,7,5,4};
		MedianInStream obj = new MedianInStream();
		for(int item : arr) {
			obj.printMedian(item);
		}
	}
	
}
