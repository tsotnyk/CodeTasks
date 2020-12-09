package com.j2core.sts.leetcode.com.addToArrayFormOfInteger;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> addToArrayForm(int[] A, int K) {

        int delta = K;
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = A.length-1; i > -1; i--){
            int sum = delta + A[i];
            result.addFirst(sum%10);
            delta = (sum-result.getFirst())/10;
        }

        if (delta != 0){

            while (delta > 0){
                result.addFirst(delta%10);
                delta = (delta-result.getFirst())/10;
            }
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(addToArrayForm(new int[]{1,2,0,0}, 34), new LinkedList<>(Arrays.asList(1,2,3,4)));
        Assert.assertEquals(addToArrayForm(new int[]{9,9,9,9}, 1), new LinkedList<>(Arrays.asList(1,0,0,0,0)));

    }
}
