package org.ds.algos.practice.ds.algos.trees;

import static org.ds.algos.practice.ds.algos.trees.Tree.Node;

public class CheckBalancedApp2 {

    /**
     * The basic idea here is that when we calculate the height we get the left height and
     * the right height. Then we find the max and add 1. At this same point if we check that the
     * left and right heinght should not differ by more than 1 we can check if the tree is height balanced or not.
     * @param root
     * @return
     */
    public static int checkBalanced(Node root) {
        if(root == null)
            return 0;

        int heightleft = checkBalanced(root.left);
        if(heightleft == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int heightRight = checkBalanced(root.right);
        if(heightRight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if(Math.abs(heightleft - heightRight) > 1)
            return Integer.MIN_VALUE;

        int height = Math.max(heightleft, heightRight) + 1;
        return height;
    }
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.createBST();
        if(checkBalanced(root) == Integer.MIN_VALUE)
            System.out.println(false);
        else
            System.out.println(true);
    }
}
