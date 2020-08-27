package com.j2core.sts.leetcode.com.graphs.minimumNumberOfVerticesToReachAllNodes;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        boolean[] nodes = new boolean[n];

        for (List<Integer> list : edges){
            nodes[list.get(1)] = true;
        }

        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < n; i++){
            if (!nodes[i]){
                result.add(i);
            }
        }

        return result;

        //time complexity is O(m+n) where m is edges.length, and n is count of nodes
    }

    @Test
    public void test(){

        List<List<Integer>> data1 = new LinkedList<>();
        data1.add(new LinkedList<>(Arrays.asList(0,1)));
        data1.add(new LinkedList<>(Arrays.asList(2,1)));
        data1.add(new LinkedList<>(Arrays.asList(3,1)));
        data1.add(new LinkedList<>(Arrays.asList(1,4)));
        data1.add(new LinkedList<>(Arrays.asList(2,4)));

        List<List<Integer>> data2 = new LinkedList<>();
        data2.add(new LinkedList<>(Arrays.asList(0,1)));
        data2.add(new LinkedList<>(Arrays.asList(0,2)));
        data2.add(new LinkedList<>(Arrays.asList(2,5)));
        data2.add(new LinkedList<>(Arrays.asList(3,4)));
        data2.add(new LinkedList<>(Arrays.asList(4,2)));

        Assert.assertEquals(findSmallestSetOfVertices(5, data1), new LinkedList<>(Arrays.asList(0,2,3)));
        Assert.assertEquals(findSmallestSetOfVertices(6, data2), new LinkedList<>(Arrays.asList(0,3)));

    }
}
