package com.j2core.sts.codefights.com.dataStructures.treesBasic.hasPathWithGivenSum;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    boolean hasPathWithGivenSum(Tree<Integer> t, int s) {

        if (t == null) {

            if (s == 0){
                return true;
            }else {
                return false;
            }

        }

        return givenSum(t, 0, s);

    }


    private boolean givenSum(Tree<Integer> tree, int sum, int s){

        boolean tmpResult;
        sum = sum + tree.value;

        if (tree.left == null && tree.right == null){

            if (sum == s) return true;

        }else {

            if (tree.left != null){

                tmpResult = givenSum(tree.left, sum, s);

                if (tmpResult) return true;

            }

            if (tree.right != null){

                tmpResult = givenSum(tree.right, sum, s);

                if (tmpResult) return true;

            }

        }

        return false;

    }


    @Test
    public void test(){


        Tree<Integer> tree = new Tree<>(4);
        tree.left = new Tree<>(1);
        tree.left.left = new Tree<>(-2);
        tree.left.left.right = new Tree<>(3);
        tree.right = new Tree<>(3);
        tree.right.left = new Tree<>(1);
        tree.right.right = new Tree<>(2);
        tree.right.right.left = new Tree<>(-2);
        tree.right.right.right = new Tree<>(-3);

        boolean result = hasPathWithGivenSum(tree, 7);

        Assert.assertTrue(result);


    }
}
