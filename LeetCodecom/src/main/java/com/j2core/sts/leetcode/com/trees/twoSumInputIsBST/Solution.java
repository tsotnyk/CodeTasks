package com.j2core.sts.leetcode.com.trees.twoSumInputIsBST;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class Solution {

    public boolean findTarget(TreeNode root, int k) {

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        LinkedList<Integer> numList = new LinkedList<>();

        nodeList.add(root);
        numList.add(root.val);

        while (!nodeList.isEmpty()){

            TreeNode node = nodeList.removeFirst();
            int tmp;

            if (node.left != null){

                tmp = node.left.val;
                for (Integer num : numList){
                    if (num+tmp == k) return true;
                }
                nodeList.add(node.left);
                numList.add(tmp);
            }
            if (node.right != null){
                tmp = node.right.val;
                for (Integer num : numList){
                    if (num+tmp == k) return true;
                }
                nodeList.add(node.right);
                numList.add(tmp);
            }

        }

        return false;
    }


    @Test
    public void test(){


        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(7);

        boolean result = findTarget(root, 4);

        Assert.assertTrue(result);

    }
}
