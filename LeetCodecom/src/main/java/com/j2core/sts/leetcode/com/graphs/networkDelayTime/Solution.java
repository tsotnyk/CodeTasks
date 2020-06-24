package com.j2core.sts.leetcode.com.graphs.networkDelayTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {

        int[] length = new int[N+1];
        Arrays.fill(length, Integer.MAX_VALUE);
        length[K] = 0;
        length[0] = 0;
        boolean[] visit = new boolean[N+1];

        HashMap<Integer, List<int[]>> graph = createGraph(times);
        int index = K;
        List<int[]> rows = graph.getOrDefault(K, new ArrayList<>());
        int counter = 0;
        while (counter++ < N){
             visit[index] = true;

            for (int[] time : rows) {
                length[time[1]] = Math.min(length[index] + time[2], length[time[1]]);
            }

            index = findSmallerLength(length, visit);
            rows = graph.getOrDefault(index, new ArrayList<>());

        }

        int maxLength = 0;

        for (int num : length){
            if (num == Integer.MAX_VALUE) {
               return -1;
            }
            maxLength = Math.max(maxLength, num);
        }
        return maxLength == 0 ? -1 : maxLength;
    }

    private int findSmallerLength(int[] length, boolean[] visit) {

        int minValue = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i < length.length; i++){
            if (!visit[i] && length[i] < minValue){
                minValue = length[i];
                index = i;
            }
        }
        return index;
    }

    private HashMap<Integer, List<int[]>> createGraph(int[][] times){

        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times){
            if (graph.containsKey(time[0])){
                graph.get(time[0]).add(time);
            }else {
                ArrayList<int[]> list = new ArrayList<>();
                list.add(time);
                graph.put(time[0], list);
            }
        }

        return graph;
    }

    @Test
    public void test(){

        Assert.assertEquals(networkDelayTime(new int[][]{{1,2,1},{2,3,2},{1,3,1}}, 3, 2), -1);

        Assert.assertEquals(networkDelayTime(new int[][]{{1,2,1}}, 2, 2), -1);

        Assert.assertEquals(networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2), 2);

    }
}
