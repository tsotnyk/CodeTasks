package com.j2core.sts.leetcode.com.arrays.thirdMaximumNumber;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int thirdMax(int[] nums) {

        int[] maximum = new int[3];
        int index = 0;

        for (int i = 0; i < nums.length; i++){

            if (i == 0){
                maximum[0] = nums[i];
                index++;
            }else {

                boolean flag = true;
                for (int j = 0; j < index; j++) {

                    if (maximum[j] == nums[i]){
                        flag = false;
                        break;
                    }else if (maximum[j] < nums[i]) {
                        int tmp1 = maximum[j];
                        maximum[j] = nums[i];
                        if (index < 3 && j+1 == index){
                            maximum[index] = tmp1;
                            index++;
                            flag = false;
                            break;
                        }else if (j < 2){
                            for (int k = 2 ; k > j+1; k--){
                                maximum[k] = maximum[k-1];
                            }
                            maximum[j+1] = tmp1;
                            flag = false;
                            if (index < 3) index++;
                            break;
                        }
                    }

                }
                if (flag && index < 3){
                        maximum[index] = nums[i];
                        index++;

                }
            }
        }

        return index == 3 ? maximum[2] : maximum[0];
    }


    @Test
    public void test(){

        int result = thirdMax(new int[]{5,2,4,1,3,6,0});

        Assert.assertEquals(3, result);

    }
}
