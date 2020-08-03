package org.ds.algos.practice.ds.algos.trees;

import java.util.ArrayList;
import java.util.List;

public class ZigZagLevelOrderTraversal {

    List<TreeNode> stack1 = new ArrayList<>();
    List<TreeNode> stack2 = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        List<List<Integer>> result = new ArrayList<>();
        int lvlCount = 0;
        if(root == null)
            return result;

        stack1.add(root);

        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            lvlCount++;
            List<Integer> level = new ArrayList<>();
            int itr = Math.max(stack1.size(), stack2.size());

            for(int i=0; i<itr; i++) {
                TreeNode processed;

                if(lvlCount%2!=0)
                    processed = stack1.remove(stack1.size()-1);
                else
                    processed = stack2.remove(stack2.size()-1);

                level.add(processed.val);
                if(lvlCount%2!=0) {
                    addElement(lvlCount, processed.left);
                    addElement(lvlCount, processed.right);
                } else {
                    addElement(lvlCount, processed.right);
                    addElement(lvlCount, processed.left);
                }


            }
            result.add(level);
        }
        return result;

    }

    void addElement(int lvlCount, TreeNode node) {
        if(node!=null) {
            if(lvlCount%2!=0)
                stack2.add(node);
            else
                stack1.add(node);
        }
    }
}
