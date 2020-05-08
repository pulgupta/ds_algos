package org.ds.algos.practice.ds.algos.heaps;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {
    //This array will store the heap elements
    List<Integer> heap;

    public BinaryHeap() {
        heap = new ArrayList<>();
    }

    //Returns the minimum element of the heap
    public int getMin() {
        return heap.get(0);
    }

    public int peek() {
        heap.set(1, null);//removed the first element
        //swapping the last element with the first
        heap.set(1, heap.get(heap.size()));
        return 0;
    }

    public void createHeap(List<Integer> data) {
        heap = data;
        // Lets start our heapify
        int size = heap.size();
        // If we have a heap of size n then leaf node starts from
        // n/2. Hence we are starting from the last non leaf node.
        // Also we start in a bottom up fashion, so we first create a 
        // min heap at lower level and then we move towards the top
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i, size);
        }
    }

    public int poll() {
        int result = heap.get(0);
        // Swap the root with the last element
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0, heap.size());
        return result;
    }

    private void heapify(int i, int size) {
        int minimum = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        // Find the minimum child
        // Size check is to make sure we are not going beyond the array size
        if (l < size && heap.get(i) > heap.get(l)) {
            minimum = l;
        }
        // Bounded by the size check if the right child is less than the root and the left child
        if (r < size && heap.get(minimum) > heap.get(r)) {
            minimum = r;
        }
        // swap the minimum child with the root
        // With one swap we can make sure that all the three nodes are 
        // now in a sub heap
        if (minimum != i) {
            int temp = heap.get(i);
            heap.set(i, heap.get(minimum));
            heap.set(minimum, temp);
            // Recursively check all the lower levels where we have pushed down the root
            // This is because in a heap all the sub notes also satisfy the heap policy.
            heapify(minimum, size);
        }
    }

    public void printHeap() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i));
            if (i < heap.size() - 1)
                System.out.print("->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Main method to call the heap operations
        BinaryHeap heap = new BinaryHeap();
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(1);
        list.add(2);
        heap.createHeap(list);
        System.out.println("print heap after creation");
        heap.printHeap();

        System.out.println("Smallest element is " + heap.poll());
        heap.printHeap();

    }
}
