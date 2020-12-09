package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution4_1 {

    public boolean isNodesConnected(Map<Integer, List<Integer>> map, int start, int end){

        if (map == null || map.isEmpty()) return false;
        if (start == end) return true;

        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()){
            int node = stack.pop();
            if (node == end) return true;
            for (int num : map.get(node)){
                stack.push(num);
            }
        }
        return false;
    }

    @Test
    public void test(){

        Map<Integer, List<Integer>> mapNull = null;
        Map<Integer, List<Integer>> mapEmpty = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> first = new LinkedList<>(Arrays.asList(2));
        List<Integer> second = new LinkedList<>(Arrays.asList(4));
        List<Integer> third = new LinkedList<>(Arrays.asList(4,5));
        List<Integer> four  = new LinkedList<>();
        List<Integer> five = new LinkedList<>();
        map.put(1,first);
        map.put(2,second);
        map.put(3,third);
        map.put(4, four);
        map.put(5,five);

        Assert.assertFalse(isNodesConnected(mapNull, 1,5));
        Assert.assertFalse(isNodesConnected(mapEmpty, 1,5));
        Assert.assertFalse(isNodesConnected(map, 1,5));

        Assert.assertTrue(isNodesConnected(map, 1,1));
        Assert.assertTrue(isNodesConnected(map, 1,4));

    }
}
