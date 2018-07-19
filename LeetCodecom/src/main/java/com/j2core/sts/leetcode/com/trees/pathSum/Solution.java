package com.j2core.sts.leetcode.com.trees.pathSum;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;

        boolean result = false;

        List<Integer> sumList = new LinkedList<>();
        List<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()){

            TreeNode tmpNode = ((LinkedList<TreeNode>) list).removeLast();
            if (tmpNode.left == null && tmpNode.right == null){
                sumList.add(tmpNode.val);
            }else {
                if (tmpNode.left != null){
                    tmpNode.left.val = tmpNode.left.val + tmpNode.val;
                    list.add(tmpNode.left);
                }
                if (tmpNode.right != null){
                    tmpNode.right.val = tmpNode.right.val + tmpNode.val;
                    list.add(tmpNode.right);
                }
            }
        }

        for (Integer tmpSum : sumList){

            if (tmpSum == sum){
                result = true;
                break;
            }
        }

        return result;

    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        boolean result = hasPathSum(root, 22);

        Assert.assertTrue(result);
    }
}
