package org.ds.algos.practice.ds_algos.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.ds.algos.practice.ds_algos.trees.Tree.Node;

public class InorderTraversal {
	
	boolean checkBST(Node root) {
		List<Integer> order = new ArrayList<>();
		getInorder(root, order);
		boolean isSorted = true;
		for (int i = 0; i < order.size()-1; i++) {
			if(order.get(i)>order.get(i+1)){
				isSorted=false;
				break;
			}
		}
		return isSorted;
	}
	void getInorder(Node root, List<Integer> list) {
		if(root==null)
			return;
		getInorder(root.left, list);
		list.add(root.data);
		getInorder(root.right, list);
	}
	
	/* 		1      
	 *	   / \     
	 *    2   5    
	 *   / \       
	 *  3   4      
	 */
	void getInorderIteratively(Node node) {
		Stack<Node> stack = new Stack<Tree.Node>();
		if (node == null)
			return;
		Node current = node;
		while (!stack.isEmpty() || current != null) {
			// While the sub tree is not empty keep on adding them
			while(current!=null) {
				stack.push(current);
				current = current.left;
			}
			// No more left sub tree
			Node temp = stack.pop();
			System.out.println(temp.data);
			// We now have to move to the right sub tree of the just popped out node
			current = temp.right;
		}
		
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		Node root = tree.createTree();
		InorderTraversal obj = new InorderTraversal();
		obj.getInorderIteratively(root);
	}
}
