package com.j2core.sts.leetcode.com.maximumPopulationYear;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int maximumPopulation(int[][] logs) {

        int delta = 1950;
        int[] array = new int[100];

        for (int[] pair : logs){
            array[pair[0]-delta] += 1;
            array[pair[1]-delta] -= 1;
        }

        int counter = array[0];
        int result = 0;
        int max = counter;

        for (int i = 1; i < array.length; i++){
            counter += array[i];
            if (counter > max){
                max = counter;
                result = i;
            }
        }

        return result+delta;
    }

    @Test
    public void test(){

        Assert.assertEquals(maximumPopulation(new int[][]{{1950,1961},{1960,1971},{1970,1981}}), 1960);
    }
}
