package org.ds.algos.practice.ds_algos.trees;

import org.ds.algos.practice.ds_algos.trees.Tree.Node;

/**
 * Find if a root to leaf path in a tree has a particular sum
 * @author pulgupta
 *
 */
public class PathSum {

	
	public boolean pathSum(Node node, int sum) {
		if(node==null)
			return false;
		boolean ans = false;
		if(node.left==null && node.right==null && node.data == sum)
			return true;
		/**
		 * this is a very neat trick to pull the result up from the 
		 * stack while we are recursive calling the method.
		 * In this particular case if at any time the above condition
		 * evaluates to true and we are returning true, it will be 
		 * finally returned by the help of the ans and its or condition. 
		 */
		if(node.left!=null)
			ans = ans || pathSum(node.left, sum-node.data);
		if(node.right!=null)
			ans = ans || pathSum(node.right, sum-node.data);
		return ans;
	}
	
	public static void main(String[] args) {
		PathSum obj = new PathSum();
		Tree tree = new Tree();
		System.out.println(obj.pathSum(tree.createTree(), 7));
	}
}
