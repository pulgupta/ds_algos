package org.ds.algos.practice.ds_algos.trees;

import java.util.LinkedList;
import java.util.Queue;

import org.ds.algos.practice.ds_algos.trees.Tree.Node;

public class MirrorImageOfTree {

	public static Node getMirrorImageOfATree(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			if(current.left!=null)
				queue.add(current.left);
			if(current.right!=null)
				queue.add(current.right);
			Node temp = current.left;
			current.left = current.right;
			current.right = temp;
		}
		return root;
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		Node root = tree.createTree();
		tree.printInorder(root);
		System.out.println("\n\n**After creating a mirror image**");
		tree.printInorder(getMirrorImageOfATree(root));
	}
}
