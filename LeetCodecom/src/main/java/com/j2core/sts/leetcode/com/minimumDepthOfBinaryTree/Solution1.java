package com.j2core.sts.leetcode.com.minimumDepthOfBinaryTree;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        int minDepth = 1;

        List<TreeNode> level = new LinkedList<>(Collections.singletonList(root));

        while (true){
            List<TreeNode> nextLevel = new LinkedList<>();
            while (!level.isEmpty()){
                TreeNode curNode = level.remove(0);
                if (curNode.left == null && curNode.right == null) return minDepth;
                if (curNode.left != null) nextLevel.add(curNode.left);
                if (curNode.right != null) nextLevel.add(curNode.right);
            }
            level = nextLevel;
            minDepth++;
        }
    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(minDepth(root), 2);
    }
}
