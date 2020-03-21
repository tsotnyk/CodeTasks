package com.j2core.sts.leetcode.com.climbingStairs;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int climbStairs(int n) {

        int[] arr = new int[n];
        if(n <= 3) return n;
        arr[0]=1;
        arr[1]=2;

        for(int i=2; i<n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n-1];
    }

    @Test
    public void test(){

        Assert.assertEquals(climbStairs(3), 3);
    }
}
