package org.ds.algos.practice.ds_algos.trees;

import java.util.List;

import static org.ds.algos.practice.ds_algos.trees.Tree.Node;

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
