package com.j2core.sts.leetcode.com.numbersOfFlowersInFullBloom;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] fullBloomFlowersTimeLimitEx(int[][] flowers, int[] people) {

        Arrays.sort(flowers, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] result = new int[people.length];
        HashMap<Integer, Integer> flowerMap = new HashMap<>();

        for (int i = 0; i < people.length; i++){

            int day = people[i];
            if (flowerMap.containsKey(day)){
                result[i] = flowerMap.get(day);
                continue;
            }
            int counter = 0;
            int index = 0;
            while (index < flowers.length && flowers[index][0] <= day){
                if (flowers[index][1] >= day){
                    counter++;
                }
                index++;
            }
            result[i] = counter;
            flowerMap.put(day, counter);
        }

        return result;
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {


        return null;
    }

    @Test
    public void test(){

        Assert.assertEquals(fullBloomFlowers(new int[][]{{1,6},{3,7},{9,12},{4,13}}, new int[]{2,3,7,11}), new int[]{1,2,2,2});
        Assert.assertEquals(fullBloomFlowers(new int[][]{{1,10},{3,3}}, new int[]{3,3,2}), new int[]{2,2,1});


    }

}
