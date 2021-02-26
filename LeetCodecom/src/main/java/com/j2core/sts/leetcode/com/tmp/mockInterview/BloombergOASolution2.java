package com.j2core.sts.leetcode.com.tmp.mockInterview;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class BloombergOASolution2 {

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) return 0;
        int sum = 0;

        List<TreeNode> list = new LinkedList<>(Collections.singletonList(root));
        List<TreeNode> nextList = new LinkedList<>();
        while (!list.isEmpty()){
            TreeNode node = list.remove(0);
            if (node.left != null){
                if(node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
                nextList.add(node.left);
            }
            if (node.right != null){
                nextList.add(node.right);
            }
            if (list.isEmpty()){
                list = nextList;
                nextList = new LinkedList<>();
            }
        }

        return sum;
    }

    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

    @Test
    public void test(){

//        Assert.assertEquals(1, minCostClimbingStairs(new int[]{0,0,2,1}));
//
//        Assert.assertEquals(15, minCostClimbingStairs(new int[]{10,15,20}));
        Assert.assertEquals(6, minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

    }
}
