package org.ds.algos.practice.ds.algos.trees;

import org.ds.algos.practice.ds.algos.trees.Tree.Node;

public class CheckIfTreeIsBalanced {

    public boolean heightBalancedBinaryTree(Node tree) {
        boolean[] balanced = new boolean[] {true};
        isBalanced(tree, balanced);
        return balanced[0];
    }
    private int isBalanced(Node tree, boolean[] balanced) {

        if(!balanced[0]) {
            return 0;
        }

        if (tree == null) {
            return 0;
        }

        int leftHeight = isBalanced(tree.left, balanced);
        int rightHeight = isBalanced(tree.right, balanced);

        if(Math.abs(leftHeight - rightHeight) > 1) balanced[0] = false;

        return 1 + Math.max(leftHeight, rightHeight);

    }
}
