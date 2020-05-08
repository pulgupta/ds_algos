package org.ds.algos.practice.ds.algos.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorImageOfTree {

    public static Tree.Node getMirrorImageOfATree(Tree.Node root) {
        Queue<Tree.Node> queue = new LinkedList<Tree.Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree.Node current = queue.poll();
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
            Tree.Node temp = current.left;
            current.left = current.right;
            current.right = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Tree.Node root = tree.createTree();
        tree.printInorder(root);
        System.out.println("\n\n**After creating a mirror image**");
        tree.printInorder(getMirrorImageOfATree(root));
    }
}
