package org.ds.algos.practice.ds.algos.trees;

public class DiameterOfTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        // Maximise the height of left tree + height of right tree
        if (tree == null) return 0;

        int leftHeight = height(tree.left);
        int rightHeight = height(tree.right);
        int total = leftHeight + rightHeight;

        int height1 = Math.max(binaryTreeDiameter(tree.left), binaryTreeDiameter(tree.right));
        return Math.max(total, height1);
    }

    int height(BinaryTree tree) {
        if (tree == null) return 0;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }
}
