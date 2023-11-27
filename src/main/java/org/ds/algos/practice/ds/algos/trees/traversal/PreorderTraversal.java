package org.ds.algos.practice.ds.algos.trees.traversal;

import org.ds.algos.practice.ds.algos.trees.Tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public void getPreorderRecursively(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        getPreorderRecursively(root.left, list);
        getPreorderRecursively(root.right, list);
    }

    /* 		1
     *	   / \
     *    2   5
     *   / \
     *  3   4
     */
    public List<Integer> getPreorderIteratively(Node node) {
        List<Integer> list = new ArrayList();
        Stack<Node> stack = new Stack<>();
        if (node == null) {
            return list;
        }
        stack.push(node);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            list.add(current.data);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return list;
    }
}
