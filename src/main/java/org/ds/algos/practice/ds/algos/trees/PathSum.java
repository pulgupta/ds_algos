package org.ds.algos.practice.ds.algos.trees;

import org.ds.algos.practice.ds.algos.trees.Tree.Node;

/**
 * Find if a root to leaf path in a tree has a particular sum
 * @author pulgupta
 *
 */
public class PathSum {
	
	public boolean pathSum(Node node, int sum) {
		if(node==null)
			return false;
		// if we have found a node then return true;
		if(node.left==null && node.right==null && node.data == sum)
			return true;
		if(node.left!=null)
			// If we have find the path keep on unwinding recursive calls
			if(pathSum(node.left, sum-node.data))
				return true;
		if(node.right!=null)
			// If we have find the path keep on unwinding recursive calls
			if(pathSum(node.right, sum-node.data))
				return true;
		return false;
	}
	
	public static void main(String[] args) {
		PathSum obj = new PathSum();
		Tree tree = new Tree();
		System.out.println(obj.pathSum(tree.createTree(), 7));
	}
}
