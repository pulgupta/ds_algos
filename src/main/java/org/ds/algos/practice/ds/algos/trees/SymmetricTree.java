package org.ds.algos.practice.ds.algos.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Symmetric tree is a tree where the left sub-tree is the mirror image of the right sub-tree
 *  Example:
 *              1
 *           /    \
 *          2     2
 *        /  \   /  \
 *       3   4  4   3
 *
 */
public class SymmetricTree {
    public boolean isSymmetricTree(Tree.Node tree) {
        Queue<Tree.Node> q1 = new LinkedList<>();
        Queue<Tree.Node> q2 = new LinkedList<>();
        if(tree == null) return true;
        q1.add(tree.left);
        q2.add(tree.right);
        while(!q1.isEmpty() || !q2.isEmpty()) {
            Tree.Node node1 = q1.remove();
            Tree.Node node2 = q2.remove();

            if(node1 == null && node2 == null) continue;
            if(node1 == null && node2 != null) return false;
            if(node1 != null && node2 == null) return false;
            if(node1.data != node2.data) {
                return false;
            }
            q1.add(node1.left);
            q1.add(node1.right);
            q2.add(node2.right);
            q2.add(node2.left);
        }
        return true;
    }
}
