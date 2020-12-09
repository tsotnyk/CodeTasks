package com.j2core.sts.leetcode.com.arrays.mostVisitedSectorInCircularTrack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> mostVisited(int n, int[] rounds) {

        int maxVisit = 1;
        int[] sectors = new int[n];
        sectors[rounds[0]-1] += 1;

        for (int i = 0; i < rounds.length-1; i++){
            int index = rounds[i];
            while (index != rounds[i+1]){
                if (index == sectors.length){
                    index = 0;
                }
                sectors[index] += 1;
                if (sectors[index] > maxVisit) maxVisit = sectors[index];
                index++;
            }
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < sectors.length; i++){
            if (sectors[i] == maxVisit){
                result.add(i+1);
            }
        }
        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(mostVisited(4, new int[]{1,3,1,2}).size(), 2);
        Assert.assertEquals(mostVisited(2, new int[]{2,1,2,1,2,1,2,1,2}).size(), 1);
        Assert.assertEquals(mostVisited(7, new int[]{1,3,5,7}).size(), 7);

    }
}
