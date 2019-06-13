package org.ds.algos.practice.ds_algos.trees;

import java.util.Stack;
import org.ds.algos.practice.ds_algos.trees.Tree.Node;

public class FindPath {

	Stack<Node> path = new Stack<>();

	public boolean hasPath(Node root, int element) {

		if (root == null)
			return false;
		// Assume that this root lie in the path
		path.push(root);

		if (path.peek().data == element) {
			// If this is the element for which we are finding the path
			return true;
		} else {

			// At this point check if the current node left or right children has 
			// this element. If yes we return true, else we return false and remove
			// this node from the path
			if (hasPath(root.left, element))
				return true;

			if (hasPath(root.right, element))
				return true;
		}
		
		path.pop();
		return false;
	}

	public static void main(String[] args) {
		FindPath fp = new FindPath();
		Tree tree = new Tree();
		Node rootNode = tree.createTree();
		fp.hasPath(rootNode, 4);
		for (Node node : fp.path) {
			System.out.println(node.data);

		}
	}
}
