package org.ds.algos.practice.ds_algos.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.ds.algos.practice.ds_algos.trees.Tree.Node;

/**
 * The idea is to use the in-order traversal in spiral form logic to make sure we are 
 * Aware of the level boundaries.
 * Based on these level boundaries we can add the element to a stack.
 * Finally we can get the elements from the stack and that will be our solution
 * @author pulgupta
 *
 */
public class ReverseLevelOrderTraversal {

	Stack<List<Node>> elements = new Stack<>();
	Queue<Node> queue = new LinkedList<>();
	
	public void reverselevelOderderTraversal(Node root) {
		queue.add(root);
		elements.add(Collections.singletonList(root));
		int currentLevelCount = 1;
		int nextLevelCount = 0;
		while(!queue.isEmpty()) {
			List<Node> temp = new ArrayList<>();
			nextLevelCount=0;
			while(currentLevelCount!=0) {
				Node current = queue.poll();
				if(current.left!=null) {
					queue.add(current.left);
					temp.add(current.left);
					nextLevelCount++;
				}
				if(current.right!=null) {
					queue.add(current.right);
					temp.add(current.right);
					nextLevelCount++;
				}
				currentLevelCount--;
			}
			elements.add(temp);
			currentLevelCount = nextLevelCount;
		}
		
		// Start printing
		while(!elements.isEmpty()) {
			List<Node> list = elements.pop();
			for(Node n : list)
				System.out.print(n.data + " ");
		}
		
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		new ReverseLevelOrderTraversal()
			.reverselevelOderderTraversal(tree.createTree());
	}
}