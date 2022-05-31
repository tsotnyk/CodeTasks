package com.j2core.sts.codefights.com.dataStructures.treesBasic.isSubtree;

import org.junit.Assert;
import org.testng.annotations.Test;

public class Solution {

    boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {

        if (t2 == null) return true;
        if (t1 == null) return false;
        if (t1.value.equals(t2.value)){
            return equalTree(t1, t2);
        }

        if (!isSubtree(t1.left, t2)){
            return isSubtree(t1.right, t2);
        }
        return true;
    }

    private boolean equalTree(Tree<Integer> t1, Tree<Integer> t2){

        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (!t1.value.equals(t2.value)) return false;

        if (equalTree(t1.left, t2.left)){
            return equalTree(t1.right, t2.right);
        }

        return false;
    }

    @Test
    public void test(){

        Tree<Integer> root1 = new Tree<>(5);
        root1.left = new Tree<>(10);
        root1.left.left = new Tree<>(4);
        root1.left.left.left = new Tree<>(1);
        root1.left.left.right = new Tree<>(2);
        root1.left.right = new Tree<>(6);
        root1.left.right.right = new Tree<>(-1);
        Tree<Integer> root2 = new Tree<>(10);
        root2.left = new Tree<>(4);
        root2.left.left = new Tree<>(1);
        root2.left.right = new Tree<>(2);
        root2.right = new Tree<>(6);
        root2.right.right = new Tree<>(-1);

        Assert.assertTrue(isSubtree(root1, root2));

    }
}
