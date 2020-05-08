package org.ds.algos.practice.ds.algos.trees;

public class BstInsertDelete {

    /**
     * Insert the node at the correct place making sure it is still a BST
     * We will not be balancing the tree once the node is inserted
     * Time Complexity :
     * Space Complexity :
     *
     * @param root   Tree root node
     * @param parent parent node
     * @param node   The node to be inserted
     */
    public Tree.Node insertNode(Tree.Node root, Tree.Node parent, Tree.Node node) {
        if (root == null) {
            if (node.data < parent.data) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            return node;
        }
        // The idea is to find the place where the node really belongs
        if (node.data > root.data) {
            return insertNode(root.right, root, node);
        } else {
            return insertNode(root.left, root, node);
        }
    }

    /**
     * Delete the node from the tree and make sure it is still a BST
     * Time Complexity :
     * Space Complexity :
     *
     * @param root   Tree root node
     * @param parent parent node
     * @param node   The node to be deleted
     */
    public Tree.Node deleteNode(Tree.Node root, Tree.Node parent, Tree.Node node) {
        //We have find the element to delete
        if (root.equals(node)) {
            if (root.left != null && root.right != null) {
                Tree.Node min = findMinimum(root.right, null);
                root.data = min.data;
                deleteNode(root.right, root, min);
            } else if (root.left == null) {
                if (root.data < parent.data) {
                    parent.left = root.right;
                } else {
                    parent.right = root.right;
                }
            } else if (root.right == null) {
                if (root.data < parent.data) {
                    parent.left = root.left;
                } else {
                    parent.right = root.left;
                }
            }
            return node;
        }
        if (node.data > root.data) {
            return deleteNode(root.right, root, node);
        } else {
            return deleteNode(root.left, root, node);
        }
    }

    private Tree.Node findMinimum(Tree.Node root, Tree.Node min) {
        if (root == null)
            return null;
        if (min == null)
            min = root;
        if (root.compareTo(min) < 0)
            min = root;
        if (root.left != null)
            min = findMinimum(root.left, min);
        return min;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Tree.Node root = tree.createBST();
        BstInsertDelete obj = new BstInsertDelete();
        obj.insertNode(root, null, new Tree.Node(25, null, null));
        tree.printInorder(root);
        obj.insertNode(root, null, new Tree.Node(22, null, null));
        System.out.println("\nRound 2");
        tree.printInorder(root);
        obj.deleteNode(root, null, new Tree.Node(20, null, null));
        System.out.println("\nAfter deletion");
        tree.printInorder(root);
        obj.deleteNode(root, null, new Tree.Node(30, null, null));
        System.out.println("\nAfter deletion");
        tree.printInorder(root);
    }
}
