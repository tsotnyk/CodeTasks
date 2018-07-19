package com.j2core.sts.leetcode.com.trees.invertBinaryTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class Solution {

    public TreeNode invertTree(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.add(root);

        while (!stack.isEmpty()){

            TreeNode node = stack.removeFirst();

            if (node != null){

                TreeNode tmpNode = node.left;
                node.left = node.right;
                node.right = tmpNode;

                stack.add(node.left);
                stack.add(node.right);
            }

        }

        return root;
    }


    @Test
    public void test(){

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        TreeNode result = invertTree(root);

        System.out.print(result.val);

    }
}
