package org.ds.algos.practice.ds.algos.trees;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ValidateIfBstTest {

    @Test
    void shouldReturnTrueForValidBst() {
        ValidateIfBst obj = new ValidateIfBst();
        Tree tree = new Tree();
        // Should return true as this in indeed a BST
        // The initial values are null and not Integer's max and min values as the tree can itself
        // have Integer's min and max value as node's data.
        assertThat(obj.checkBst(tree.createBST(), null, null), is(true));
    }

    @Test
    void shouldReturnFalseForInvalidBst() {
        /**
         *          10
         *         /  \
         *        5   15
         *       /
         *      3
         *     /
         *    8
         */
        ValidateIfBst obj = new ValidateIfBst();
        Tree.Node node5 = new Tree.Node(8, null, null);
        Tree.Node node4 = new Tree.Node(3, node5, null);
        Tree.Node node3 = new Tree.Node(5, node4, null);
        Tree.Node node2 = new Tree.Node(15, null, null);
        Tree.Node node1 = new Tree.Node(10, node3, node2);
        assertThat(obj.checkBst(node1, null, null), is(false));
    }
}