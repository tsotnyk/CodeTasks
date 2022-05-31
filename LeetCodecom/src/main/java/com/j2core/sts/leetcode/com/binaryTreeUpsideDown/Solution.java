package com.j2core.sts.leetcode.com.binaryTreeUpsideDown;

import com.j2core.sts.leetcode.com.trees.TreeNode;

public class Solution {

    public TreeNode upsideDownBinaryTree(TreeNode root) {

        if (root == null || root.left == null) return root;

        return dfs(root);
    }

    private TreeNode dfs(TreeNode current) {
        if (current.left == null) {
            return current;
        }
        TreeNode newNode = dfs(current.left);
        current.left.left = current.right;
        current.left.right = current;
        current.left = null;
        current.right = null;
        return newNode;
    }
}
