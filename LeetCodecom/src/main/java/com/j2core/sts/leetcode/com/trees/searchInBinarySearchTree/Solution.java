package com.j2core.sts.leetcode.com.trees.searchInBinarySearchTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;

public class Solution {

    public TreeNode searchBSTOld(TreeNode root, int val) {
        if (root == null){
            return null;
        }

        TreeNode result = root;
        if (root.val != val){

            if (root.val > val){
                result = searchBST(root.left, val);
            }else {
                result = searchBST(root.right, val);
            }
        }

        return result;
    }

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return null;
        if (root.val == val) return root;

        if (root.val < val){
            return searchBST(root.right, val);
        }else {
            return searchBST(root.left, val);
        }

    }
}
