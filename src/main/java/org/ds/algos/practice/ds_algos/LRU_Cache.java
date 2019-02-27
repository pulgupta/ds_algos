package org.ds.algos.practice.ds_algos;

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

public class LRU_Cache {

	private static final int QUEUE_LIMIT = 5;
	Map<Integer, Node> map;
	private static int currentSize = 0;
	private static Node head;
	private static Node tail;
	
	public LRU_Cache() {
		map = new HashMap<Integer, Node>();
	}
	
	// The cache can only be used to get the data
	public int get(int key) {
		// Check cache hit or cache miss
		if(map.get(key)==null) {
			// Cache Miss
			// Manage Cache Queue
			if(head==null && tail==null) {
				// Queue is empty add the node both as head and tail
				head = tail = new Node(key);
				map.put(key, head);
				currentSize++;
			} else if ( currentSize<QUEUE_LIMIT ) {
				// Add to the front of the queue
				Node newNode = new Node(key);
				newNode.next = head;
				head.previous = newNode;
				head = newNode;
				map.put(key, newNode);
				currentSize++;
			} else if (currentSize == QUEUE_LIMIT) {
				// Removed the element from the end and update tail
				Node temp = tail;
				tail.previous.next = null;
				tail = tail.previous;
				temp.previous = null;
				map.remove(temp.key);
				temp = null;
				
				// Add the element to the front
				Node newNode = new Node(key);
				newNode.next = head;
				head.previous = newNode;
				head = newNode;
				map.put(key, newNode);
			}
		} else {
			// Cache Hit	
			Node nodeHit = map.get(key);
			// Move the node to the front if it is not the head
			if(nodeHit.key == tail.key) {
				nodeHit.previous.next = null;
				tail = nodeHit.previous;
				nodeHit.previous = null;
				nodeHit.next = head;
				head.previous = nodeHit;
				head = nodeHit;
			}
			else if(nodeHit.key != head.key) {
				nodeHit.previous.next = nodeHit.next;
				nodeHit.next.previous = nodeHit.previous;
				nodeHit.next = head;
				head.previous = nodeHit;
				nodeHit.previous = null;
				head = nodeHit;
			}
			map.put(key, head);
		}
		return key;
	}
	
	public void printQueue() {
		if(head == null) {
			System.out.print("Queue is empty and size is " + currentSize);
		} else {
			Node itr = head;
			System.out.println("\n\nSize is " + currentSize);
			while(itr!=null) {
				System.out.print(itr.key + "  ");
				itr = itr.next;
			}
			Node itr1 = tail;
			System.out.println("\nSize is " + currentSize);
			while(itr1!=null) {
				System.out.print(itr1.key + "  ");
				itr1 = itr1.previous;
			}
		}
	}
	
	public static void main(String args[]) {
		LRU_Cache cache = new LRU_Cache();
		cache.printQueue();
		cache.get(5);
		cache.printQueue();
		cache.get(6);
		cache.printQueue();
		cache.get(7);
		cache.printQueue();
		cache.get(6);
		cache.printQueue();
		cache.get(8);
		cache.printQueue();
		cache.get(9);
		cache.printQueue();
		cache.get(1);
		cache.printQueue();
		cache.get(1);
		cache.printQueue();
		cache.get(7);
		cache.printQueue();
		cache.get(7);
		cache.printQueue();
		cache.get(6);
		cache.printQueue();
	}
}
