package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

public class AppleOASolution3 {

    public int removeElement(int[] nums, int val) {

        int indexPut = 0;
        int index = 0;
        int counter = 0;
        while (index < nums.length){
            if (nums[index] == val){
                index++;
            }else {
                counter++;
                nums[indexPut++] = nums[index++];
                while (indexPut < index){
                    if(nums[indexPut] != val){
                        indexPut++;
                    }else {
                        break;
                    }
                }
            }
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2), 5);
    }

}
