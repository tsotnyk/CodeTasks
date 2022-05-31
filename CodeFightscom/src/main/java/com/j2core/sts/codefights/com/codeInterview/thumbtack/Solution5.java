package com.j2core.sts.codefights.com.codeInterview.thumbtack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution5 {

    int[] priceSuggestion(int[] contractData) {

        if (contractData.length < 2 || contractData.length%2 != 0) return new int[0];

        Arrays.sort(contractData);

        int half = (contractData.length/2);
        int delta = half/2;
        int[] result = new int[2];

        if (half%2 != 0) {
            result[0] = contractData[delta];
            result[1] = contractData[contractData.length-delta-1];
        }else {
            result[0] = (contractData[delta]+contractData[delta-1])/2;
            int sum = contractData[contractData.length-delta]+contractData[contractData.length-delta-1];
            if (sum%2 == 0){
                sum /= 2;
            }else {
                sum  = (sum/2)+1;
            }
            result[1] = sum;
        }
        return result;
    }

    @Test
    public void test(){

        Assert.assertArrayEquals(new int[]{2,7}, priceSuggestion(new int[]{1, 5, 6, 3, 2, 4, 7, 8}));
    }
}
