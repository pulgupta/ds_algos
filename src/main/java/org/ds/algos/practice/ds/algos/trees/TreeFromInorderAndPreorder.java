package org.ds.algos.practice.ds.algos.trees;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class TreeFromInorderAndPreorder {
    int current = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || inorder.length == 0 || preorder.length == 0)
            return null;
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {

        if (left > right)
            return null;

        TreeNode node = new TreeNode();
        node.val = preorder[current++];
        int index = getIndex(inorder, node.val);

        if (left == right)
            return node;

        node.left = buildTreeHelper(preorder, inorder, left, index - 1);
        node.right = buildTreeHelper(preorder, inorder, index + 1, right);

        return node;
    }

    public int getIndex(int[] inorder, int value) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == value)
                return i;
        }
        return -1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
