package org.ds.algos.practice.ds_algos.trees;

import java.util.Stack;

import org.ds.algos.practice.ds_algos.trees.Tree.Node;

/**
 ** INCOMPLETE **
 */
public class PostOrderIterative {

	/* 		1      
	 *	   / \     
	 *    2   5    
	 *   / \       
	 *  3   4      
	 */
	private static void postOrderIterative(Node node) {
		if(node == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		Node current = node;
		while (!stack.isEmpty() || current!=null) {
			while (current.left!=null) {
				stack.push(current);
				current = current.left;
			}
			Node processed = stack.pop();
				
		}
	}
	
	public static void main(String[] args) {
		Node root = new Tree().createTree();
		postOrderIterative(root);
	}
	
}
