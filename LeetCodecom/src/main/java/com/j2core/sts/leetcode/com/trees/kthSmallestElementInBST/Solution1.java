package com.j2core.sts.leetcode.com.trees.kthSmallestElementInBST;
import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public int kthSmallest(TreeNode root, int k) {

        ArrayList<Integer> list = new ArrayList<>(k);
        preOrderTraverse(root, list, k);
        return list.get(k-1);
    }

    private void preOrderTraverse(TreeNode root, ArrayList<Integer> result, int k){

        if (root == null) return;
        if (root.left != null){
            preOrderTraverse(root.left, result, k);
        }
        result.add(root.val);
        if (result.size() == k) return;
        preOrderTraverse(root.right, result, k);

    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        Assert.assertEquals(kthSmallest(root, 1), 1);
        Assert.assertEquals(kthSmallest(root, 4), 4);
        Assert.assertEquals(kthSmallest(root, 3), 3);
    }
}
