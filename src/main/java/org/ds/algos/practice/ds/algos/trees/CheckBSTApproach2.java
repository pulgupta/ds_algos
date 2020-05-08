package org.ds.algos.practice.ds.algos.trees;

public class CheckBSTApproach2 {
    public boolean checkBST_BestWay(Tree.Node root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.data < min) || (max != null && root.data > max))
            return false;

        if (!checkBST_BestWay(root.left, min, root.data) || !checkBST_BestWay(root.right, root.data, max)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CheckBSTApproach2 obj = new CheckBSTApproach2();
        Tree tree = new Tree();
        // Should return true as this in indeed a BST
        System.out.println(obj.checkBST_BestWay(tree.createBST(), null, null));
        /**
         *          10
         *         /  \
         *        5   15
         *       /
         *      3
         *     /
         *    8
         */
        Tree.Node node5 = new Tree.Node(8, null, null);
        Tree.Node node4 = new Tree.Node(3, node5, null);
        Tree.Node node3 = new Tree.Node(5, node4, null);
        Tree.Node node2 = new Tree.Node(15, null, null);
        Tree.Node node1 = new Tree.Node(10, node3, node2);
        System.out.println(obj.checkBST_BestWay(node1, null, null));

    }
}
