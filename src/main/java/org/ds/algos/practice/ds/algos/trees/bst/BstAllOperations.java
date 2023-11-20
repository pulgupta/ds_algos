package org.ds.algos.practice.ds.algos.trees.bst;

public class BstAllOperations {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            insert (this, value);
            return this;
        }

        BST insert(BST node, int value) {
            if(node == null) {
                return new BST(value);
            }
            if(value < node.value) {
                node.left = insert(node.left, value);
            } else {
                node.right = insert(node.right, value);
            }
            return node;
        }

        public boolean contains(int value) {
            BST node = this;
            while (node != null) {
                if(node.value == value) return true;
                if(value < node.value) node = node.left;
                else node = node.right;
            }
            return false;
        }

        public BST remove(int value) {
            if(this.left != null || this.right != null) {
                BST result = remove(this, value);
                this.value = result.value;
                this.right = result.right;
                this.left = result.left;
            }
            return this;
        }

        private BST remove(BST node, int value) {
            System.out.println("node " + node.value);
            if(node.value == value) {
                if(node.left == null && node.right == null) {
                    return null;
                }
                if(node.left == null) {
                    return node.right;
                }
                if(node.right == null) {
                    return node.left;
                }
                BST max = findMinOnRight(node.right);
                System.out.println("removing min on right with value " + max.value);
                node.value = max.value;
                node.right = remove(node.right, max.value);
                return node;
            }
            if(value < node.value) {
                node.left = remove(node.left, value);
            } else {
                node.right = remove(node.right, value);
            }
            return node;
        }

        BST findMinOnRight(BST node) {
            BST temp = node;
            while(temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
    }
}
