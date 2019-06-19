package org.ds.algos.practice.ds_algos.trees;

public class CheckBST {

    Tree.Node previous = null;

    /**
     * Check if the tree is a BST or not
     * Time Complexity O(n)
     * Space Complexity O(1)
     * @param root
     * @return
     */
    public boolean checkBST(Tree.Node root) {

        if(root == null)
            return true;

        if(!checkBST(root.left))
            return false;

        /**
         * This will check if the previous encountered data
         * is less than the current data.
         */
        if(previous != null && previous.data > root.data) {
            return false;
        } else {
            previous = root;
        }

        if(!checkBST(root.right))
            return false;

        return true;
    }

    public static void main(String[] args) {
        CheckBST obj = new CheckBST();
        Tree tree = new Tree();
        // Should return true as this in indeed a BST
        System.out.println(obj.checkBST(tree.createBST()));
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
        System.out.println(obj.checkBST(node1));


    }
}
