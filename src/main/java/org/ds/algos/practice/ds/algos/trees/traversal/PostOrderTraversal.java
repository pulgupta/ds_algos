package org.ds.algos.practice.ds.algos.trees.traversal;

import org.ds.algos.practice.ds.algos.trees.Tree;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public void getPostorderRecursively(Tree.Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        getPostorderRecursively(root.left, list);
        getPostorderRecursively(root.right, list);
        list.add(root.data);
    }

    /* 		1
     *	   / \
     *    2   5
     *   / \
     *  3   4
     */
    public List<Integer> getPostorderIteratively(Tree.Node node) {
        List<Integer> list = new ArrayList();
        Stack<StackData> stack = new Stack<>();
        if (node == null) {
            return list;
        }
        stack.push(new StackData(node, false));
        while (!stack.isEmpty()) {
            StackData current = stack.pop();
            if(current.visited) {
                list.add(current.node.data);
            } else {
                stack.push(new StackData(current.node, true));
                if (current.node.right != null) {
                    stack.push(new StackData(current.node.right, false));
                }
                if (current.node.left != null) {
                    stack.push(new StackData(current.node.left, false));
                }
            }
        }
        return list;
    }

    class StackData {
        public Tree.Node node;
        public Boolean visited;

        public StackData(Tree.Node node, Boolean visited) {
            this.node = node;
            this.visited = visited;
        }
    }
}
