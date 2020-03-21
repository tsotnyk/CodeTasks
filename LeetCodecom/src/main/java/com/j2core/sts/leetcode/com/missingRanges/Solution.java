package com.j2core.sts.leetcode.com.missingRanges;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> result = new LinkedList<>();

        if (nums.length == 0){
            if (lower == upper){
                result.add(String.valueOf(lower));
            }else {
                result.add((lower) + "->" + (upper));
            }
            return result;
        }

        long start = lower;
        int index = 0;
        long end;
        long tmp;

        while (index < nums.length){
            end = nums[index];
            tmp = end-start;
            if (index == 0){
                if (tmp == 1){
                    result.add(String.valueOf(start));
                }else if (tmp > 1){
                    result.add((start) + "->" + (end-1));
                }
            }else if (tmp == 2){
                result.add(String.valueOf(start+1));
            }else if (tmp > 2){
                result.add((start+1) + "->" + (end-1));
            }
            start = end;
            index++;
        }

        tmp = upper - start;
        if (tmp == 1){
            result.add(String.valueOf(upper));
        }else if (tmp > 1){
            result.add((start+1) + "->" + (upper));
        }

        return result;
    }

    @Test
    public void test(){

        List<String> result = findMissingRanges(new int[]{-2147483648,2147483647}, -2147483648, 2147483647);
    }
}
