package com.j2core.sts.leetcode.com;

import org.testng.Assert;

import java.util.*;

public class Test {

    public int findUnsortedSubarray(int[] nums) {

        int indexStart = 0;
        int numStart = nums[0];
        int indexEnd = nums.length-1;
        int numEnd = nums[indexEnd];

        while (indexStart+1 < nums.length && nums[indexStart+1] > nums[indexStart]){
            indexStart++;
            numStart = nums[indexStart];
        }

        if (indexStart == nums.length-1) return 0;

        for (int i = indexStart+1; i < nums.length; i++){

            if (nums[i] < numStart){
                if (indexStart == 0){
                    break;
                }else {
                    i--;
                    indexStart--;
                    numStart = nums[indexStart];
                }
            }
        }

        while (indexEnd > indexStart && nums[indexEnd-1] < nums[indexEnd]){
            indexEnd--;
            numEnd = nums[indexEnd];
        }

        for (int j = indexEnd-1; j > indexStart; j--){

            if (nums[j] > numEnd) {
                if (indexEnd == nums.length - 1) {
                    break;
                } else {
                    j++;
                    indexEnd++;
                    numEnd = nums[indexEnd];
                }
            }
        }

        return indexEnd-indexStart-1;
    }



    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        int i;
        for (i = 0; i< nums.length; i++){
            if (nums[i] != i){
                break;
            }
        }

        return i;
    }

    @org.testng.annotations.Test
    public void test(){

        Assert.assertEquals(findUnsortedSubarray(new int[]{2,1}), 0);

    }

}


