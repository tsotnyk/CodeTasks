package com.j2core.sts.leetcode.com.tmp.mockInterview;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class AmazonOASolution2 {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int balance = 0;

        int callSum = 0;
        for (int i = 0; i <= calories.length-k; i++){

            if (i == 0){
                for (int j = 0; j < k; j++){
                    callSum += calories[j];
                }
            }else {
                callSum += calories[i+k-1];
                callSum -= calories[i-1];
            }
            if (callSum < lower){
                balance--;
            }
            if (callSum > upper){
                balance++;
            }
        }

        return balance;
    }

    @Test
    public void test(){

        Assert.assertEquals(0, dietPlanPerformance(new int[]{1,2,3,4,5}, 1,3, 3));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSameTree(s,t)) return true;
        if (isSubtree(s.left, t)){
            return true;
        }else {
            return isSubtree(s.right, t);
        }
    }

    public boolean isSameTree(TreeNode s, TreeNode t){

        if (s == null && t == null) return  true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;

        if (isSameTree(s.left, t.left)){
            return isSameTree(s.right, t.right);
        }else {
            return false;
        }
    }

    @Test
    public void test2(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);

        TreeNode subTree = new TreeNode(4);
        subTree.left = new TreeNode(1);
        subTree.right = new TreeNode(2);

        Assert.assertFalse(isSubtree(root, subTree));

        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(1);

        TreeNode t = new TreeNode(1);

        Assert.assertTrue(isSubtree(s, t));
    }
}
