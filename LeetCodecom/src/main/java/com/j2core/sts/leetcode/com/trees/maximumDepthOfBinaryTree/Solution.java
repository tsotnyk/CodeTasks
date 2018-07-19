package com.j2core.sts.leetcode.com.trees.maximumDepthOfBinaryTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        List<List<TreeNode>> resultList = new LinkedList<>();

        List<TreeNode> tmpTree = new LinkedList<>();
        tmpTree.add(root);

        while (!tmpTree.isEmpty()){

            resultList.add(tmpTree);
            List<TreeNode> tmpResult = new LinkedList<>();

            for (TreeNode node : tmpTree){

                if (node.left != null) tmpResult.add(node.left);
                if (node.right != null) tmpResult.add(node.right);

            }

            tmpTree = tmpResult;

        }

        return resultList.size();
    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = maxDepth(root);

        Assert.assertEquals(3, result);

    }

}
