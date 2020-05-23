package com.j2core.sts.leetcode.com;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTmp {



    @Test
    public void test(){

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(0);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(5);
        root.right.right = new TreeNode(8);

    }

    public class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
