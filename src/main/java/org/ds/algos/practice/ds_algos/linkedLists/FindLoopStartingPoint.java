package org.ds.algos.practice.ds_algos.linkedLists;

import org.ds.algos.practice.ds_algos.linkedLists.LinkedList.Node;

/**
 * 1. If a loop is found, initialize slow pointer to head, 
 *       let fast pointer be at its position.
 * 2. Move both slow and fast pointers one node at a time.
 * 3. The point at which they meet is the start of the loop.
 * @author pulgupta
 */
public class FindLoopStartingPoint {

	public static Node getLoopStartingNode(Node head) {
		Node slow = head.getNext();
		Node fast = head.getNext().getNext();
		while(slow != fast) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		System.out.println("Pointers met at " + fast.getKey());
		slow = head;
		while(slow != fast) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		return slow;
	}
	
	public static void main(String[] args) {
		// 1->2->3->4->5
		//			^  |
		//          |  |
		//	        7<-6
		Node head = LinkedList.getCircularLinkedList();
		System.out.println(getLoopStartingNode(head).getKey());
	}
	
	
}
