package org.ds.algos.practice.ds.algos.trees;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

class SymmetricTreeTest {

    @Test
    void shouldReturnFalseForNonSymmetricTree() {
        SymmetricTree symmetricTree = new SymmetricTree();
        Tree tree = new Tree();
        boolean isSymmetric = symmetricTree.isSymmetricTree(tree.createTree());
        MatcherAssert.assertThat(isSymmetric, Is.is(false));
    }
}