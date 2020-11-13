package com.j2core.sts.leetcode.com.timeNeededToInformAllEmployees;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < manager.length; i++){
            if (manager[i] > -1) {
                List<Integer> list = map.getOrDefault(manager[i], new LinkedList<>());
                list.add(i);
                map.put(manager[i], list);
            }
        }

        List<Integer> managerList = new LinkedList<>();
        boolean[] visited = new boolean[manager.length];
        managerList.add(headID);
        visited[headID] = true;
        int sum = 0;

        while (!managerList.isEmpty()){
            int person = managerList.remove(0);
            if (map.containsKey(person)){
                sum += informTime[person];
                managerList.addAll(map.get(person));
            }
        }

        return sum;
    }

    @Test
    public void test(){

        Assert.assertEquals(numOfMinutes(15, 0, new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6}, new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}), 3);
    }
}
