package com.j2core.sts.leetcode.com.majorityElementII;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> result = new LinkedList<>();
        if (nums == null) return null;
        if (nums.length < 2){

            for (int num : nums){

                result.add(num);
            }
            return result;
        }else {

            Arrays.sort(nums);

            int minNum = nums.length/3;

            for (int i = 0; i < nums.length; ){

                int num = nums[i];
                i++;
                int counter = 1;
                while (i < nums.length && num == nums[i]){

                    i++;
                    counter++;

                }

                if (counter > minNum){

                    result.add(num);
                }
            }

            return result;
        }

    }


    @Test
    public void test(){

        majorityElement(new int[]{2,2});

    }
}
