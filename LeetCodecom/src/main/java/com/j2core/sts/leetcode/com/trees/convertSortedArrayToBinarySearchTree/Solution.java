package com.j2core.sts.leetcode.com.trees.convertSortedArrayToBinarySearchTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null) return null;
        if (nums.length < 1) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);

        return createBST(nums, 0, nums.length-1);

    }

    public TreeNode createBST(int[] nums, int indexStart, int indexEnd){

        if (indexStart > indexEnd) return null;
        int delta = (indexEnd-indexStart)/2;
        if ((indexEnd-indexStart)%2 != 0) delta++;

        TreeNode root = new TreeNode(nums[indexStart+delta]);
        root.left = createBST(nums, indexStart, indexStart+delta-1);
        root.right = createBST(nums, indexStart+delta+1, indexEnd);

        return root;
    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-3);
        root.left.left = new TreeNode(-10);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(5);

        TreeNode node = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});



        Assert.assertEquals(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}), root);
    }
}
