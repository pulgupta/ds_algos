package org.ds.algos.practice.ds_algos.trees;

import org.ds.algos.practice.ds_algos.trees.Tree.Node;

public class SumTree {

	// Find the sum of children at a particular node
	public static int findSum(Node node) {
		// Empty node
		if(node == null)
			return 0;
		// Leaf node
		if(node.left == null && node.right == null)
			return node.data;
		return findSum(node.left) + findSum(node.right);
	}
	
	public static boolean isSumTree(Node node) {
		
		
		if(node == null)
			return true;
		int ls = findSum(node.left);
		int rs = findSum(node.right); 
		
		
		return false;
	}
	
}
