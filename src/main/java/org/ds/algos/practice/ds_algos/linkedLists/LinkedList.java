package org.ds.algos.practice.ds_algos.linkedLists;

public final class LinkedList {
	
	static final class Node {
		private int key;
		private Node next;
		
		public Node(int key, Node next) {
			super();
			this.key = key;
			this.next = next;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	
	public static Node getLinkedList() {
		Node node5 = new Node(5, null);
		Node node4 = new Node(6, node5);
		Node node3 = new Node(3, node4);
		Node node2 = new Node(2, node3);
		Node root = new Node(5, node2);
		return root;
	}	
	
	public static Node getCircularLinkedList() {
		Node head = new Node(1, null);
		Node node2 = new Node(2, null);
		head.setNext(node2);
		Node node3 = new Node(3, null);
		node2.setNext(node3);
		Node node4 = new Node(4, null);
		node3.setNext(node4);
		Node node5 = new Node(5, null);
		node4.setNext(node5);
		Node node6 = new Node(6, null);
		node5.setNext(node6);
		Node node7 = new Node(7, null);
		node6.setNext(node7);
		node7.setNext(node4);
		return head;
	}
	
	public static void printList(Node root) {
		while(root!=null) {
			System.out.print(root.key);
			root = root.getNext();
			System.out.print(root != null ? " -> " : "");
			
		}
	}
}
