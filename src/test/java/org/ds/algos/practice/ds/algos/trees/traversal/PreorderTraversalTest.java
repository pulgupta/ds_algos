package org.ds.algos.practice.ds.algos.trees.traversal;

import org.ds.algos.practice.ds.algos.trees.Tree;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;
import static org.junit.jupiter.api.Assertions.*;

class PreorderTraversalTest {

    Tree tree = new Tree();
    PreorderTraversal preorderTraversal = new PreorderTraversal();

    @Test
    void shouldGetCorrectInorderRecursively() {
        Tree.Node root = tree.createTree();
        ArrayList<Integer> result = new ArrayList<>();
        preorderTraversal.getPreorderRecursively(root, result);
        assertThat(result, is(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    void shouldGetCorrectInorderIteratively() {
        Tree.Node root = tree.createTree();
        assertThat(preorderTraversal.getPreorderIteratively(root), is(Arrays.asList(1, 2, 3, 4, 5)));
    }
}