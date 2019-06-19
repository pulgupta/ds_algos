package org.ds.algos.practice.ds_algos.trees;

public class CheckBST {

    Tree.Node previous = null;

    /**
     * Check if the tree is a BST or not
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
        // Should return false as this is not a BST
        System.out.println(obj.checkBST(tree.createTree()));
    }
}
