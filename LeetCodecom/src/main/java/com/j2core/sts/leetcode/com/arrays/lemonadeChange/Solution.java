package com.j2core.sts.leetcode.com.arrays.lemonadeChange;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean lemonadeChange(int[] bills) {

        int[] change = new int[2];
        int sum = 0;

        for (int bill : bills){

            if (bill - 5 > sum){
                return false;
            }else {

                switch (bill) {
                    case 20:
                        if (change[0] > 0 && change[1] > 0) {
                            change[0] = change[0] - 1;
                            change[1] = change[1] - 1;
                        }else if (change[0] > 2){
                            change[0] = change[0] - 3;
                        }else return false;
                        break;

                    case 10:
                        if (change[0] > 0) {
                            change[0] = change[0] - 1;
                            change[1] = change[1] + 1;
                        } else return false;
                        break;

                    default:
                        change[0] = change[0] + 1;
                        break;

                }
                sum = sum + 5;
            }

        }

        return true;
    }


    @Test
    public void test(){

        boolean result = lemonadeChange(new int[]{5,5,10,10,20});
        Assert.assertFalse(result);

        Assert.assertTrue(lemonadeChange(new int[]{5,5,10,20}));

        Assert.assertTrue(lemonadeChange(new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5}));

    }

}
