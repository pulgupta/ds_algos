package org.ds.algos.practice.ds_algos.trees;

import org.ds.algos.practice.ds_algos.trees.Tree.Node;

public class CheckIfTreeIsBalanced {

	static class Height {
		int height = 0;
	}

	public static boolean isHeightBalanced(Node root, Height height) {
		if (root == null) {
			height.height = 0;
			return true;
		}
		Height lHeight = new Height();
		Height rHeight = new Height();
		boolean l = isHeightBalanced(root.left, lHeight);
		boolean r = isHeightBalanced(root.right, rHeight);
		int lh = lHeight.height, rh = rHeight.height;

		height.height = (lh > rh ? lh : rh) + 1;

		if ((lh - rh >= 2) || (rh - lh >= 2))
			return false;
		else
			return l && r;
	}

	public static void main(String[] args) {

		Tree tree = new Tree();
		Node root = tree.createBST();
		isHeightBalanced(root, new Height());
	}
}
