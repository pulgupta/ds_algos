package org.ds.algos.practice.ds.algos.trees;

import static org.ds.algos.practice.ds.algos.trees.Tree.*;

/**
 * We have two separate thees. Given the root nodes of the two trees
 * merge the two trees into a new tree
 */
public class MergeTwoTrees {
    public Node mergeBinaryTrees(Node tree1, Node tree2) {
        Node newNode = null;
        if(tree1 !=null && tree2 != null) {
            newNode = new Node(tree1.data + tree2.data);
            newNode.left = mergeBinaryTrees(tree1.left, tree2.left);
            newNode.right = mergeBinaryTrees(tree1.right, tree2.right);
        } else if(tree1 != null) {
            newNode = new Node(tree1.data);
            newNode.left = mergeBinaryTrees(tree1.left, null);
            newNode.right = mergeBinaryTrees(tree1.right, null);
        }
        else if(tree2!=null) {
            newNode = new Node(tree2.data);
            newNode.left = mergeBinaryTrees(null, tree2.left);
            newNode.right = mergeBinaryTrees(null, tree2.right);
        }
        return newNode;
    }
}
