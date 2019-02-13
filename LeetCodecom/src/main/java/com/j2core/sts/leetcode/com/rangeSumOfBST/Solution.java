package com.j2core.sts.leetcode.com.rangeSumOfBST;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int rangeSumBST(TreeNode root, int L, int R) {

        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int sum = 0;

        while (!nodes.isEmpty()){

            TreeNode node = ((LinkedList<TreeNode>) nodes).removeFirst();

            if (node.val < L){
                if (node.right != null){
                    nodes.add(node.right);
                }
            }else if (node.val > R){
                if (node.left != null){
                    nodes.add(node.left);
                }
            }else {
                sum += node.val;
                if (node.left != null){
                    nodes.add(node.left);
                }
                if (node.right != null){
                    nodes.add(node.right);
                }
            }
        }

        return sum;
    }
}
