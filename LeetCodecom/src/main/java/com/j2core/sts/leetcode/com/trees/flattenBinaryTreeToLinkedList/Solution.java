package com.j2core.sts.leetcode.com.trees.flattenBinaryTreeToLinkedList;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.annotations.Test;

public class Solution {

    public void flatten(TreeNode root) {

        if (root!= null) {
            TreeNode right = root.right;
            TreeNode left = root.left;
            root.right = null;
            root.left = null;
            newRoot = root;

            addNode(left);
            addNode(right);
        }
    }

    TreeNode newNode = null;
    TreeNode newRoot;

    private void addNode(TreeNode node){

        if (node != null) {
            if (newNode == null) {
                newRoot.right = new TreeNode(node.val);
                newNode = newRoot.right;
            } else {
                newNode.right = new TreeNode(node.val);
                newNode = newNode.right;
            }

            if (node.left != null){
                addNode(node.left);
            }
            if (node.right != null){
                addNode(node.right);
            }
        }
    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        flatten(root);

        System.out.println(root.val);
    }
}
