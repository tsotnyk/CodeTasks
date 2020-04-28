package com.j2core.sts.leetcode.com.trees.constructBinarySearchTreeFromPreorderTraversal;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.testng.annotations.Test;

import java.util.Stack;

public class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {

        if (preorder == null || preorder.length < 1) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);

        TreeNode head = new TreeNode(preorder[0]);

        Stack<TreeNode> treeNodeStack = new Stack<>();
        int index = 0;
        int indexRight = 0;

        for (int i = 1; i < preorder.length; i++){
            if (preorder[index] < preorder[i]){
                indexRight = i;
                break;
            }
        }

        TreeNode tmp = head;
        treeNodeStack.push(head);
        if (indexRight == index){
            indexRight = preorder.length;
        }

        while (++index < indexRight){

            if (preorder[index] < tmp.val){
                tmp.left = new TreeNode(preorder[index]);
                tmp = tmp.left;
                treeNodeStack.push(tmp);

            }else {
                tmp = treeNodeStack.pop();
                tmp.right = new TreeNode(preorder[index]);
            }
        }

        if (index < preorder.length){
            tmp = head;
            tmp.right = new TreeNode(preorder[index]);
            tmp = tmp.right;
            treeNodeStack.push(tmp);
        }

        while (++index < preorder.length){
            if (preorder[index] < tmp.val){
                tmp.left = new TreeNode(preorder[index]);
                treeNodeStack.push(tmp);
                tmp = tmp.left;
            }else {
                tmp = treeNodeStack.pop();
                tmp.right = new TreeNode(preorder[index]);
                tmp = tmp.right;
                treeNodeStack.push(tmp);
            }
        }

        return head;
    }

    @Test
    public void test(){

        TreeNode treeNode = bstFromPreorder(new int[]{8,5,1,7,10,12}); // true
        TreeNode treeNode4 = bstFromPreorder(new int[]{8,5,1,7,10,9,12,14});  //true
        TreeNode treeNode5 = bstFromPreorder(new int[]{1,3});   //true
        TreeNode treeNode7 = bstFromPreorder(new int[]{3,1,2});   //true

        TreeNode treeNode6 = bstFromPreorder(new int[]{4,3});  // true

//        TreeNode treeNode2 = bstFromPreorder(new int[]{8,5,1,0,7,6,10,12,15});
//        TreeNode treeNode1 = bstFromPreorder(new int[]{8,5,1,2,7,6,10,12,11,13});

    }
}
