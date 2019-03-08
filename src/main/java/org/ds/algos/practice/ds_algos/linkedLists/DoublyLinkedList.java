package org.ds.algos.practice.ds_algos.linkedLists;

public class DoublyLinkedList {

	static final class DoublyNode {
		final private int key;
		private DoublyNode next;
		private DoublyNode previous;
		
		public DoublyNode(int key, DoublyNode next, DoublyNode previous) {
			super();
			this.key = key;
			this.next = next;
			this.previous = previous;
		}

		public int getKey() {
			return key;
		}

		public DoublyNode getNext() {
			return next;
		}

		public DoublyNode getPrevious() {
			return previous;
		}

		public void setNext(DoublyNode next) {
			this.next = next;
		}

		public void setPrevious(DoublyNode previous) {
			this.previous = previous;
		}
	}
	
	public DoublyNode getDoublyLinkedList() {
		DoublyNode node5 = new DoublyNode(5, null, null);
		DoublyNode node4 = new DoublyNode(4, node5, null);
		node5.previous = node4;
		DoublyNode node3 = new DoublyNode(3, node4, null);
		node4.previous = node3;
		DoublyNode node2 = new DoublyNode(2, node3, null);
		node3.previous = node2;
		DoublyNode root = new DoublyNode(1, node2, null);
		node2.previous = root;
		return root;
	}
	
	
}
