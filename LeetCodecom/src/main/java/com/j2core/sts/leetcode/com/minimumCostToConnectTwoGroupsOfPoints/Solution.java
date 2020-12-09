package com.j2core.sts.leetcode.com.minimumCostToConnectTwoGroupsOfPoints;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public int connectTwoGroups(List<List<Integer>> cost) {

        int minCost = Integer.MAX_VALUE;
        int size = cost.get(0).size();
        HashSet<Integer> visitedNode = new HashSet<>();
        for (int i = 0; i < cost.size(); i++){
            int num = cost.get(0).get(i);
            visitedNode.add(i);
            int oneCost = minCost(cost, visitedNode, 1, size, num);
            minCost = Math.min(minCost, oneCost);
            visitedNode.remove(i);
        }

        return minCost;
    }

    private int minCost(List<List<Integer>> cost, HashSet<Integer> visitedNode, int index, int size, int sum){

        if (index == cost.size()) return sum;

        int minCost = Integer.MAX_VALUE;
        int i = 0;
        for (int num : cost.get(index)){
            if (!visitedNode.contains(i)){
                visitedNode.add(i);
                int tmp = minCost(cost, visitedNode, index+1, size, sum+num);
                minCost = Math.min(minCost, tmp);
                visitedNode.remove(i);
            }
            i++;
        }

//        if (index+1 == cost.size()){
//            for (int i = 0; i < size; i++){
//                if (!visitedNode.contains(i)) return sum + cost.get(index).get(i);
//            }
//        }
//
//        PriorityQueue<Integer> priorityCost = new PriorityQueue<>();
//
//        for (int i )

        return minCost;
    }

    @Test
    public void test(){

        List<List<Integer> > list = new LinkedList<>();
        list.add(new LinkedList<>(Arrays.asList(1,3,5)));
        list.add(new LinkedList<>(Arrays.asList(4,1,1)));
        list.add(new LinkedList<>(Arrays.asList(1,5,3)));

        Assert.assertEquals(connectTwoGroups(list), 4);
    }
}
