package com.j2core.sts.leetcode.com.binaryTreeVerticalOrderTraversal;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();


        MinMaxValues minMax = traverse(root, map, 0, new MinMaxValues());
        List<List<Integer>> result = new LinkedList<>();

        for (int i = minMax.min; i <= minMax.max; i++){
            result.add(map.get(i));
        }

        return result;
    }

    private MinMaxValues traverse(TreeNode root, HashMap<Integer, List<Integer>> map, int delta, MinMaxValues minMax){

        if (root == null) return minMax;

        List<Integer> list = map.getOrDefault(delta, new LinkedList<Integer>());
        list.add(root.val);
        map.put(delta, list);

        if (minMax.max < delta) minMax.max = delta;
        if (minMax.min > delta) minMax.min = delta;

        minMax = traverse(root.left, map, delta-1, minMax);
        minMax = traverse(root.right, map, delta+1, minMax);

        return minMax;
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

class MinMaxValues{

    Integer min ;
    Integer max;

    public MinMaxValues() {
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
    }

}

