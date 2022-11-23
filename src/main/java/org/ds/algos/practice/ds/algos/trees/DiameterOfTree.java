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

    static class TreeInfo {
        public int height;
        public int diameter;

        public TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        return getTreeInfo(tree).diameter;
    }

    TreeInfo getTreeInfo(BinaryTree tree) {
        if(tree == null) return new TreeInfo(0, 0);

        TreeInfo leftInfo = getTreeInfo(tree.left);
        TreeInfo rightInfo = getTreeInfo(tree.right);

        int totalHeight = leftInfo.height + rightInfo.height;
        int finalDiameter = Math.max(totalHeight, Math.max(leftInfo.diameter, rightInfo.diameter));
        int height = 1 + Math.max(leftInfo.height, rightInfo.height);

        return new TreeInfo(height, finalDiameter);
    }
}
