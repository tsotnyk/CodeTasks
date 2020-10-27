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
        while (indexNext-1 > -1 && heights[indexNext-1] <= heights[indexNext]){
            indexNext--;
        }

        if (heights[indexNext] < heights[index]){
            heights[indexNext] += 1;
            return true;
        }
        return false;
    }

    private boolean dropWaterRight(int[] heights, int index){

        int indexNext = index;
        while (indexNext+1 < heights.length && heights[indexNext+1] <= heights[indexNext]){
            indexNext++;
        }

        if (heights[indexNext] < heights[index]){
            heights[indexNext] += 1;
            return true;
        }
        return false;
    }

    @Test
    public void test(){

//        Assert.assertEquals(pourWater(new int[]{1,2,3,4,3,2,1,2,3,4,3,2,1},5, 5), new int[]{1,2,3,4,3,4,3,3,3,4,3,2,1});
//
//        Assert.assertEquals(pourWater(new int[]{3,1,3}, 5, 1), new int[]{4,4,4});
//        Assert.assertEquals(pourWater(new int[]{2,1,1,2,1,2,2}, 4, 3), new int[]{2,2,2,3,2,2,2});
        Assert.assertEquals(pourWater(new int[]{1,2,3,4}, 2, 2), new int[]{2,3,3,4});

    }
}
