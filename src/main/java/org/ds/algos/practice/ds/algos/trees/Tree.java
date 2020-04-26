package org.ds.algos.practice.ds.algos.trees;

import java.util.Objects;

public class Tree {

	static class Node implements Comparable<Node> {
		int data;
		Node left;
		Node right;
		
		public Node() {
			super();
		}
		
		public Node(int data) {
			this.data = data;
		}
		
		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Node node = (Node) o;
			return data == node.data;
		}

		@Override
		public int hashCode() {
			return Objects.hash(data);
		}

		@Override
		public int compareTo(Node o) {
			return data - o.data;
		}

		@Override
		public String toString() {
			return "Node{" +
					"data=" + data +
					'}';
		}
	}
	
	/* This is the tree we will be using for most of our testing
	 *
	 *		1      |      1
	 *	   / \     |     / \
	 *    2   5    |    5   2
	 *   / \       |       / \
	 *  3   4      |      4   3
	 */
	public Node createTree() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		//Link all the nodes as per the above tree
		node1.left = node2;
		node1.right = node5;
		node2.left = node3;
		node2.right = node4;	
		
		return node1;
		
	}
	
	/* This is a BST we will be using for most of our testing
	 *
	 *		4
	 *	   / \
	 *    2   5
	 *   / \
	 *  1  3
	 *  
	 */
	public Node createBST() {
		Node node1 = new Node(10);
		Node node2 = new Node(20);
		Node node3 = new Node(30);
		Node node4 = new Node(40);
		Node node5 = new Node(50);
		
		//Link all the nodes as per the above tree
		node4.left = node2;
		node4.right = node5;
		node2.left = node1;
		node2.right = node3;	
		
		return node4;
		
	}
	
	// This is a recursive way of calculating the height
	// Get the height of the left sub tree and then the height of the right sub tree
	// If left sub tree height is more then return 1+leftHeight else return 1+rightHeight 
	// We can also do it in iterative way by doing in-order traversal and tracking the height
	public int getTreeHeight(Node root) {
		
		if(root == null)
			return 0;
		int dleft = getTreeHeight(root.left);
	    int dright = getTreeHeight(root.right);
	       
	    if(dleft > dright)
	    	return dleft+1;
	    else
	    	return dright+1;
	}

	public int getTreeHeightApproach2(Node root) {
		// Base Case
		if(root == null)
			return 0;
		// Recursively check for the height of left and right sub tree and return 1 more than that
		return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
	}

	public void printInorder(Node root) {
		if(root == null)
			return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}
	
	// Just for testing
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.createTree();
		System.out.println(tree.getTreeHeight(root));
		System.out.println(tree.getTreeHeightApproach2(root));
	}
}
