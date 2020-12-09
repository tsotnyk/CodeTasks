package com.j2core.sts.leetcode.com.pourWater;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int[] pourWater(int[] heights, int V, int K) {

        if (V == 0) return heights;

        while (V-- > 0){
            if (dropWaterLeft(heights, K)){
                continue;
            }else if (dropWaterRight(heights, K)){
                continue;
            }else {
                heights[K] += 1;
            }
        }

        return heights;
    }

    private boolean dropWaterLeft(int[] heights, int index){

        int indexNext = index;
        if (indexNext < 0) return false;

        int delta = 1;
        while (indexNext-delta > -1 && heights[indexNext-delta] <= heights[indexNext]){
            if (heights[indexNext-delta] < heights[indexNext]){
                indexNext = indexNext-delta;
                delta = 1;
            }else {
                delta++;
            }
        }
        if (heights[index] == heights[indexNext]) return false;

            heights[indexNext] += 1;
            return true;

    }

    private boolean dropWaterRight(int[] heights, int index){

        int indexNext = index;
        if (indexNext == heights.length) return false;

        int delta = 1;
        while (indexNext+delta < heights.length && heights[indexNext+delta] <= heights[indexNext]){
            if (heights[indexNext+delta] < heights[indexNext]){
                indexNext = indexNext+delta;
                delta = 1;
            }else {
                delta++;
            }
        }

        if (heights[index] == heights[indexNext]) return false;

            heights[indexNext] += 1;
            return true;
    }

    @Test
    public void test(){

        Assert.assertEquals(pourWater(new int[]{1,2,3,4,3,2,1,2,3,4,3,2,1},5, 5), new int[]{1,2,3,4,3,4,3,3,3,4,3,2,1});

        Assert.assertEquals(pourWater(new int[]{3,1,3}, 5, 1), new int[]{4,4,4});
        Assert.assertEquals(pourWater(new int[]{2,1,1,2,1,2,2}, 4, 3), new int[]{2,2,2,3,2,2,2});
        Assert.assertEquals(pourWater(new int[]{1,2,3,4}, 2, 2), new int[]{2,3,3,4});

    }
}
