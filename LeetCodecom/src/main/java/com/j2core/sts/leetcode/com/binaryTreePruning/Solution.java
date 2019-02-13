package com.j2core.sts.leetcode.com.binaryTreePruning;

import org.testng.annotations.Test;

public class Solution {

    public TreeNode pruneTree(TreeNode root) {

        if (root == null){
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0){
            return null;
        }

        return root;

    }


    @Test
    public void test(){

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(0);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(0);
        node.right = new TreeNode(1);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(1);

        TreeNode result = pruneTree(node);

        System.out.print("  ***");


    }

}
