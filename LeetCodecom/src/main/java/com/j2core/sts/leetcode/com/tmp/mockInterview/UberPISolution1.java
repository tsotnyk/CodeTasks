package com.j2core.sts.leetcode.com.tmp.mockInterview;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class UberPISolution1 {

    public int kthSmallest(TreeNode root, int k) {
        int counter = 0;
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);

        while (!nodeList.isEmpty()){
            TreeNode node = nodeList.getLast();
            if (node.left != null){
                nodeList.add(node.left);
                node.left = null;
                continue;
            }
            counter++;
            if (counter == k){
                return node.val;
            }
            nodeList.removeLast();
            if (node.right != null){
                nodeList.add(node.right);
            }
        }

        return -1;
    }

    @Test
    public void test(){


        TreeNode root1 = new TreeNode(1);

        root1.right = new TreeNode(2);
        Assert.assertEquals(2, kthSmallest(root1, 2));


        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        Assert.assertEquals(3, kthSmallest(root, 3));
    }


}
