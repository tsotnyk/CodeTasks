package com.j2core.sts.leetcode.com.max.maximumSwap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution1 {

    public int maximumSwap(int num) {

        char[] number = String.valueOf(num).toCharArray();

        for(int i = 0; i < number.length-1; i++){
            int cand = i+1;
            for (int j = cand+1; j < number.length; j++){
                if (number[j] >= number[cand]){
                    cand = j;
                }
            }
            if (number[i] < number[cand]){
                char tmp = number[i];
                number[i] = number[cand];
                number[cand] = tmp;
                break;
            }
        }

        return Integer.parseInt(new String(number));
    }

    @Test
    public void test(){
        Assert.assertEquals(maximumSwap(1993), 9913);

        Assert.assertEquals(maximumSwap(98368), 98863);
    }
}
