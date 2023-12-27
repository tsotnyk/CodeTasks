package com.j2core.sts.leetcode.com.trappingRainWater;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public int trap(int[] height) {

        int res = 0;
        int iS = 0;
        int iE = 1;
        while (iE < height.length){
            if (height[iE] >= height[iE-1]){
                iE++;
                continue;
            }
            res += countWater(height, iS, iE-1, height[iS], height[iE-1]);
            iS = iE++ -1;
        }

        res += countWater(height, iS, iE, height[iS], 0);

        return res;
    }

    private int countWater(int[] height, int iS, int iE, int left, int right){

        int delta = Math.min(left, right);

        if (delta <= 0) return 0;

        int res = 0;

        for (int i = iS+1; i < iE; i++){
            res += delta - height[i];
        }

        return res;
    }

    @Test
    public void test(){

        Assert.assertEquals(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6);
    }
}
