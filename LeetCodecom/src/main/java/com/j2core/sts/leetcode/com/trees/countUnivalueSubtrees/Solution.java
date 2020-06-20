package com.j2core.sts.leetcode.com.trees.countUnivalueSubtrees;

import com.j2core.sts.leetcode.com.trees.TreeNode;

import java.util.LinkedList;

public class Solution {

    public int countUnivalSubtrees(TreeNode root) {

        if (root == null) return 0;

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        if (root.right != null) nodeList.add(root.right);
        if (root.left != null) nodeList.add(root.left);
        int counter = 0;

        while (!nodeList.isEmpty()){
            TreeNode node = nodeList.removeFirst();
            if (node.val == root.val){
                counter++;
            }
            if (node.left != null) nodeList.add(node.left);
            if (node.right != null) nodeList.add(node.right);
        }

        return counter;
    }
}
