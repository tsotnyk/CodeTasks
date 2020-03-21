package com.j2core.sts.leetcode.com.trees.binaryTreeLevelOrderTraversal;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        List<Integer> tmpResult = new LinkedList<>();
        List<TreeNode> tmp = new LinkedList<>();
        List<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty() || !tmp.isEmpty()){

            if (list.isEmpty()){
                result.add(tmpResult);
                tmpResult = new LinkedList<>();
                list = tmp;
                tmp = new LinkedList<>();
            }
            TreeNode node = list.remove(0);
            tmpResult.add(node.val);

            if (node.left != null) {
                tmp.add(node.left);
            }
            if (node.right != null) {
                tmp.add(node.right);
            }
        }

        if (!tmpResult.isEmpty()){
            result.add(tmpResult);
        }

        return result;
    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Assert.assertEquals(levelOrder(root).size(), 3);
    }
}
