package org.ds.algos.practice.ds.algos.trees;

import java.util.Stack;

import static org.ds.algos.practice.ds.algos.trees.Tree.*;

public class TreeToDll {

    public Node convertTreeToDll(Node root) {
        Node result = null;
        Node previous = null;
        Node temp = null;
        Stack<Node> stack = new Stack<Node>();
        if (root == null)
            return null;
        Node current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            temp = stack.pop();
            if(result == null) {
                result = temp;
                previous = temp;
            } else {
                temp.left = previous;
                previous.right = temp;
                previous = temp;
            }
            // We now have to move to the right sub tree of the just popped out node
            current = temp.right;
        }
        return result;
    }

}
