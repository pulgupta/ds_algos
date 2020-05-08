package org.ds.algos.practice.ds.algos.trees;

import org.ds.algos.practice.ds.algos.trees.Tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Will store the left most and the right most nodes at a level
class Tracker {
    Node left;
    Node right;

    public Tracker() {
    }

    ;

    public Tracker(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}

// Do a level order traversal and store the leftmost and the right most element at each level
// For the bottom view we can just store the leaf nodes marked as left nodes of tracker.
public class TreeParameter {

    Tree tree = new Tree();
    Node root = tree.createTree();
    int temp, count = 1;
    List<Tracker> solution = new ArrayList<Tracker>();
    Queue<Node> inorderQueue = new LinkedList<Node>();


    // Calculating the right and left parameter
    public void leftAndRightParameter(Node root) {
        inorderQueue.add(root);
        int height = 0;
        solution.add(new Tracker(root, null));
        int treeHeight = tree.getTreeHeight(root);
        System.out.println("Three height is " + treeHeight);
        while (!inorderQueue.isEmpty()) {
            height++;
            if (height != treeHeight - 1)
                solution.add(new Tracker());
            temp = 0;
            for (int i = 0; i < count; i++) {
                Node itr = inorderQueue.poll();
                if (height == treeHeight - 1) {
                    // As this is the last node it will be a leaf and it will have no child
                    // We can directly add them as left nodes as for left node we can travel
                    // Starting from the root node to the right most leaf node
                    solution.add(new Tracker(itr.left, null));
                    solution.add(new Tracker(itr.right, null));
                }
                // get the left most node at a level below
                else {
                    if (itr.left != null) {
                        inorderQueue.add(itr.left);
                        // When once the left most node is set do not overwrite it
                        if (solution.get(height).left == null)
                            solution.get(height).left = itr.left;
                        temp++;
                    }
                    // get the right most node at a level below
                    if (itr.right != null) {
                        inorderQueue.add(itr.right);
                        // Keep on overwriting the right node till we reach the right most node
                        solution.get(height).right = itr.right;
                        temp++;
                    }
                }
            }
            count = temp;
        }
    }

    public void printParameter() {

        for (Tracker t : solution)
            if (t.left != null)
                System.out.print(t.left.data + " ");
        for (int i = solution.size() - 1; i >= 0; i--) {
            if (solution.get(i).right != null)
                System.out.println(solution.get(i).right.data + " ");
        }
    }

    public static void main(String args[]) {
        TreeParameter treeParameter = new TreeParameter();
        treeParameter.leftAndRightParameter(treeParameter.root);
        treeParameter.printParameter();
        System.out.println("Execution Completed");
    }
}