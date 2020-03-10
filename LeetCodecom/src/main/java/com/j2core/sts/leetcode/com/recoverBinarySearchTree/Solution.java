package com.j2core.sts.leetcode.com.recoverBinarySearchTree;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public void recoverTree(TreeNode root) {

        if (root != null){

            while (!isBSTRight(root, root.val) || !isBSTLeft(root, root.val)){
                recoverTree(root);
            }
        }
    }

    private boolean isBSTLeft(TreeNode node, int rootVal){

        if (node.left != null){

            List<TreeNode> nodeList = new LinkedList<>();
            nodeList.add(node.left);
            int maxValue = rootVal;
            TreeNode tmpNode;

            while (!nodeList.isEmpty()){
                tmpNode = nodeList.remove(0);
                if (tmpNode.val > maxValue){
                    maxValue = tmpNode.val;
                }
                if (tmpNode.left != null){
                    nodeList.add(tmpNode.left);
                }
                if (tmpNode.right != null){
                    nodeList.add(tmpNode.right);
                }
            }

            if (node.val != maxValue) {
                node.val = maxValue;

                nodeList.add(node.left);

                while (!nodeList.isEmpty()) {
                    tmpNode = nodeList.remove(0);
                    if (tmpNode.val == node.val) {
                        tmpNode.val = rootVal;
                        return false;
                    }
                    if (tmpNode.left != null) {
                        nodeList.add(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        nodeList.add(tmpNode.right);
                    }
                }
            }else {recoverTree(node.left);}
        }

        return true;
    }

    private boolean isBSTRight(TreeNode node, int rootVal){

        if (node.right != null){

            List<TreeNode> nodeList = new LinkedList<>();
            nodeList.add(node.right);
            int minVal = rootVal;
            TreeNode tmpNode;

            while (!nodeList.isEmpty()){
                tmpNode = nodeList.remove(0);
                if (tmpNode.val < minVal){
                    minVal = tmpNode.val;
                }
                if (tmpNode.left != null){
                    nodeList.add(tmpNode.left);
                }
                if (tmpNode.right != null){
                    nodeList.add(tmpNode.right);
                }
            }

            if (node.val != minVal) {
                node.val = minVal;

                nodeList.add(node.right);

                while (!nodeList.isEmpty()){
                    tmpNode = nodeList.remove(0);
                    if (tmpNode.val == node.val){
                        tmpNode.val = rootVal;
                        return false;
                    }
                    if (tmpNode.left != null) {
                        nodeList.add(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        nodeList.add(tmpNode.right);
                    }
                }
            }else recoverTree(node.right);
        }

        return true;
    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        recoverTree(root);

        Assert.assertEquals(root.val, 3);

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(2);
        recoverTree(root1);

        Assert.assertEquals(root1.val, 2);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(1);
        recoverTree(root2);

        Assert.assertEquals(root2.left.val, 1);
        Assert.assertEquals(root2.right.val, 3);
        Assert.assertEquals(root2.val, 2);

        TreeNode root4 = new TreeNode(3);
        root4.right = new TreeNode(2);
        root4.right.right = new TreeNode(1);
        recoverTree(root4);

        Assert.assertEquals(root4.val, 1);
        Assert.assertEquals(root4.right.val, 2);
    }
}
