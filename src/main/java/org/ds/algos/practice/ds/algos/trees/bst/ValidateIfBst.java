package org.ds.algos.practice.ds.algos.trees.bst;

import org.ds.algos.practice.ds.algos.trees.Tree;

public class ValidateIfBst {
    public boolean checkBst(Tree.Node root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.data < min) || (max != null && root.data > max)) {
            return false;
        }
        return checkBst(root.left, min, root.data) && checkBst(root.right, root.data, max);
    }
}
