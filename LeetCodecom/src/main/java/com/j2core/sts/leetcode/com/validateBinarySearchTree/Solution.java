package com.j2core.sts.leetcode.com.validateBinarySearchTree;

public class Solution {

    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return helper(root);
    }

    private boolean helper(TreeNode root) {

        if(root.left != null) {
            boolean leftValid = helper(root.left);
            if(!leftValid) return false;
        }
        if(prev != null && prev.val >= root.val) return false;
        prev = root;
        if(root.right != null) {
            boolean rightValid = helper(root.right);
            if(!rightValid) return false;
        }
        return true;
    }
}
