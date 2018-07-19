package com.j2core.sts.leetcode.com.trees.averageOfLevelsInBinaryTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Double> averageOfLevels(TreeNode root) {

        List<List<TreeNode>> treeList = new LinkedList<>();

        List<TreeNode> tmpResult = new LinkedList<>();
        tmpResult.add(root);
        do {

            treeList.add(tmpResult);
            List<TreeNode> tmpList = tmpResult;
            tmpResult = new LinkedList<>();

            for (TreeNode node : tmpList){

                if (node.left != null) tmpResult.add(node.left);

                if (node.right != null) tmpResult.add(node.right);
            }

        }while (!tmpResult.isEmpty());

        List<Double> result = new LinkedList<>();

        for (List<TreeNode> nodesList : treeList){

            double sum = 0;

            for (TreeNode node : nodesList){

                sum = sum + node.val;
            }
            result.add(sum/nodesList.size());
        }

        return result;
    }


    @Test
    public void test(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> result = averageOfLevels(root);

        Assert.assertEquals(3, result.size());

    }
}
