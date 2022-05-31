package com.j2core.sts.leetcode.com.tmp.mockInterview.uberOA;


import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class UberOASolution1 {

    public List<Integer> pancakeSort(int[] arr) {

        return null;
    }

    public int findUnsortedSubarray(int[] nums) {

        if (nums.length  < 2) return 0;
        int indexSort = 0;
        int index = 1;

        while (index < nums.length && indexSort > -1){
            if (nums[indexSort] <= nums[index]){
                if (indexSort+1 == index){
                    indexSort++;
                }
                index++;
            }else {
                indexSort--;
            }
        }

        if (indexSort == nums.length-1) return 0;
        index = nums.length-1;
        int indexEnd = index--;
        while (index > -1 && indexEnd < nums.length){
            if (nums[index] <= nums[indexEnd]){
                if (index == indexEnd-1){
                    indexEnd--;
                }
                index--;
            }else {
                indexEnd++;
            }
        }

        return indexEnd - (indexSort+1);
    }

    @Test
    public void test1(){

        Assert.assertEquals(findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}), 5);
        Assert.assertEquals(findUnsortedSubarray(new int[]{5,6,4,8,10,9,15}), 6);
        Assert.assertEquals(findUnsortedSubarray(new int[]{2,6,4,8,10,9,1}), 7);
        Assert.assertEquals(findUnsortedSubarray(new int[]{2,3,4,5}), 0);


    }


    public List<Integer> pancakeSort1(int[] arr) {

        if (arr.length < 2) return new LinkedList<>();

        return  null;

    }
}
