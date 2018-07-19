package com.j2core.sts.leetcode.com.trees.binaryTreeLevelOrderTraversalII;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) return new LinkedList<>();

        List<List<TreeNode>> treeList = new LinkedList<>();

        List<TreeNode> tmpResult = new LinkedList<>();
        tmpResult.add(root);
        do {

            treeList.add(tmpResult);
            List<TreeNode> tmpList = tmpResult;
            tmpResult = new LinkedList<>();

            for (TreeNode node : tmpList){

                if (node.left != null){
                    tmpResult.add(node.left);
                }if (node.right != null){
                    tmpResult.add(node.right);
                }
            }

        }while (!tmpResult.isEmpty());

        List<List<Integer>> result = new LinkedList<>();

        for (List<TreeNode> list : treeList){

            List<Integer> tmp = new LinkedList<>();
            for (TreeNode node : list){

                tmp.add(node.val);
            }
            ((LinkedList<List<Integer>>) result).addFirst(tmp);
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

        List<List<Integer>> result = levelOrderBottom(root);

        System.out.print(result.size());

    }
}
