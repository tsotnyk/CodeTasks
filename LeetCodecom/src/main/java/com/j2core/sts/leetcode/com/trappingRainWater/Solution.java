package com.j2core.sts.leetcode.com.trappingRainWater;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int trap(int[] height) {

        int indexEnd = height.length-1;
        int indexStart = indexEnd-1;
        int sum = 0;

        while (indexEnd > 0){

            if (height[indexStart] < height[indexEnd]){
                while (indexStart > -1 && height[indexStart] < height[indexEnd]){
                    indexStart--;
                }
                if (indexStart > -1){
                    int minH = Integer.min(height[indexStart], height[indexEnd]);
                    for (int i = indexStart+1; i < indexEnd; i++){
                        sum += minH - height[i];
                    }
                    indexEnd = indexStart--;
                }else {
                    height[indexEnd] = height[indexEnd] -1;
                    indexStart = indexEnd-1;
                }
            }else {
                indexEnd = indexStart--;
            }
        }

        return sum;
    }

    @Test
    public void test(){

        int result = trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        Assert.assertEquals(result, 6);
    }
}
