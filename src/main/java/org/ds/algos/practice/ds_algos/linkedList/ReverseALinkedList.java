package org.ds.algos.practice.ds_algos.linkedList;

import org.ds.algos.practice.ds_algos.linkedList.LinkedList.Node;

public class ReverseALinkedList {

	public static Node reverseASinglyLinkedList(Node root) {
		Node previous=null;
		Node current = root;
		Node next = root.getNext();
		
		while(current!=null) {
			current.setNext(previous);
			previous = current;
			current = next;
			if(current!=null)
				next = current.getNext();
		}
		return previous;	
	}
	
	public static void main(String args[]) {
		LinkedList linkedList = new LinkedList();
		Node root = linkedList.getLinkedList();
		System.out.println("**Original**");
		linkedList.printList(root);
		System.out.println("\n\n**Reversed**");
		linkedList.printList(ReverseALinkedList.reverseASinglyLinkedList(root));
	}
}
