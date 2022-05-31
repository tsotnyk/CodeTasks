package com.j2core.sts.codefights.com.sortingAndSearching.dfs_bfs.digitTreeSum;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    long digitTreeSum(Tree<Integer> t) {

        if (t.left == null && t.right == null) return t.value;

        return sum(t.value, t.left) + sum(t.value, t.right);
    }

    private long sum(long value, Tree<Integer> root){

        if (root == null) return value;
        value = (value*10)+root.value;
        if (root.left == null && root.right == null){
            return value;
        }if (root.left == null){
            return sum(value, root.right);
        }if (root.right == null){
            return sum(value, root.left);
        }
        return sum(value, root.left) + sum(value, root.right);
    }

    @Test
    public void test(){

        Tree<Integer> root = new Tree<>(0);
        root.left = new Tree<>(9);
        root.right = new Tree<>(9);
        root.right.left = new Tree<>(1);
        root.right.right = new Tree<>(3);
        Assert.assertEquals(digitTreeSum(root), 193);
    }
}
