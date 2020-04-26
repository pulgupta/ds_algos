package org.ds.algos.practice.ds.algos.trees;

public class CheckTreeBalanceApproach2 {

    boolean isBalanced(Tree.Node node)
    {
        int lh; /* for height of left subtree */
        int rh; /* for height of right subtree */

        if (node == null)
            return true;

        /* Get the height of left and right sub trees */
        lh = height(node.left);
        rh = height(node.right);

        // Left height and right height difference should not be more than 1 and
        // then recursively check for the left and right sub trees.
        if (Math.abs(lh - rh) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right))
            return true;

        /* If we reach here then tree is not height-balanced */
        return false;
    }

    int height(Tree.Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
