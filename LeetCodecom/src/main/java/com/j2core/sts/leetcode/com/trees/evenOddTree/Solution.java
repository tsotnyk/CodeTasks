package com.j2core.sts.leetcode.com.trees.evenOddTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;

public class Solution {

    public boolean isEvenOddTree(TreeNode root) {

        return isCorrectTree(root, 1);
    }

    private boolean isCorrectTree(TreeNode root, int level){

        if (root == null) return true;

        if(root.val%2 != level%2){
            return false;
        }else {
            if (!isCorrectTree(root.left, level+1)){
                return false;
            }
            return isCorrectTree(root.right, level+1);
        }
    }
}
