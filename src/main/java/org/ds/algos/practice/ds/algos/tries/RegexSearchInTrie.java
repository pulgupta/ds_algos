package org.ds.algos.practice.ds.algos.tries;

public class RegexSearchInTrie {
    Node root;

    static class Node {
        Node[] children;
        boolean isEndOfWord;

        public Node() {
            children = new Node[26];
            isEndOfWord = false;
        }
    }

    public RegexSearchInTrie() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] wordArr = word.toCharArray();
        Node current = root;
        for (int i = 0; i < wordArr.length; i++) {
            if (current.children[wordArr[i] - 'a'] == null) {
                System.out.println("created a node for " + wordArr[i]);
                current.children[wordArr[i] - 'a'] = new Node();
            }
            current = current.children[wordArr[i] - 'a'];
        }
        current.isEndOfWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(root, word);
    }

    private boolean searchHelper(Node current, String word) {
        char[] keyArr = word.toCharArray();
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i] == '.') {
                for (int j=0;j<26;j++) {
                    if(current.children[j] != null) {
                        if(searchHelper(current.children[j], word.substring(i+1)))
                            return true;
                    }
                }
                return false;
            } else {
                if (current.children[keyArr[i] - 'a'] == null) {
                    return false;
                }
                current = current.children[keyArr[i] - 'a'];
            }
        }
        return current != null && current.isEndOfWord;
    }
}
