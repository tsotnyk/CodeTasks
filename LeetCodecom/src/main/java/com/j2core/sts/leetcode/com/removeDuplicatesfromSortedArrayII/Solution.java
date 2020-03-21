package com.j2core.sts.leetcode.com.removeDuplicatesfromSortedArrayII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int removeDuplicates(int[] nums) {

        int index = 0;
        int num;
        int counter;

        for (int i = 0; i < nums.length;){

            num = nums[i++];
            counter = 1;

            while (i < nums.length && nums[i] == num){
                i++;
                counter++;
            }

            counter = counter > 2 ? 2 : counter;

            while (counter-- > 0){
                nums[index++] = num;
            }
        }

        return index;
    }

    @Test
    public void test(){

        Assert.assertEquals(removeDuplicates(new int[]{1,1,1,2,2,3,4,4,4,5,5}), 9);

    }
}
