package com.j2core.sts.leetcode.com.trees.cousinsInBinaryTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;

import java.util.LinkedList;
import java.util.List;


public class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {

        List<TreeNode> masterList = new LinkedList<>();
        List<TreeNode> list = new LinkedList<>();
        masterList.add(root);
        int depth = 0;
        int depthX = -1;
        int depthY = -1;

        while (! masterList.isEmpty()){
            TreeNode masterNode = masterList.remove(0);
            if (masterNode.val == x){
                depthX = depth;
            }else if (masterNode.val == y){
                depthY = depth;
            }else if (masterNode.left != null && masterNode.right != null && ((masterNode.left.val == x && masterNode.right.val == y)
                    || (masterNode.left.val == y && masterNode.right.val == x))){
                return false;
            }
            if (masterNode.left != null){
                list.add(masterNode.left);
            }
            if (masterNode.right != null){
                list.add(masterNode.right);
            }
            if (depthX > -1 && depthY > -1) break;
            if (masterList.isEmpty() && !list.isEmpty()){
                masterList = list;
                depth++;
                list = new LinkedList<>();
            }
        }

        return depthX == depthY;
    }
}
