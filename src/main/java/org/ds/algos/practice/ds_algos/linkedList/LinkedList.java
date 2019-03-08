package org.ds.algos.practice.ds_algos.linkedList;

public final class LinkedList {
	
	static final class Node {
		final private int key;
		private Node next;
		
		public Node(int key, Node next) {
			super();
			this.key = key;
			this.next = next;
		}

		public int getKey() {
			return key;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	
	public Node getLinkedList() {
		Node node5 = new Node(5, null);
		Node node4 = new Node(4, node5);
		Node node3 = new Node(3, node4);
		Node node2 = new Node(2, node3);
		Node root = new Node(1, node2);
		return root;
	}	
	
	public void printList(Node root) {
		while(root!=null) {
			System.out.print(root.key);
			root = root.getNext();
			System.out.print(root != null ? " -> " : "");
			
		}
	}
}
