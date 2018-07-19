package com.j2core.sts.codefights.com.dataStructures.treesBasic.kthSmallestInBST;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    int kthSmallestInBST(Tree<Integer> t, int k) {

        if (t.left == null && t.right == null) return t.value;

        int[] steps = new int[]{k};
        Tree<Integer> result = findNum(steps, t, null);

        return result.value;

    }

    private Tree<Integer> findNum(int[] amountStep, Tree<Integer> tree, Tree<Integer> result){

        if (tree != null){

            result = findNum(amountStep, tree.left, result);

            if (result == null) {
                amountStep[0] = amountStep[0] - 1;
                if (amountStep[0] == 0) {
                    return tree;
                }
                result = findNum(amountStep, tree.right, null);
            }
        }

        return result;
    }



    @Test
    public void test(){

        Tree<Integer> tree1 = new Tree<>(3);
        tree1.left = new Tree<>(1);
        tree1.right = new Tree<>(5);
        tree1.right.left = new Tree<>(4);
        tree1.right.right = new Tree<>(6);

        int tmp = kthSmallestInBST(tree1, 4);

        Assert.assertEquals(5, tmp);

    }

}
