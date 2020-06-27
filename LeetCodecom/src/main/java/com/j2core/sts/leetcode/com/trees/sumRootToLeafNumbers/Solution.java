package com.j2core.sts.leetcode.com.trees.sumRootToLeafNumbers;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int sumNumbersOld(TreeNode root) {

        if (root == null) return 0;
        LinkedList<Integer> numbers = new LinkedList<>();

        findNums(root, 0, numbers);

        int sum = 0;
        for (int num : numbers){
            sum += num;
        }
        return sum;
    }

    private void findNums(TreeNode node, int sum, List<Integer> list){

        if (sum == 0) {
            sum = node.val;
        } else {
            sum = (sum * 10) + node.val;
        }

        if (node.left == null && node.right == null){
            list.add(sum);
        }else{
            if (node.left != null){
                findNums(node.left, sum, list);
            }
            if (node.right != null){
                findNums(node.right, sum, list);
            }
        }
    }

    public int sumNumbers(TreeNode root) {

        int sum = 0;

        List<List<TreeNode>> leafList = new ArrayList<>();

         return 0;

    }

    @Test
    public void test(){




        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(9);
        node.right = new TreeNode(0);
        node.left.right = new TreeNode(1);
        node.left.left = new TreeNode(5);

        Assert.assertEquals(sumNumbers(node), 1026);
    }


}
