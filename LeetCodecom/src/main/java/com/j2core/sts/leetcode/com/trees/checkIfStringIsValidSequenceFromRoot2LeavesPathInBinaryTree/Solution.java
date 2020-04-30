package com.j2core.sts.leetcode.com.trees.checkIfStringIsValidSequenceFromRoot2LeavesPathInBinaryTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isValidSequence(TreeNode root, int[] arr) {

        if (root == null) return false;

        return recursionCheck(root, 0, arr);

    }

    private boolean recursionCheck(TreeNode node, int index, int[] array){

        if (node == null) return false;
        if (node.val != array[index++]) return false;

        if (index == array.length){
            if (node.right == null && node.left == null) return true;
            return false;
        }

        if (!recursionCheck(node.left, index, array)){
            return recursionCheck(node.right, index, array);
        }

        return true;
    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);

        Assert.assertTrue(isValidSequence(root, new int[]{0,1,0,1}));
        Assert.assertFalse(isValidSequence(root, new int[]{0,0,1}));
        Assert.assertFalse(isValidSequence(root, new int[]{0,1,1}));


    }
}
