package org.ds.algos.practice.ds_algos.tries;

/**
 * Trie data structure facilitates quick string searching.
 * The same search with binary tree would cost M*log(N) where M is the length of the key to
 * be searched and N is the number of entries in the tree
 * If we are using trie we can reduce it to log(M)
 * @author pulgupta
 *
 */
public class Trie {
	
	Node root;
	
	class Node {
		Node[] children;
		boolean isEndOfWord;
		
		public Node() {
			children = new Node[26];
			isEndOfWord = false;
		}
	}
	
	public Trie() {
		root = new Node();
	}
	
	public void insert(String key) {
		char[] keyArr = key.toCharArray();
		Node current = root;
		for(int i=0; i<keyArr.length; i++) {
			
			if(current.children[keyArr[i]-'a'] == null) {
				System.out.println("No node for " + keyArr[i] + ", creating new");
				current.children[keyArr[i]-'a'] = new Node();
			}
			current = current.children[keyArr[i]-'a'];
		}
		current.isEndOfWord = true;
	}
	
	public boolean search(String key) {
		char[] keyArr = key.toCharArray();
		Node current = root;
		for(int i=0; i<keyArr.length; i++) {
			
			if(current.children[keyArr[i]-'a'] == null) {
				System.out.println("No node for " + keyArr[i]);
				return false;
			}
			current = current.children[keyArr[i]-'a'];
		}
		return current!=null && current.isEndOfWord;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("cap");
		System.out.println("Search result " + trie.search("cap"));
		System.out.println("Search result " + trie.search("ca"));
	}

}
