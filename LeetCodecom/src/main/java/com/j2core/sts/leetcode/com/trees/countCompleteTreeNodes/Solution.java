package com.j2core.sts.leetcode.com.trees.countCompleteTreeNodes;

import com.j2core.sts.leetcode.com.trees.TreeNode;

public class Solution {

    public int countNodes(TreeNode root) {

        if (root == null) return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;

    }
}
