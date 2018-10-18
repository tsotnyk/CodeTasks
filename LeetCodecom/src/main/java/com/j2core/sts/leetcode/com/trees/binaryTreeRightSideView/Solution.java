package com.j2core.sts.leetcode.com.trees.binaryTreeRightSideView;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new LinkedList<>();

        if (root == null){
            return result;
        }else {

            List<TreeNode> list  = new LinkedList<>();
            list.add(root);

            while (!list.isEmpty()){

                result.add(list.get(0).val);

                list = createTreeList(list);

            }

            return result;
        }
    }

    private List<TreeNode> createTreeList(List<TreeNode> list) {

        List<TreeNode> result = new LinkedList<>();

        for (TreeNode node : list){

            if (node.right != null){
                result.add(node.right);
            }
            if (node.left != null){
                result.add(node.left);
            }
        }

        return result;
    }


    @Test
    public void test(){

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(4);

        List<Integer> result = rightSideView(node);

        Assert.assertEquals(result.size(), 3);

    }
}
