package org.ds.algos.practice.ds.algos.trees;

/**
 *
 Write a function that takes in a Binary Tree (where nodes have an additional
 pointer to their parent node) as well as a node contained in that tree and
 returns the given node's successor.

 A node's successor is the next node to be visited (immediately after the given
 node) when traversing its tree using the in-order tree-traversal technique. A
 node has no successor if it's the last node to be visited in the in-order
 traversal.

 */
public class InOrderSuccessor {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if(node.right == null)
            return finder(node);
        return rightFinder(node.right);
    }

    public BinaryTree finder(BinaryTree node) {
        BinaryTree parent = node.parent;
        if(parent == null) return null;
        if(parent.left !=null && parent.left.value == node.value) {
            return parent;
        }
        return finder(node.parent);
    }

    public BinaryTree rightFinder(BinaryTree node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}
