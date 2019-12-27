package com.j2core.sts.leetcode.com.minimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int depth = 1;

        List<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        List<TreeNode> tmpList = new LinkedList<>();

        while (true){

            if (nodeList.isEmpty()){
                nodeList = tmpList;
                tmpList = new LinkedList<>();
                depth++;

            }else {
                TreeNode node = nodeList.remove(0);
                if (node.right == null && node.left == null){
                    return depth;
                }
                if (node.right != null) tmpList.add(node.right);
                if (node.left != null) tmpList.add(node.left);
            }
        }
    }

    public int minDepthRecursive(TreeNode root) {

        int count = 0;

        if (root == null){
            return 0;
        }else {
            count++;

            if (root.left == null){
                return count + minDepth(root.right);
            }else if (root.right == null){
                return count + minDepth(root.left);
            }else {
                return count + Math.min(minDepth(root.left), minDepth(root.right));
            }
        }
    }

}
