package org.ds.algos.practice.ds.algos.trees.traversal;

import org.ds.algos.practice.ds.algos.trees.Tree;
import org.ds.algos.practice.ds.algos.trees.Tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public void getInorderRecursively(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        getInorderRecursively(root.left, list);
        list.add(root.data);
        getInorderRecursively(root.right, list);
    }

    /* 		1
     *	   / \
     *    2   5
     *   / \
     *  3   4
     */
    public List<Integer> getInorderIteratively(Node node) {
        List<Integer> list = new ArrayList();
        Stack<Node> stack = new Stack<Node>();
        if (node == null)
            return null;
        Node current = node;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            Node temp = stack.pop();
            list.add(temp.data);
            current = temp.right;
        }
        return list;
    }
}
