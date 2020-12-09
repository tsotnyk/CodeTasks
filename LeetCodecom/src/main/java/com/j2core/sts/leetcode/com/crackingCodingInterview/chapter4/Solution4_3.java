package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution4_3 {

    public List<List<Integer>> createAllTreePath(TreeNode root){

        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        List<Integer> path = new LinkedList<>();

        recursionReadPath(root, path, result);

        return result;
    }

    private void recursionReadPath(TreeNode root, List<Integer> path, List<List<Integer>> result) {

        path.add(root.val);
        if (root.left == null && root.right == null){
            result.add(path);
        }else if (root.left != null && root.right != null){
            recursionReadPath(root.left, new LinkedList<>(path), result);
            recursionReadPath(root.right, path, result);
        }else {

            TreeNode node = root.left != null ? root.left : root.right;
            recursionReadPath(node, path, result);
        }

    }

    @Test
    public void test(){

        Assert.assertEquals(createAllTreePath(null).size(), 0);
        Assert.assertEquals(createAllTreePath(new TreeNode(1)).size(), 1);
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        Assert.assertEquals(createAllTreePath(root1).size(), 1);
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(3);
        Assert.assertEquals(createAllTreePath(root2).size(), 1);
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(0);
        root3.right = new TreeNode(2);
        root3.right.left = new TreeNode(3);
        root3.right.right = new TreeNode(5);
        Assert.assertEquals(createAllTreePath(root3).size(), 3);
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(0);
         root4.left.left = new TreeNode(5);
         root4.left.right = new TreeNode(6);
        root4.right = new TreeNode(2);
        root4.right.left = new TreeNode(3);
        root4.right.right = new TreeNode(5);
        Assert.assertEquals(createAllTreePath(root4).size(), 4);
    }
}
