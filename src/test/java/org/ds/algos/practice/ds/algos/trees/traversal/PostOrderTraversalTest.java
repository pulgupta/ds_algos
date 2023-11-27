package org.ds.algos.practice.ds.algos.trees.traversal;

import org.ds.algos.practice.ds.algos.trees.Tree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PostOrderTraversalTest {
    Tree tree = new Tree();
    PostOrderTraversal postOrderTraversal = new PostOrderTraversal();

    @Test
    void shouldGetCorrectPostorderRecursively() {
        Tree.Node root = tree.createTree();
        ArrayList<Integer> result = new ArrayList<>();
        postOrderTraversal.getPostorderRecursively(root, result);
        assertThat(result, is(Arrays.asList(3, 4, 2, 5, 1)));
    }

    @Test
    void shouldGetCorrectPostorderIteratively() {
        Tree.Node root = tree.createTree();
        assertThat(postOrderTraversal.getPostorderIteratively(root), is(Arrays.asList(3, 4, 2, 5, 1)));
    }

}