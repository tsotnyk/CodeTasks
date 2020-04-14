package com.j2core.sts.leetcode.com.arrays.lastStoneWeight;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int lastStoneWeight(int[] stones) {

        int index = stones.length-1;

        while (index > 0){

            Arrays.sort(stones);
            if (stones[index] == stones[index-1]){
                index -= 2;
            }else {
                index--;
                stones[index] = stones[index+1] - stones[index];
            }
        }

        if (index == 0) return stones[0];
        return 0;
    }

    @Test
    public void test(){


        Assert.assertEquals(lastStoneWeight(new int[]{2,7,4,1,8,1}), 1);
    }
}
