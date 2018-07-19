package com.j2core.sts.codefights.com.dataStructures.treesBasic.restoreBinaryTree;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    Tree<Integer> restoreBinaryTree(int[] inorder, int[] preorder) {

        Tree<Integer> head = new Tree<>(preorder[0]);
        Tree<Integer> tmpHead = head;
        int preorderIndex = 1;
        int inorderIndex = 0;
        int counter = 1;
        for( ;preorderIndex < preorder.length; ){
            Tree<Integer> tmpTree = tmpHead;
            do{
                tmpTree.left = new Tree<Integer>(preorder[preorderIndex]);
                tmpTree = tmpTree.left;
                counter++;
                preorderIndex++;
            }while(preorderIndex < preorder.length && preorder[preorderIndex-1] != inorder[inorderIndex]);

            if (preorderIndex < preorder.length) {
                inorderIndex = counter;
                tmpHead.right = new Tree<Integer>(preorder[preorderIndex]);
                preorderIndex++;
                tmpHead = tmpHead.right;
            }
        }
        return head;
    }


//    Tree<Integer> restoreBinaryTree(int[] inorder, int[] preorder){
//
//        Tree<Integer> head = new Tree<>(preorde[0]);
//        Tree<Integer> tmpHead = head;
//        Int preorderIndex = 1;
//        Int inorderIndex = 0;
//        Int counter = 1;
//        Tree<Integer> tmpTree = head;
//        for(preordexIndex; preorderIndex < preorder.length; ){
//
//            Do{
//                tmpTree.left = new Tree<Integer>(preorder);
//                tmpTeree = tmpTree.left;
//                Counter++;
//                preorderIndex++;
//            }while(preorder[preorderIndex-1] != norder[inorderIndex]);
//
//            inorderIndex = counter;
//            tmpHead.right = newTree<Integer>(preorder[preorderIndex]);
//            preordexIndex++;
//            tmpHead = tmpHead.right;
//        }
//        Return head;
//    }


    @Test
    public void test() {

//        Tree<Integer> result = restoreBinaryTree(new int[]{4,2,1,5,3,6}, new int[]{1,2,4,3,5,6});

        Tree<Integer> result = restoreBinaryTree(new int[]{2,5}, new int[]{5,2});


        System.out.print(result);

    }
}
