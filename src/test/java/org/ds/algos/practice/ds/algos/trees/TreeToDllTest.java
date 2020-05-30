package org.ds.algos.practice.ds.algos.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeToDllTest {
    
    @Test
    void shouldCorrectlyConvertTreeIntoDoublyList() {
        Tree tree = new Tree();
        TreeToDll treeToDll = new TreeToDll();
        Tree.Node node = treeToDll.convertTreeToDll(tree.createTree());
        assertEquals(3, node.data);
    }

}