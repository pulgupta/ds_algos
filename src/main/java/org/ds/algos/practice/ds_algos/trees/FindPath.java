package org.ds.algos.practice.ds_algos.trees;

import java.util.Stack;
import org.ds.algos.practice.ds_algos.trees.Tree.Node;

public class FindPath {

	Stack<Node> path = new Stack<>();

	public void findPath(Node root, int element) {
		path.push(root);
		while (!path.isEmpty()) {
			if (path.peek().data == element) {
				return;
			} 
			else {
				if (path.peek().left != null) {
					path.push(root.left);
				}
				if (root.right != null) {
					path.push(root.right);
				}
			}
		}

		return;
	}

	public static void main(String[] args) {
		FindPath fp = new FindPath();
		Tree tree = new Tree();
		Node rootNode = tree.createTree();
		fp.findPath(rootNode, 4);
		for (Node node : fp.path) {
			System.out.println(node.data);

		}
	}
}
