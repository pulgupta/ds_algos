package org.ds.algos.practice.ds.algos.trees.bst;

import static org.ds.algos.practice.ds.algos.trees.Tree.*;

public class SortedArrayToBst {
    public static void main(String[] args) {

        int[] array = {1, 2, 3};
        SortedArrayToBst satb = new SortedArrayToBst();
        Node root = satb.convert(array, 0, array.length - 1);
        satb.inorderTraversal(root);
    }

    // Follow the binary approach to divide the array into sub array
    // The middle element will become the root and the two sub arrays
    // will form the left sub tree and right sub tree
    public Node convert(int[] array, int low, int high) {
        if (low <= high) {
            int middle = (low + high) / 2;
            Node node = new Node();
            node.data = array[middle];
            node.left = convert(array, low, middle - 1);
            node.right = convert(array, middle + 1, high);
            return node;
        } else
            return null;
    }

    // Simple in order tree traversal to give us back the sorted array
    public void inorderTraversal(Node root) {
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        System.out.println(root.data);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
    }
}
