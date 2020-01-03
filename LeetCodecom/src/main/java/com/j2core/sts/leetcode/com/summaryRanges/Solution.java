package com.j2core.sts.leetcode.com.summaryRanges;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> summaryRanges(int[] nums) {

            List<String> result = new LinkedList<>();

            if (nums.length < 1) return result;
            String symbol = "->";
            int first = nums[0];
            int last = nums[0];
            int index = 1;

            while (index < nums.length){

                if (nums[index] > last+1){
                    if (first == last){
                        result.add(String.valueOf(first));
                    }else {
                        result.add(first + symbol + last);
                    }
                    first = nums[index];
                    last = first;
                }else {
                    last = nums[index];
                }
                index++;
            }
            if (first == last){
                result.add(String.valueOf(first));
            }else {
                result.add(first + symbol + last);
            }

            return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(summaryRanges(new int[]{0,1,2,4,5,7}).size(), 3);
        Assert.assertEquals(summaryRanges(new int[]{-2147483648,-2147483647,2147483647}).size(), 2);

    }
}
