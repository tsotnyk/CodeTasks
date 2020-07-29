package com.j2core.sts.leetcode.com;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestTmp {

    @Test
    public void tmp(){

        ArrayList<Character> word = new ArrayList<>(Arrays.asList('a','b','a','b','c','a','c'));

        word.add(0, 'c');
        word.remove(5);

        System.out.println(word.size());
    }


    @Test
    public void test(){

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(0);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(5);
        root.right.right = new TreeNode(8);

    }

    public class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
