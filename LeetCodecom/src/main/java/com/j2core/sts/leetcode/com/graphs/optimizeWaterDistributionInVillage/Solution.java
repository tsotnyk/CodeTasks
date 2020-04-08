package com.j2core.sts.leetcode.com.graphs.optimizeWaterDistributionInVillage;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

        boolean[] visited = new boolean[n];
        Map<Integer, ArrayList<ArrayList<Integer>>> graph = createGraph(pipes);
        int index = findMinValue(visited, wells);
        int sum = 0;
        while (index > -1){
            sum += wells[index];
            wells[index] = 0;
            visited[index] = true;
            if (graph.containsKey(index)) {
                ArrayList<ArrayList<Integer>> steps = graph.get(index);
                for (ArrayList<Integer> step : steps) {
                    if (!visited[step.get(0)]) {
                        wells[step.get(0)] = Math.min(wells[step.get(0)], wells[index] + step.get(1));
                    }
                }
            }
            index = findMinValue(visited, wells);
        }

        return sum;
    }

    private Map<Integer, ArrayList<ArrayList<Integer>>> createGraph(int[][] pipes){

        Map<Integer, ArrayList<ArrayList<Integer>>> graph = new HashMap<>();

        for (int[] array : pipes) {
            if (graph.containsKey(array[0]-1)) {
                graph.get(array[0]-1).add(new ArrayList<>(Arrays.asList(array[1]-1, array[2])));
            } else {
                ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
                arrayList.add(new ArrayList<>(Arrays.asList(array[1]-1, array[2])));
                graph.put(array[0]-1, arrayList);
            }
            if (graph.containsKey(array[1]-1)){
                graph.get(array[1]-1).add(new ArrayList<>(Arrays.asList(array[0]-1, array[2])));
            }else {
                ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
                arrayList.add(new ArrayList<>(Arrays.asList(array[0]-1, array[2])));
                graph.put(array[1]-1, arrayList);
            }
        }

        return graph;
    }

    private int findMinValue(boolean[] visited, int[] paths){

        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < visited.length; i++){
            if (!visited[i] && paths[i] < minValue){
                minValue = paths[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    @Test
    public void test(){

//        Assert.assertEquals(minCostToSupplyWater(3, new int[]{1,2,2}, new int[][]{{1,2,1},{2,3,1}}), 3);
        Assert.assertEquals(minCostToSupplyWater(5, new int[]{46012,72474,64965, 751,33304}, new int[][]{{2,1,6719},{3,2,75312}, {5,3,44918}}), 131704);

    }
}
