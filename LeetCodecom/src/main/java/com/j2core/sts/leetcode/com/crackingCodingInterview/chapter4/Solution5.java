package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter4;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {

    public boolean isBST(TreeNode root){

        ArrayList<Integer> list = new ArrayList<>();
        travers(root, list);

        int num = list.get(0);
        for (int i = 1; i < list.size(); i++){
            int tmp = list.get(i);
            if (tmp < num) return false;
            num = tmp;
        }

        return true;
    }

    private void travers(TreeNode node, List<Integer> list){

        if (node == null) return;

        travers(node.left, list);
        list.add(node.val);
        travers(node.right, list);

    }
}
