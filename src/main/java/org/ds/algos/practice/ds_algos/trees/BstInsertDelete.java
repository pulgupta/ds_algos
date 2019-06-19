package org.ds.algos.practice.ds_algos.trees;

public class BstInsertDelete {

    /**
     * Insert the node at the correct place making sure it is still a BST
     * We will not be balancing the tree once the node is inserted
     * Time Complexity :
     * Space Complexity :
     * @param root Tree root node
     * @param parent parent node
     * @param node The node to be inserted
     */
    public Tree.Node insertNode(Tree.Node root, Tree.Node parent, Tree.Node node) {
        if(root == null) {
            if(node.data < parent.data)
                parent.left = node;
            else
                parent.right = node;
            return node;
        }
        // The idea is to find the place where the node really belongs
        if(node.data > root.data) {
            return insertNode(root.right, root, node);
        }
        return insertNode(root.left,root, node);
    }

    /**
     * Delete the node from the tree and make sure it is still a BST
     * Time Complexity :
     * Space Complexity :
     * @param node
     */
    public void deleteNode(Tree.Node node) {

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Tree.Node root = tree.createBST();
        BstInsertDelete obj = new BstInsertDelete();
        obj.insertNode(root, null, new Tree.Node(25, null, null));
        tree.printInorder(root);
    }
}
