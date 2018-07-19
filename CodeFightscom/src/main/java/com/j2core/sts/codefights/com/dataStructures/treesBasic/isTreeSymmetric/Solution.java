package com.j2core.sts.codefights.com.dataStructures.treesBasic.isTreeSymmetric;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    boolean isTreeSymmetric(Tree<Integer> t) {

        if (t == null){
            return true;
        }else if (t.left == null && t.right == null){
            return true;
        }else if (t.left == null || t.right == null){
            return false;
        }else {

            return equalsTree(t.left, t.right);

        }
    }


    private boolean equalsTree(Tree<Integer> left, Tree<Integer> right){

        boolean tmpResult;

        if (left == null && right == null){

            return true;

        }else if (left == null || right == null){

            return false;

        }else if (!left.value.equals(right.value)){

            return false;

        }else {

            tmpResult = equalsTree(left.left, right.right);

            if (tmpResult){

                tmpResult = equalsTree(left.right, right.left);

                if (!tmpResult) return false;

            }else {

                return false;
            }

        }
        return true;
    }


    @Test
    public void test(){

        Tree<Integer> tree = new Tree<>(1);
        tree.left = new Tree<>(2);
        tree.left.right = new Tree<>(3);
        tree.right = new Tree<>(2);
        tree.right.right = new Tree<>(3);

        boolean result1 = isTreeSymmetric(tree);

        Assert.assertFalse(result1);

        Tree<Integer> tree1 = new Tree<>(1);
        tree1.left = new Tree<>(2);
        tree1.left.left = new Tree<>(3);
        tree1.left.right = new Tree<>(4);
        tree1.right = new Tree<>(2);
        tree1.right.left = new Tree<>(4);
        tree1.right.right = new Tree<>(3);

        boolean result2 = isTreeSymmetric(tree1);

        Assert.assertTrue(result2);

    }

}
