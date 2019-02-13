package com.j2core.sts.leetcode.com.countingBits;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int[] countBits(int num) {

        int[] result = new int[num+1];

        for(int i =1; i<=num; i++){

            if(i%2==0){
                result[i]=result[i/2];
            }else{
                result[i] = result[i-1]+1;
            }
        }


        return result;
    }

    @Test
    public void test(){

        int[] result = countBits(5);

        Assert.assertEquals(result, new int[]{0,1,1,2,1,2});

    }
}
