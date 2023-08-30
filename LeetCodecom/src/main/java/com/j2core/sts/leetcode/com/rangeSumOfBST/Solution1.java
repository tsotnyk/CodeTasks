package com.j2core.sts.leetcode.com.rangeSumOfBST;

public class Solution1 {

    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) return 0;
        int sum = root.val <= high && root.val >= low ? root.val : 0;

        sum += rangeSumBST(root.left, low, high);
        sum += rangeSumBST(root.right, low, high);

        return sum;
    }
}
