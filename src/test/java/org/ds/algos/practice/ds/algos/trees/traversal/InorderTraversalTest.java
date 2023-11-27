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

class InorderTraversalTest {

    Tree tree = new Tree();
    InorderTraversal inorderTraversal = new InorderTraversal();

    @Test
    void shouldGetCorrectInorderRecursively() {
        Tree.Node root = tree.createTree();
        ArrayList<Integer> result = new ArrayList<>();
        inorderTraversal.getInorderRecursively(root, result);
        assertThat(result, is(Arrays.asList(3, 2, 4, 1, 5)));
    }

    @Test
    void shouldGetCorrectInorderIteratively() {
        Tree.Node root = tree.createTree();
        ArrayList<Integer> result = new ArrayList<>();
        assertThat(inorderTraversal.getInorderIteratively(root), is(Arrays.asList(3, 2, 4, 1, 5)));
    }
}