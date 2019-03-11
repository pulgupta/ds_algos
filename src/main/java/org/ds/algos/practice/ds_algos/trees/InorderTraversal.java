package org.ds.algos.practice.ds_algos.trees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
	
	class Node {
		int data;
		Node left;
		Node right;
	}
	
	boolean checkBST(Node root) {
		List<Integer> order = new ArrayList<>();
		getInorder(root, order);
		boolean isSorted = true;
		for (int i = 0; i < order.size()-1; i++) {
			if(order.get(i)>order.get(i+1)){
				isSorted=false;
				break;
			}
		}
		return isSorted;
	}
	void getInorder(Node root, List<Integer> list) {
		if(root==null)
			return;
		getInorder(root.left, list);
		list.add(root.data);
		getInorder(root.right, list);
	}
	
}
