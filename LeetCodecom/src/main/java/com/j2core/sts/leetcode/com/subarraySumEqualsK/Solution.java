package com.j2core.sts.leetcode.com.subarraySumEqualsK;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int subarraySumOld(int[] nums, int k) {

        if (nums.length < 2){
            if(nums[0] == k){
                return 1;
            }else return 0;
        }else {

            int counter = 0;

            for (int i = 0; i < nums.length; i++ ) {

                int sum = 0;

                for (int index = i; index < nums.length; index++) {

                    sum += nums[index];

                    if (sum == k) counter++;

                }
            }

            return counter;
        }
    }

    public int subarraySum(int[] nums, int k) {

        int counter = 0;
        int sum = 0;
        LinkedList<Integer> sumList = new LinkedList<>();
        sumList.add(0);

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            sumList.add(sum);
        }

        int delta = 0;

        while (!sumList.isEmpty()){
            delta += sumList.removeFirst()-delta;
            for (int num : sumList){
                if (num-delta == k){
                    counter++;
                }
            }
        }

        return counter;
    }

    @Test
    public void test(){

        int result = subarraySum(new int[]{-10,0,0}, 0);

        Assert.assertTrue(result == 3);

        int result1 = subarraySum(new int[]{28, 54, 7, -70, 22, 65, -6}, 100);

        Assert.assertTrue(result1 == 1);

    }
}
