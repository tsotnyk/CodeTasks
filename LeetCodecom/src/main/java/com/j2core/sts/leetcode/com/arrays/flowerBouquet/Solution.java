package com.j2core.sts.leetcode.com.arrays.flowerBouquet;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxProfitFlowersShop(int p, int q, int[] array){

        int[] matrix = new int[array.length+1];

        for (int i = 2; i <= array.length; i++){

            if ((array[i-1] == 1 && array[i-2] == 0) || (array[i-1] == 0 && array[i-2] == 1)){
                matrix[i] = Math.max(q+matrix[i-2], matrix[i-1]);
            }else {
                if (i > 2 && array[i-1] == 0 && array[i-2] == 0 && array[i-3] == 0){
                    matrix[i] = Math.max(p+matrix[i-3], matrix[i-1]);
                }
            }
        }

        return matrix[array.length];
    }

    @Test
    public void test(){

        Assert.assertEquals(maxProfitFlowersShop(2,3,new int[]{0,0,0,1,0,0,0}), 5);

    }
}
