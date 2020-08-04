package com.j2core.sts.leetcode.com.trees.binaryTreePaths;

import com.j2core.sts.leetcode.com.trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) return new LinkedList<>();

        if (root.left == null && root.right == null) return new LinkedList<>(Collections.singletonList(String.valueOf(root.val)));

        List<String> result = new LinkedList<>();

        createPath(root, "", result);

        return result;
    }

    private void createPath(TreeNode node, String path, List<String> pathList){

        path = path.concat(String.valueOf(node.val));
        if (node.left == null && node.right == null){
            pathList.add(path);
        }else {
            path = path.concat("->");
            if (node.left != null){
                createPath(node.left, path, pathList);
            }
            if (node.right != null){
                createPath(node.right, path, pathList);
            }
        }
    }

    @Test
    public void test(){

        TreeNode root = null;
        Assert.assertEquals(binaryTreePaths(root).size(), 0);

        TreeNode root1 = new TreeNode(1);
        Assert.assertEquals(binaryTreePaths(root1).size(), 1);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        Assert.assertEquals(binaryTreePaths(root2).size(), 2);

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.right = new TreeNode(3);
        root3.right = new TreeNode(4);
        root3.right.left = new TreeNode(5);
        root3.right.right = new TreeNode(6);
        Assert.assertEquals(binaryTreePaths(root3).size(), 3);
    }
}
