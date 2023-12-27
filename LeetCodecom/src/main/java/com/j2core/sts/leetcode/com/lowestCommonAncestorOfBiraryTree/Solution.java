package com.j2core.sts.leetcode.com.lowestCommonAncestorOfBiraryTree;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pList = findPath(root, p);
        List<TreeNode> qList = findPath(root, q);

        TreeNode ancestor = root;
        while (!pList.isEmpty() && !qList.isEmpty() && pList.get(0) == qList.get(0)){
            ancestor = pList.remove(0);
            qList.remove(0);
        }

        return ancestor;
    }

    private List<TreeNode> findPath(TreeNode root, TreeNode target){

        List<TreeNode> list = new LinkedList<>();

        if (root == null) return list;

        if (root == target){
            list.add(root);
            return list;
        }

       List<TreeNode> nextList = findPath(root.left, target);

       if (nextList.size() > 0) {
           list.add(root);
           list.addAll(nextList);
           return list;
       }

       nextList = findPath(root.right, target);

       if (nextList.size() > 0){
           list.add(root);
           list.addAll(nextList);
       }

       return list;
    }

    @Test
    public void test(){


        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        root.left = p;
        p.left = new TreeNode(6);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(7);
        TreeNode q = new TreeNode(4);
        p.right.right = q;
        root.right = new TreeNode(1);


        Assert.assertEquals(lowestCommonAncestor(root, p, q).val, 5);
    }
}
