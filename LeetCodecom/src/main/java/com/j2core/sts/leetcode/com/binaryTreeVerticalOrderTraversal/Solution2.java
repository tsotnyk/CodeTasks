package com.j2core.sts.leetcode.com.binaryTreeVerticalOrderTraversal;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution2 {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        AtomicInteger minIndex = new AtomicInteger(0);
        AtomicInteger maxIndex = new AtomicInteger(0);

        travers(root, 0, map, minIndex, maxIndex);

        List<List<Integer>> res = new LinkedList<>();
        for (int i = minIndex.get(); i <= maxIndex.get(); i++){
            res.add(map.get(i));
        }

        return res;
    }

    private void travers(TreeNode root, int i, HashMap<Integer, List<Integer>> map, AtomicInteger minIndex, AtomicInteger maxIndex) {

        if (root != null){

            if (minIndex.get() > i) minIndex.set(i);
            if (maxIndex.get() < i) maxIndex.set(i);

            if (map.containsKey(i)){
                map.get(i).add(root.val);
            }else {
                List<Integer> list = new LinkedList<>();
                list.add(root.val);
                map.put(i, list);
            }

            travers(root.left, i-1, map, minIndex, maxIndex);
            travers(root.right, i+1, map, minIndex, maxIndex);

        }

    }

    @Test
    public void test(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(verticalOrder(root).size(), 4);
    }


}
