package org.ds.algos.practice.ds.algos.trees;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfTreeIsBalancedTest {

    @Test
    void shouldReturnTrueForBalancedTree() {
        Tree tree = new Tree();
        CheckIfTreeIsBalanced obj = new CheckIfTreeIsBalanced();
        boolean result = obj.heightBalancedBinaryTree(tree.createBST());
        MatcherAssert.assertThat(result, Is.is(true));
    }

}