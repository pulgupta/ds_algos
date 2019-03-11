package org.ds.algos.practice.ds_algos.trees;

import org.ds.algos.practice.ds_algos.trees.Tree.Node;

public class ConvertBinaryTreeToDoublyLinkedList {

	public static Node treeToDoublyLinkedList(Node root) {
		if(root == null)
			return;
		treeToDoublyLinkedList(root.left)
		return null;
	}
	
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = tree.createTree();
		treeToDoublyLinkedList(root);
		// As now it is linked list we can just traverse it in a 
		// Liner fashion
		while(root!=null) {
			System.out.println(root.data);
			root=root.right;
		}
	}
}
