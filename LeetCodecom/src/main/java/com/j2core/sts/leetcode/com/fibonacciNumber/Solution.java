package com.j2core.sts.leetcode.com.fibonacciNumber;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Solution {

    public int fib(int N) {

        if (N == 0) return 0;
        ArrayList<Integer> fibNumbers = new ArrayList<>();
        fibNumbers.add(0);
        if (N == 1) return 1;
        fibNumbers.add(1);
        int size = 2;
        int num = 2;

        while (num++ < N){
            fibNumbers.add(fibNumbers.get(size-1) + fibNumbers.get(size-2));
            size++;
        }
        return fibNumbers.get(size-1)+fibNumbers.get(size-2);

    }

    @Test
    public void test(){

        Assert.assertEquals(fib(2), 1);
        Assert.assertEquals(fib(0), 0);
        Assert.assertEquals(fib(1), 1);
        Assert.assertEquals(fib(3), 2);
        Assert.assertEquals(fib(4), 3);


    }
}
