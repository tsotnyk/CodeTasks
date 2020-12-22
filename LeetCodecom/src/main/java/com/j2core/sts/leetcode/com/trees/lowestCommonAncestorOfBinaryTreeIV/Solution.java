package com.j2core.sts.leetcode.com.trees.lowestCommonAncestorOfBinaryTreeIV;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {

        TreeNode curRoot = root;
        HashSet<Integer> nodesSet = new HashSet<>();
        for (TreeNode node : nodes){
            nodesSet.add(node.val);
        }

        boolean rightContainAllNodes = true;

        while (rightContainAllNodes){
            if (childOfRootContainAllNodes(curRoot.left, nodesSet)){
                curRoot = curRoot.left;
            }else {
                rightContainAllNodes = childOfRootContainAllNodes(curRoot.right, nodesSet);
                if (rightContainAllNodes){
                    curRoot = curRoot.right;
                }
            }
        }

        return curRoot;
    }

    private boolean childOfRootContainAllNodes(TreeNode root, HashSet<Integer> nodes) {

        int counter = 0;

        List<TreeNode> treeNodeList = new LinkedList<>();
        if (root != null) {
            treeNodeList.add(root);
        }
        while (!treeNodeList.isEmpty()){
            TreeNode node = treeNodeList.remove(0);
            if (nodes.contains(node.val)){
                counter++;
            }
            if (node.left != null) treeNodeList.add(node.left);
            if (node.right != null) treeNodeList.add(node.right);
        }
        return counter == nodes.size();
    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode[] array = new TreeNode[]{new TreeNode(4), new TreeNode(7)};

        Assert.assertEquals(lowestCommonAncestor(root, array).val, 2);
    }

}
