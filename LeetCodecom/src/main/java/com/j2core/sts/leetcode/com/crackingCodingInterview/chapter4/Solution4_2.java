package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution4_2 {

    public TreeNode createBinaryTree(int[] array){

        if (array == null || array.length < 1) return null;
        return createBinaryTree(array, 0, array.length-1);
    }

    private TreeNode createBinaryTree(int[] array, int start, int end){

        if (start < 0 || end == array.length || start > end) return null;
        if (start == end) return new TreeNode(array[start]);

        int pivot = start + ((end-start)/2);
        TreeNode root = new TreeNode(array[pivot]);

        root.left = createBinaryTree(array, start, pivot-1);
        root.right = createBinaryTree(array, pivot+1, end);

        return root;
    }

    @Test
    public void test(){

        TreeNode result1 = createBinaryTree(null);
        TreeNode result2 = createBinaryTree(new int[]{});
        TreeNode result3 = createBinaryTree(new int[]{1});
        TreeNode result4  = createBinaryTree(new int[]{1,2});
        TreeNode result5  = createBinaryTree(new int[]{1,2,3});
        TreeNode result6 = createBinaryTree(new int[]{0,1,2,3,4,5,6,7,8,9});
        TreeNode result7 = createBinaryTree(new int[]{1,2,3,4,5,6,7,8,9});

        Assert.assertNull(result1);
        Assert.assertNull(result2);
        Assert.assertTrue(result3.left == null && result3.right == null);
        Assert.assertTrue(result4.left == null && result4.right != null);
        Assert.assertTrue(result5.left != null && result5.right != null);
        Assert.assertNotNull(result6);
        Assert.assertNotNull(result7);
    }
}
