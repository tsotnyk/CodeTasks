package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter4;

public class Solution4 {

    boolean isBalancedTree(TreeNode node){

        return depth(node) != Integer.MIN_VALUE;
    }

    int depth(TreeNode node){

        if (node == null) return -1;

        int right = depth(node.right);
        if (right == Integer.MIN_VALUE) return right;

        int left = depth(node.left);
        if (left == Integer.MIN_VALUE) return left;

        if (Math.abs(right-left) > 1) return Integer.MIN_VALUE;

        return Math.max(right, left) + 1;
    }
}
