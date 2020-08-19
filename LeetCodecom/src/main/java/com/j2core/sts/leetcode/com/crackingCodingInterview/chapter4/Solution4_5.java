package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution4_5 {

    public boolean isBST(TreeNode root){

        if (root == null) return true;

        ArrayList<Integer> list = new ArrayList<>();
        travers(root, list);

        int num = list.remove(0);
        for (int next : list){
            if (next < num) return false;
            num = next;
        }

        return true;
    }

    private void travers(TreeNode node, List<Integer> list){

        if (node == null) return;

        travers(node.left, list);
        list.add(node.val);
        travers(node.right, list);

    }

    @Test
    public void test(){

        TreeNode root = null;
        Assert.assertTrue(isBST(root));

        TreeNode root1 = new TreeNode(2);
        Assert.assertTrue(isBST(root1));

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        Assert.assertTrue(isBST(root2));

        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(3);
        Assert.assertFalse(isBST(root3));

        TreeNode root4 = new TreeNode(2);
        root4.right = new TreeNode(3);
        Assert.assertTrue(isBST(root4));

        TreeNode root5 = new TreeNode(2);
        root5.right = new TreeNode(0);
        Assert.assertFalse(isBST(root5));

        TreeNode root6 = new TreeNode(2);
        root6.right = new TreeNode(3);
        root6.left = new TreeNode(1);
        Assert.assertTrue(isBST(root6));

        TreeNode root7 = new TreeNode(2);
        root7.right = new TreeNode(1);
        root7.left = new TreeNode(3);
        Assert.assertFalse(isBST(root7));

        TreeNode root8 = new TreeNode(3);
        root8.left = new TreeNode(1);
        root8.left.left = new TreeNode(0);
        root8.left.right = new TreeNode(2);
        root8.right = new TreeNode(5);
        root8.right.left = new TreeNode(4);
        root8.right.right = new TreeNode(6);
        Assert.assertTrue(isBST(root8));

        TreeNode root9 = new TreeNode(15);
        root9.left = new TreeNode(1);
        root9.left.left = new TreeNode(0);
        root9.left.right = new TreeNode(2);
        root9.right = new TreeNode(5);
        root9.right.left = new TreeNode(4);
        root9.right.right = new TreeNode(6);
        Assert.assertFalse(isBST(root9));

    }
}
