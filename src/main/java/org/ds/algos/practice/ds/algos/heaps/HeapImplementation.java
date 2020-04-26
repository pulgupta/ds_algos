package org.ds.algos.practice.ds.algos.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeapImplementation {
	private static List<Integer> myHeap;
	static {
		myHeap = new ArrayList<>();
	}
	//Heap Operations
	private static void insert(int data) {
		if(myHeap.size()==0) {
			myHeap.add(-1);
		}
		int size = myHeap.size();
		myHeap.add(size, data);
		int pointer=size;
		while(myHeap.get(pointer/2)>data && pointer>1){
			int parent = myHeap.get(pointer/2);
			int child = myHeap.get(pointer);
			myHeap.set(pointer/2, child);
			myHeap.set(pointer, parent);
			pointer=pointer/2;
		}
			
	}
	private static void delete(int data){
		int index=0;
		for (int i=0;i<myHeap.size();i++) {
			if(myHeap.get(i)==data){
				index=i;
				break;
			}
				
		}
		int size = myHeap.size();
		myHeap.set(index, myHeap.get(size-1));
		myHeap.remove(size-1);
		size = myHeap.size();
		int pointer=index;
		while(pointer < (size)/2){
			int parent = myHeap.get(pointer);
			int child1 = myHeap.get(pointer*2);

			//Check if both the child exists
			if(pointer*2+1<size) {
				int child2 = myHeap.get(pointer*2 + 1);
				if(parent>child1 || parent>child2) {
					myHeap.set(pointer, (child1<child2) ? child1 : child2);
					if(child1<child2)
						myHeap.set(pointer*2, parent);
					else
						myHeap.set(pointer*2 +1, parent);
				}
			}
			else
			{	
				if(parent>child1) {
					myHeap.set(pointer, child1);
					myHeap.set(pointer*2, parent);
				}
			}
				
			
			
			pointer=pointer+1;
		}
	}
	private static int returnMin() {
		return myHeap.get(1);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			switch (in.nextInt()) {
			case 1:
				int dataInst = in.nextInt();
				insert(dataInst);
				break;
			case 2:
				int dataDel = in.nextInt();
				delete(dataDel);
				break;
			default:
				System.out.println(returnMin());
				break;
			}
		}
		in.close();
	}
}
