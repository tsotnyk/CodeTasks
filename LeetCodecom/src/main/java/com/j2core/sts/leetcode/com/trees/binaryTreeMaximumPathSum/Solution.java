package com.j2core.sts.leetcode.com.trees.binaryTreeMaximumPathSum;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        recursionCountPathSum(root);
        return maxVal;
    }

    private Integer recursionCountPathSum(TreeNode node){

        if (node == null) return null;

        int sum = node.val;
        Integer left = recursionCountPathSum(node.left);
        Integer right = recursionCountPathSum(node.right);

        if (left != null && right != null){
            sum = Math.max(sum, node.val+left);
            sum = Math.max(sum, node.val+right);
            maxVal = Math.max(maxVal, node.val+left+right);
        }else if (left != null){
            sum = Math.max(sum, sum+left);
        }else if (right != null){
            sum = Math.max(sum, sum+right);
        }

        maxVal = Math.max(maxVal, sum);

        return sum;
    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Assert.assertEquals(maxPathSum(root), 6);

        TreeNode root1 = new TreeNode(-10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        Assert.assertEquals(maxPathSum(root1), 42);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(11);
        root2.left.left.left = new TreeNode(7);
        root2.left.left.right = new TreeNode(2);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(1);

        Assert.assertEquals(maxPathSum(root2), 48);
    }

}
