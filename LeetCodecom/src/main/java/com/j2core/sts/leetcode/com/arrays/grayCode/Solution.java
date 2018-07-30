package com.j2core.sts.leetcode.com.arrays.grayCode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> grayCode(int n) {

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++)
            result.add(i ^ i>>1);
        return result;
    }


    @Test
    public void test(){

        List<Integer> result = grayCode(2);

        Assert.assertEquals(result.size(), 4);


        List<Integer> result1 = grayCode(0);

        Assert.assertEquals(result1.size(), 1);

    }

}
