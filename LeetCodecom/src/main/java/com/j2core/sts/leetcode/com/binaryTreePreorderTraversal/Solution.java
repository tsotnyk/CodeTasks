package com.j2core.sts.leetcode.com.binaryTreePreorderTraversal;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        if (root != null){
            traversal(root, list);
        }

        return list;
    }

    private void traversal(TreeNode root, List<Integer> list){

        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }

        if (root.left != null){
            traversal(root.left, list);
        }
        if (root.right != null){
            traversal(root.right, list);
        }
        list.add(root.val);
    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = new LinkedList<>(Arrays.asList(4,5,2,6,7,3,1));

        Assert.assertEquals(result, preorderTraversal(root));
    }

}
