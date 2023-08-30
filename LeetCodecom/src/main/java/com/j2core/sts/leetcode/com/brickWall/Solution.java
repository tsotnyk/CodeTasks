package com.j2core.sts.leetcode.com.brickWall;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int leastBricks(List<List<Integer>> wall) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (List<Integer> row : wall){
            int sum = 0;
            for (int i = 0; i <row.size()-1; i++){
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }

        int minCross = wall.size();

        for (int key : map.keySet()){
            minCross = Math.min(minCross, wall.size()-map.get(key));
        }

        return minCross;
    }

    @Test
    public void test(){

        List<List<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<>(Arrays.asList(1,2,2,1)));
        list.add(new LinkedList<>(Arrays.asList(3,1,2)));
        list.add(new LinkedList<>(Arrays.asList(1,3,2)));
        list.add(new LinkedList<>(Arrays.asList(2,4)));
        list.add(new LinkedList<>(Arrays.asList(3,1,2)));
        list.add(new LinkedList<>(Arrays.asList(1,3,1,1)));


        Assert.assertEquals(leastBricks(list), 1);
    }
}
