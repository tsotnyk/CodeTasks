package com.j2core.sts.leetcode.com.sum.twoSumII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public int[] twoSum(int[] numbers, int target) {


        int iL = 0;
        int iR = numbers.length-1;

        while (iL < iR){

            int sum = numbers[iL]+numbers[iR];
            if (sum == target) break;
            if (sum < target){
                iL++;
            }else iR--;
        }

        return new int[]{iL+1, iR+1};
    }

    @Test
    public void test(){

        Assert.assertEquals(twoSum(new int[]{2,7,11,15}, 9), new int[]{1,2});
    }
}
