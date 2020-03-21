package com.j2core.sts.leetcode.com.trees.binaryTreeZigzagLevelOrderTraversal;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        zigzagLevelOrder(root, res, 0);
        return res;
    }

    private void zigzagLevelOrder(TreeNode root, List<List<Integer>> res, int level) {
        if (root!=null){
            if (res.size()<=level)
                res.add(new LinkedList<>());
            if (level%2==0)
                res.get(level).add(root.val);
            else res.get(level).add(0, root.val);
            zigzagLevelOrder(root.left, res, level+1);
            zigzagLevelOrder(root.right, res, level+1);

        }
    }

    @Test
    public void test(){

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(5);

        List<List<Integer>> result = zigzagLevelOrder(node);

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.right = new TreeNode(7);
        node1.right.left = new TreeNode(15);

        List<List<Integer>> result1 = zigzagLevelOrder(node1);

        Assert.assertEquals(result.size(), 3);
        Assert.assertEquals(result1.size(), 3);

    }
}
