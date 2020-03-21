package com.j2core.sts.leetcode.com.trees.binaryTreeInorderTraversal;

import com.j2core.sts.leetcode.com.trees.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(new TreeNode(node.val));
                stack.push(node.left);
            }else {
                result.add(node.val);
            }
        }
        return result;
    }
}
