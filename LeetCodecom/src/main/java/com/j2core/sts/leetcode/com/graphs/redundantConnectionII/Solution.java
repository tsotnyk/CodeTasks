package com.j2core.sts.leetcode.com.graphs.redundantConnectionII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int root;
        List<Integer> children = null;

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges){
            if (graph.containsKey(edge[0])){
                //todo
            }else {
                //todo
            }
        }

        return null;
    }
}
