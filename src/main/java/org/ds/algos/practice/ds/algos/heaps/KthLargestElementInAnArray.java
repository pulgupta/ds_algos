package org.ds.algos.practice.ds.algos.heaps;

public class KthLargestElementInAnArray  {

    public int findKthLargest(int[] nums, int k) {
        MyHeap heap = new MyHeap(k);
        for(int i: nums)
            heap.add(i);
        return heap.getMin();
    }
}

class MyHeap {

    // Min Heap
    int[] heap;

    public MyHeap(int heapSize) {
        heap = new int[heapSize];
        for(int i=0; i<heapSize; i++)
            heap[i] = Integer.MIN_VALUE;
    }

    public void add(int element) {
        // When element is greater than the smallest element in the heap
        if(element > heap[0]) {
            heap[0] = element;
            heapify(0);
        }
    }

    public int getMin(){
        return heap[0];
    }

    private void heapify(int root) {
        if(root > (heap.length/2)-1)
            return;

        // Left child node is bigger
        if(heap[root] > heap[2*root+1]) {
            swap(root, 2*root+1);
            heapify(2*root+1);
        }

        // right child node is bigger
        if(2*root+2 < heap.length && heap[root] > heap[2*root+2]) {
            swap(root, 2*root+2);
            heapify(2*root+2);
        }

    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
