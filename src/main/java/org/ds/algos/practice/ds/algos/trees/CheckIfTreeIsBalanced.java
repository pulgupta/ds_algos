package org.ds.algos.practice.ds.algos.trees;

import org.ds.algos.practice.ds.algos.trees.Tree.Node;

public class CheckIfTreeIsBalanced {

    static class Height {
        int height = 0;
    }

    public static boolean isHeightBalanced(Node root, Height height) {
        // If root is null then height is zero and such tree is always balanced
        if (root == null) {
            height.height = 0;
            return true;
        }
        Height lHeight = new Height();
        Height rHeight = new Height();
        // Check if the left sub tree is balanced
        boolean l = isHeightBalanced(root.left, lHeight);
        // Check if the right sub tree is balanced
        boolean r = isHeightBalanced(root.right, rHeight);
        // Get the left and right sub tree height
        int lh = lHeight.height;
        int rh = rHeight.height;

        // The height of the current node is one more than max of left and right height
        height.height = (lh > rh ? lh : rh) + 1;

        // Check if the distance is not more than 1
        if ((lh - rh > 1) || (rh - lh > 1))
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
