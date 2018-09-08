package com.j2core.sts.leetcode.com.multiplyString;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Solution {

    public String multiply(String num1, String num2) {

        int[] array = new int[num1.length() + num2.length()];
        String small, big;

        if (num1.length() > num2.length()) {
            big = num1;
            small = num2;
        } else {
            big = num2;
            small = num1;
        }
        for (int i = small.length() - 1; i > -1; i--) {

            for (int j = big.length() - 1; j > -1; j--) {

                int sum = (small.charAt(i) - '0') * (big.charAt(j) - '0');

                int index1 = i + j;
                int index2 = i + j + 1;

                sum = sum + array[index2];

                array[index1] += sum / 10;
                array[index2] = (sum) % 10;

            }
        }

        return createString(array);
    }


    private String createString(int[] array){

        StringBuilder builder = new StringBuilder();

        for (int i  = 0 ; i < array.length; i++){

            if (!(builder.length() == 0 && array[i] == 0)) builder.append(array[i]);

        }

        return builder.length() == 0 ? "0" : builder.toString();
    }


    @Test
    public void test(){


        String result = multiply("123", "456");

        Assert.assertEquals(result, "56088");

        String result1 = multiply("123456789","987654321");

        Assert.assertEquals(result1, "121932631112635269");

    }
}
