package org.ds.algos.practice.ds_algos.trees;

import java.util.LinkedList;
import java.util.Queue;
import org.ds.algos.practice.ds_algos.trees.Tree.Node;

public class MaximumElement {
	/**
	 * Finding the largest node in a tree.
	 * As this being a normal tree we can't use the binary approach in it
	 * @param root : Root node of the tree
	 * @return : Returns the largest node
	 */
	public int maxElement(Node root){
		int maximum = 0;
		maximum = root.data;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			Node node = queue.poll();
			if(node.data>maximum)
				maximum=node.data;
			if(node.left!=null)
				queue.offer(node.left);
			if(node.right!=null)
				queue.offer(node.right);	
		}
		return maximum;
	}
	
	/**
	 * Finds the number of leaf nodes in a tree.
	 * A leaf node is a node which has both the left and the right nodes as
	 * null
	 * @param root : Root node of the tree
	 * @return : Number of leaves in the tree
	 */
	public int numberOfLeaves(Node root) {
			int numberOfLeaves = 0;
			Queue<Node> queue = new LinkedList<>();
			queue.offer(root);
			while(!queue.isEmpty()){
				Node node = queue.poll();
				if(node.left==null && node.right == null)
					numberOfLeaves++;
				if(node.left!=null)
					queue.offer(node.left);
				if(node.right!=null)
					queue.offer(node.right);	
			}
			return numberOfLeaves;
	}
	
	public static void main(String[] args) {
		MaximumElement me = new MaximumElement();
		System.out.println(me.maxElement(new Tree().createTree()));
		System.out.println(me.numberOfLeaves(new Tree().createTree()));
	}
}
