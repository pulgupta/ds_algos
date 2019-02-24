package org.ds.algos.practice.ds_algos.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int data;
	TreeNode left, right;
}

class Tracker {
	TreeNode left;
	TreeNode right;
}
// Do a level order traversal and store the leftmost and the right most element in each level
// For the bottom view we can just store the leaf nodes.
public class TreeParameter {

	int temp, count = 1;
	List<Tracker> solution = new ArrayList<Tracker>();
	Queue<TreeNode> inorderQueue = new LinkedList<TreeNode>();
	
	public void levelOrder(TreeNode node) {
		
		while(!inorderQueue.isEmpty()) {
			for(int i=0;i<count;i++) {
				temp = 0;
				if(node.left!=null) {
					inorderQueue.add(node);
					temp++;
				}
				if(node.left!=null) {
					inorderQueue.add(node);
					temp++;
				}
			}
			count=temp;
		}
	}
}
