package org.ds.algos.practice.ds_algos.trees;

public class Tree {

	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	/* This is the tree we will be using
	 *
	 *		1
	 *	   / \
	 *    2   5
	 *   / \
	 *  3  4
	 *  
	 */
	public Node returnTree() {
		
		Node node1 = new Node(1, null, null);
		Node node2 = new Node(2, null, null);
		Node node3 = new Node(3, null, null);
		Node node4 = new Node(4, null, null);
		Node node5 = new Node(5, null, null);
		
		//Link all the nodes as per the above tree
		node1.left = node2;
		node1.right = node5;
		node2.left = node3;
		node2.right = node4;	
		
		return node1;
		
	}
}
