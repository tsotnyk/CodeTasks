package com.j2core.sts.leetcode.com.trees.constructBinarySearchTreeFromPreorderTraversal;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.annotations.Test;

public class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {

        if (preorder == null || preorder.length < 1) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);

        TreeNode head = new TreeNode(preorder[0]);
        addValue(head,1, preorder);

        return head;
    }

    private void addValue(TreeNode node, int index, int[] preorders){

        if (index == preorders.length) return;

        if (preorders[index] < node.val){

        }

    }

    @Test
    public void test(){

        TreeNode treeNode = bstFromPreorder(new int[]{8,5,1,7,10,12});
        TreeNode treeNode2 = bstFromPreorder(new int[]{8,5,1,0,7,6,10,12,15});
        TreeNode treeNode1 = bstFromPreorder(new int[]{8,5,1,2,7,6,10,12,11,13});

    }
}
