package org.ds.algos.practice.ds.algos.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The idea is to traverse the tree using level order traversal and put
 * in a map the node encountered and the parent of it
 * Once we find the node whose path we need to calculate we can
 * get the data from the map to find the path of the node
 */
public class FindPathIterative {

    public Stack<Tree.Node> hasPathIterative(Tree.Node root, int element) {

        Stack<Tree.Node> path = new Stack<>();
        Queue<Tree.Node> levelOderTraversal = new LinkedList<>();

        // Go to each node and put that node in the stack
        // Next search for all the children of that node and if we find a match we have a path

        if(root == null)
            return null;

        levelOderTraversal.add(root);

        while (levelOderTraversal!=null) {

        }

        return null;
    }

    public static void main(String[] args) {
        FindPathIterative fp = new FindPathIterative();
        Tree tree = new Tree();
        Tree.Node rootNode = tree.createTree();
        Stack<Tree.Node> stack = fp.hasPathIterative(rootNode, 4);
        for (Tree.Node node : stack) {
            System.out.println(node.data);

        }
    }
}
