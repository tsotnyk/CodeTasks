package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

public class MicrosoftOASolution {

    public void sortColors(int[] nums) {

        if (nums.length < 2) return;

        int red = 0;
        int white = 0;

        for (int num : nums){
            if (num == 0){
                red++;
                continue;
            }
            if (num == 1){
                white++;
            }
        }

        int index = 0;

        while (red-- > 0){
            nums[index++] = 0;
        }
        while (white-- > 0){
            nums[index++] = 1;
        }
        while(index < nums.length){
            nums[index++] = 2;
        }
    }

    @Test
    public void testSortColors(){

        int[] array = new int[]{2,0,2,1,1,0};
        sortColors(array);
        Assert.assertArrayEquals(array, new int[]{0,0,1,1,2,2});
    }

}
