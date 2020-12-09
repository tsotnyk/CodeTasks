package com.j2core.sts.leetcode.com.trees.binaryTreeInorderTraversal;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> inorderTraversalOld(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(new TreeNode(node.val));
                stack.push(node.left);
            }else {
                result.add(node.val);
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list){

        if (root == null) return;

        if (root.left != null){
            inorderTraversal(root.left, list);
        }
        list.add(root.val);
        if (root.right != null){
            inorderTraversal(root.right, list);
        }
    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        List<Integer> result = inorderTraversal(root);

        Assert.assertEquals(result, new LinkedList<>(Arrays.asList(0,1,2,3,4,5,6)));
    }
}
