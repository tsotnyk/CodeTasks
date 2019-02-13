package com.j2core.sts.leetcode.com.maximumBinaryTree;

public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }

        int index = findMax(nums, start, end);
        TreeNode root = new TreeNode(nums[index]);

        root.left = buildTree(nums, start, index - 1);
        root.right = buildTree(nums, index + 1, end);
        return root;
    }

    private int findMax(int[] nums, int start, int end) {
        int maxIndex = start;
        for(int i = start; i <= end; i++) {
            if(nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
