package com.j2core.sts.leetcode.com.trees.constructBinarySearchTreeFromPreorderTraversal;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.annotations.Test;

public class Solution {

    int index;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.index = 0;
        return createTree(Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
    }

    private TreeNode createTree(int min, int max, int[] preOrder){

        if (index == preOrder.length) return null;

        int val = preOrder[index];
        if (min > val || max < val) return null;

        TreeNode node = new TreeNode(val);
        index++;
        TreeNode tmp = createTree(min, val, preOrder);
        if (tmp != null){
            node.left = tmp;
        }
        tmp = createTree(val, max, preOrder);
        if (tmp != null){
            node.right = tmp;
        }
        return node;
    }

    @Test
    public void test(){

        TreeNode treeNode = bstFromPreorder(new int[]{8,5,1,7,10,12}); // true
        TreeNode treeNode4 = bstFromPreorder(new int[]{8,5,1,7,10,9,12,14});  //true
        TreeNode treeNode5 = bstFromPreorder(new int[]{1,3});   //true
        TreeNode treeNode7 = bstFromPreorder(new int[]{3,1,2});   //true

        TreeNode treeNode6 = bstFromPreorder(new int[]{4,3});  // true

        TreeNode treeNode2 = bstFromPreorder(new int[]{8,5,1,0,7,6,10,12,15});
        TreeNode treeNode1 = bstFromPreorder(new int[]{8,5,1,2,7,6,10,12,11,13});

    }
}
