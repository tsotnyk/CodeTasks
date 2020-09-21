package com.j2core.sts.leetcode.com.inorderSuccessorInBSTII;

public class Solution {

    public Node inorderSuccessor(Node node) {

        int val = node.val;
        if (node.right == null){
            while (node.val <= val && node.parent != null ){
                node = node.parent;
            }
            if (node.val <= val) return null;
        }else {
            node = node.right;
            while (node.left != null){
                node = node.left;
            }
        }
        return node;
    }
}
