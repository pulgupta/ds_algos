package org.ds.algos.practice.ds_algos.trees;

import org.ds.algos.practice.ds_algos.trees.Tree.Node;

public class LowestCommonAncestorInBST {

	public static int getLowestCommonAncestor(Node root, int firstKey, int secondKey) {
		if (firstKey > secondKey) {
			System.out.println("Frist Key should always be less than second key");
			return -1;
		}
		if (root == null) {
			return -1;
		}
		if (firstKey < root.data && secondKey < root.data)
			return getLowestCommonAncestor(root.left, firstKey, secondKey);
		else if(firstKey > root.data && secondKey > root.data)
			return getLowestCommonAncestor(root.right, firstKey, secondKey);
		return root.data;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		Node rootBST = tree.createBST();
		System.out.println(LowestCommonAncestorInBST.getLowestCommonAncestor(rootBST, 1, 3));
	}
}
