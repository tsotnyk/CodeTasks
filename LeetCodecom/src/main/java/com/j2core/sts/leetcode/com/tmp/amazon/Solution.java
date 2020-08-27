package com.j2core.sts.leetcode.com.tmp.amazon;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.annotations.Test;

import java.util.PriorityQueue;
import java.util.Stack;


public class Solution {

    public void inOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode current = root;

        while (!nodes.isEmpty() || current != null) {

            if (current != null) {
                nodes.push(current);
                current = current.left;
            } else {
                TreeNode node = nodes.pop();
                System.out.printf("%s ", node.val);
                current = node.right;
            }

        }
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    @Test
    public void test(){

TreeNode root = new TreeNode(4);
root.left = new TreeNode(2);
root.left.left = new TreeNode(1);
root.left.right = new TreeNode(3);
root.right = new TreeNode(5);
root.right.right = new TreeNode(6);

inOrderWithoutRecursion(root);
    }
    
}
