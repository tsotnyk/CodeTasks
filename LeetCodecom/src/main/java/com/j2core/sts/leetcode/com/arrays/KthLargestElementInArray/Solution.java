package com.j2core.sts.leetcode.com.arrays.KthLargestElementInArray;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int findKthLargest(int[] nums, int k) {

        int[] largestArray = new int[k];
        largestArray[0] = nums[0];
        int index = 1;

        for (int i = 1; i < nums.length; i++){

            boolean flag = true;

            for (int j = 0; j < index; j++){

                if (nums[i] > largestArray[j]){

                    if (j < k-1){

                        System.arraycopy(largestArray, j, largestArray, j+1, k-j-1);
                    }

                    largestArray[j] = nums[i];
                    flag = false;
                    if (index < k) index++;
                    break;

                }
            }

            if (flag && index < k){
                largestArray[index] = nums[i];
                index++;
            }
        }

        return largestArray[k-1];
    }


    @Test
    public void test(){

        int result = findKthLargest(new int[]{7,6,5,4,3,2,1}, 2);

        Assert.assertEquals(6, result);

    }
}
