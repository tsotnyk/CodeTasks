package com.j2core.sts.leetcode.com.trees.maximumDepthOfNTree;

public class Solution {

    public int maxDepth(Node root) {

        if (root == null) return 0;
        if (root.children == null || root.children.isEmpty()) return 1;

        int childDepth = 0;
        for (Node child : root.children){
            childDepth = Math.max(childDepth, maxDepth(child));
        }

        return childDepth+1;
    }
}
