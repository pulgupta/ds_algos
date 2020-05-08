package org.ds.algos.practice.ds.algos.trees;

import java.util.Stack;

/**
 * * INCOMPLETE **
 */
public class PostOrderIterative {

    /* 		1
     *	   / \
     *    2   5
     *   / \
     *  3   4
     */
    private static void postOrderIterative(Tree.Node node) {
        if (node == null)
            return;
        Stack<Tree.Node> stack = new Stack<Tree.Node>();
        Tree.Node current = node;
        while (!stack.isEmpty() || current != null) {
            while (current.left != null) {
                stack.push(current);
                current = current.left;
            }
            Tree.Node processed = stack.pop();

        }
    }

    public static void main(String[] args) {
        Tree.Node root = new Tree().createTree();
        postOrderIterative(root);
    }

}
