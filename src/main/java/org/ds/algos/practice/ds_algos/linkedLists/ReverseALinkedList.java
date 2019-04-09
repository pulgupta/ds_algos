package org.ds.algos.practice.ds_algos.linkedLists;

import org.ds.algos.practice.ds_algos.linkedLists.LinkedList.Node;

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
		Node root = LinkedList.getLinkedList();
		System.out.println("**Original**");
		LinkedList.printList(root);
		System.out.println("\n\n**Reversed**");
		LinkedList.printList(ReverseALinkedList.reverseASinglyLinkedList(root));
	}
}
