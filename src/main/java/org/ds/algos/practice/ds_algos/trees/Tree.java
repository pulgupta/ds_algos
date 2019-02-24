package org.ds.algos.practice.ds_algos.trees;

public class Tree {

	static class Node {
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
	
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.createTree();
		System.out.println(tree.getTreeHeight(root));
	}
}
