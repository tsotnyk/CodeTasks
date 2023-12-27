package com.j2core.sts.leetcode.com.fibonacciNumber;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Solution1 {

    public int fib(int n) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1,1);

        for (int i = 2; i <= n; i++){
            map.put(i, map.get(i-1)+map.get(i-2));
        }

        return map.get(n);
    }

    @Test
    public void test(){

        Assert.assertEquals(fib(2), 1);
    }
}
