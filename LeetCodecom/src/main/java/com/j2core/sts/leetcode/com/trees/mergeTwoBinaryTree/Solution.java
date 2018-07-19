package com.j2core.sts.leetcode.com.trees.mergeTwoBinaryTree;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null){
            return t2;
        }else if (t2 == null){
            return t1;
        }else {

            List<TreeNode> stack1 = new LinkedList<>();
            List<TreeNode> stack2 = new LinkedList<>();

            t1.val = t1.val + t2.val;

            stack1.add(t1);
            stack2.add(t2);

            while (!stack1.isEmpty()) {

                TreeNode node1 = ((LinkedList<TreeNode>) stack1).removeFirst();
                TreeNode node2 = ((LinkedList<TreeNode>) stack2).removeFirst();

                if (node1 != null && node2 != null) {
                    if (node1.left != null && node2.left != null) {
                        node1.left.val = node1.left.val + node2.left.val;
                    } else if (node1.left == null) {
                        node1.left = node2.left;
                        node2.left = null;
                    }
                    stack1.add(node1.left);
                    stack2.add(node2.left);

                    if (node1.right != null && node2.right != null) {
                        node1.right.val = node1.right.val + node2.right.val;
                    } else if (node1.right == null) {
                        node1.right = node2.right;
                        node2.right = null;
                    }
                    stack1.add(node1.right);
                    stack2.add(node2.right);
                }
            }

            return t1;
        }
    }


    @Test
    public void test(){

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(3);
        node1.left.left = new TreeNode(5);
        node1.right = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(1);
        node2.left.right = new TreeNode(4);
        node2.right = new TreeNode(3);
        node2.right.right = new TreeNode(7);

        TreeNode result = mergeTrees(node1, node2);


    }

}
