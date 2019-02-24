package org.ds.algos.practice.ds_algos.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.ds.algos.practice.ds_algos.trees.Tree.Node;

class Tracker {
	Node left;
	Node right;
	
	public Tracker() {};
	
	public Tracker(Node left, Node right) {
		this.left = left;
		this.right = right;
	}
}

// Do a level order traversal and store the leftmost and the right most element in each level
// For the bottom view we can just store the leaf nodes.
public class TreeParameter {

	Tree tree = new Tree();
	Node root = tree.createTree();
	int temp, count = 1;
	List<Tracker> solution = new ArrayList<Tracker>(3);
	Queue<Node> inorderQueue = new LinkedList<Node>();
	
	
	// Calculating the right and left parameter
	public void leftAndRightParemeter(Node root) {
		inorderQueue.add(root);
		int height = 0;
		solution.add(new Tracker(root, null));
		while(!inorderQueue.isEmpty()) {
			height++;
			System.out.println(height);
			solution.add(new Tracker());
			temp = 0;
			for(int i=0;i<count;i++) { // This loop will run for all the nodes in the same level
				Node itr = inorderQueue.poll();
				if(itr.left!=null) {
					inorderQueue.add(itr.left);
					if(solution.get(height).left==null)
						solution.get(height).left = itr.left;
					temp++;
				}
				if(itr.right!=null) {
					inorderQueue.add(itr.right);
					solution.get(height).right = itr.right;
					temp++;
				}
			}
			count=temp;
		}
	}
	
	public static void main(String args[]) {
		TreeParameter treeParameter = new TreeParameter();
		treeParameter.leftAndRightParemeter(treeParameter.root);
		for(Tracker tracker: treeParameter.solution) {
			System.out.println(tracker.left!=null?tracker.left.data:""); 			
			System.out.println(tracker.right!=null? tracker.right.data:"");
		}
		System.out.println("Execution Completed");
	}
}