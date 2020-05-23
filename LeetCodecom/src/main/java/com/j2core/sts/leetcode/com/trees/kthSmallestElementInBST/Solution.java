package com.j2core.sts.leetcode.com.trees.kthSmallestElementInBST;

import com.j2core.sts.leetcode.com.trees.TreeNode;

import java.util.ArrayList;

public class Solution {

    public int kthSmallest(TreeNode root, int k) {

        ArrayList<Integer> arrayList = new ArrayList<>(k+3);

        traversBST(root, arrayList, 0, k);

        return arrayList.get(k-1);
    }

    private void traversBST(TreeNode node, ArrayList<Integer> arrayList, int size, int maxSize){

        if (node == null) return;

        if (node.left != null && size < maxSize){
            traversBST(node.left, arrayList, size, maxSize);
        }
        if (size < maxSize){
            size++;
            arrayList.add(node.val);
        }
        if (node.right != null && size < maxSize){
            traversBST(node.right, arrayList, size, maxSize);
        }
    }
}
