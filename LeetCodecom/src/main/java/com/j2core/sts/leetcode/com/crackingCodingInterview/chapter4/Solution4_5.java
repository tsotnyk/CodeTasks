package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter4;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution4_5 {

    public boolean isBST(TreeNode root){

        ArrayList<Integer> list = new ArrayList<>();
        travers(root, list);

        int num = list.remove(0);
        for (int next : list){
            if (next < num) return false;
            num = next;
        }

        return true;
    }

    private void travers(TreeNode node, List<Integer> list){

        if (node == null) return;

        travers(node.left, list);
        list.add(node.val);
        travers(node.right, list);

    }

    @Test
    public void test(){


    }
}
