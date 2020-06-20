package com.j2core.sts.leetcode.com.trees.maximumLevelSumOfBinaryTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int maxLevelSum(TreeNode root) {

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int tmpLevel = 0;

        ArrayList<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()){
            int tmpSum = 0;
            tmpLevel++;
            ArrayList<TreeNode> tmpNodeList = new ArrayList<>();
            for (TreeNode node : nodeList){
                tmpSum += node.val;
                if (node.right != null){
                    tmpNodeList.add(node.right);
                }
                if (node.left != null){
                    tmpNodeList.add(node.left);
                }
            }
            if (tmpSum > maxSum){
                maxSum = tmpSum;
                maxLevel = tmpLevel;
            }
            nodeList = tmpNodeList;
        }

        return maxLevel;
    }
}
