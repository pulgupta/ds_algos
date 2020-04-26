package org.ds.algos.practice.ds.algos.trees;

import static org.ds.algos.practice.ds.algos.trees.Tree.Node;

/**
 * The idea is same as we were doing in the BST.
 * However in BST because of its properties we were able to decide where the key lies.
 * In normal binary tree we are forced to find the node in the subtrees to decide which
 * sub tree to check next.
 * @author pulgupta 
 */
public class LowestCommonAncestorInTree {

    public static Node getLowestCommonAncestor(Node root, int node1, int node2) {
        if(root == null)
            return null;
        boolean isOnLeft1 = contains(root.left, node1);
        boolean isOnLeft2 = contains(root.left, node2);

        if(root.data == node1 || root.data == node2)
            return root;

        if(isOnLeft1 && isOnLeft2)
            return getLowestCommonAncestor(root.left, node1, node2);
        if(!isOnLeft1 && !isOnLeft2)
            return getLowestCommonAncestor(root.right, node1, node2);

        return root;
    }

    private static boolean contains(Node root, int node) {
        if(root==null)
            return false;
        if(root.data == node)
            return true;
        return contains(root.right, node) || contains(root.left, node);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node rootNode = tree.createTree();
        System.out.println(getLowestCommonAncestor(rootNode,3,4));
    }
}
