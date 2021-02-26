package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class AppleOASolution2 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        int[] list = new int[nums.length+1];

        for (int num : nums){
            list[num] += 1;
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 1; i < list.length; i++){
            if (list[i] == 0) result.add(i);
        }

        return result;
    }

    public boolean isPowerOfTwo(int n) {

        if (n == 1) return true;
        while (n > 1){
            if (n%2 != 0) return false;
            n = n/2;
        }

        return n == 1;
    }

    @Test
    public void test(){

        Assert.assertTrue(isPowerOfTwo(8));
    }
}
