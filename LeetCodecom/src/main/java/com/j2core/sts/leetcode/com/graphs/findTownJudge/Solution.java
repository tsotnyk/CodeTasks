package com.j2core.sts.leetcode.com.graphs.findTownJudge;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findJudge(int N, int[][] trust) {

        Map<Integer, ArrayList<Integer>> edges = new HashMap<>();

        for (int[] person : trust){
            if (edges.containsKey(person[0])){
                edges.get(person[0]).add(person[1]);
            }else {
                ArrayList<Integer> tmp = new ArrayList<>(N);
                tmp.add(person[1]);
                edges.put(person[0], tmp);
            }
        }

        int potentialJudge = -1;

        for (int i = 1; i <= N; i++){
            if (!edges.containsKey(i)){
                potentialJudge = i;
            }
        }

        if (potentialJudge == -1) return -1;

        for (int i = 1; i <= N; i++){
            if (i != potentialJudge && !edges.get(i).contains(potentialJudge)){
                return -1;
            }
        }

        return potentialJudge;
    }

    @Test
    public void test(){

        Assert.assertEquals(findJudge(2, new int[][]{{1,2}}), 2);
        Assert.assertEquals(findJudge(4, new int[][]{{1,3}, {1,4}, {2,3}, {2,4}, {4,3}}), 3);
        Assert.assertEquals(findJudge(3, new int[][]{{1,2}, {2,3}}), -1);
        Assert.assertEquals(findJudge(3, new int[][]{{1,3}, {2,3}, {3,1}}), -1);

    }
}
