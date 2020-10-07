package com.j2core.sts.leetcode.com.insertIntoBinarySearchTree;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public TreeNode insertIntoBSTOld(TreeNode root, int val) {

        TreeNode node = root;

        while (node != null){

            if (node.val > val){
                if (node.left == null){
                    node.left = new TreeNode(val);
                    break;
                }else {
                    node = node.left;
                }
            }else {
                if (node.right == null){
                    node.right = new TreeNode(val);
                    break;
                }else {
                    node = node.right;
                }
            }

        }

        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null){
            root = new TreeNode(val);
            return root;
        }

        TreeNode node = root;

        if (node.val < val){
            if (node.right == null){
                node.right = new TreeNode(val);
            }else {
                insertIntoBST(node.right, val);
            }
        }else{
            if (node.left == null){
                node.left = new TreeNode(val);
            }else {
                insertIntoBST(node.left, val);
            }
        }
        return root;
    }
}
