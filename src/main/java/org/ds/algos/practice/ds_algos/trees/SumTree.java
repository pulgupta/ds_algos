package org.ds.algos.practice.ds_algos.trees;

import org.ds.algos.practice.ds_algos.trees.Tree.Node;

/**
 * @author pulgupta
 *
 */
public class SumTree {

	// Find the sum of children at a particular node
	public static int findSum(Node node) {
		// Empty node
		if(node == null)
			return 0;
		return findSum(node.left) + node.data + findSum(node.right);
	}
	
	public static boolean isSumTree(Node node) {
		
		if ((node == null) || (node.left == null && node.right == null)) 
            return true;
		
		int ls = findSum(node.left);
		int rs = findSum(node.right); 
		
		return (node.data == ls + rs) && isSumTree(node.left) 
				&& isSumTree(node.right);
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		System.out.println(isSumTree(tree.createTree()));
	}
}
