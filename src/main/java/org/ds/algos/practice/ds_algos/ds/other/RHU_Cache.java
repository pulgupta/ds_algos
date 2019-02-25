package org.ds.algos.practice.ds_algos.ds.other;

import java.util.HashMap;
import java.util.Map;

class Node {
	int key;
	Node next;
	Node previous;
	
	public Node(int key) {
		this.key = key;
		this.next = null;
		this.previous = null;
	}
	
	public Node(int key, Node next, Node previous) {
		this.key = key;
		this.next = next;
		this.previous = previous;
	}
}

public class RHU_Cache {

	private static final int QUEUE_LIMIT = 5;
	Map<Integer, Node> map = new HashMap<>();
	private static int currentSize = 0;
	private static Node head;
	private static Node tail;
	
	// The cache can only be used to get the data
	public int get(int key) {
		// Check cache hit or cache miss
		if(map.get(key)!=null) {
			// Cache Hit
			// Manage Cache Queue
			if(head==null && tail==null) {
				// Queue is empty add the node both as head and tail
				head = tail = new Node(key);
				currentSize++;
			} else if ( currentSize<QUEUE_LIMIT ) {
				
			}
			return key;
		} else {
			// Cache Miss
			return -1;	
		}
	}
	
}
