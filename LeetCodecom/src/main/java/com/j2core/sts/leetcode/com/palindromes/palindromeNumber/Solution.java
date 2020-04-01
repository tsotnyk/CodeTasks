package com.j2core.sts.leetcode.com.palindromes.palindromeNumber;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isPalindrome(int x) {

        long num = x;

        if (x < 0) {

            return false;

        }else if (x < 10){

            return true;

        }else {

            int index = 2;

            for (long i = 100; i <= x; i = i*10){

                index++;

            }

            int[] numArray = new int[index];

            for (int j = index-1; j > -1; j--){

                long tmp = (int) Math.pow(10, j);

                for (int k = 9; k > -1; k--){

                    if (k*tmp < num){

                        numArray[j] = k;
                        num = num - (k)*tmp;
                        break;

                    }else if (k*tmp == num) {

                        numArray[j] = k;
                        num = num - k*tmp;
                        break;

                    }
                }
            }

            int firstIndex = 0;
            int lastIndex = index-1;
            while (firstIndex < lastIndex){

                if (numArray[firstIndex] != numArray[lastIndex]){

                    return false;
                }else {

                    firstIndex++;
                    lastIndex--;
                }

            }

            return true;
        }
    }



    @Test
    public void test(){

        boolean result = isPalindrome(1410110141);

        Assert.assertTrue(result);

    }
}
