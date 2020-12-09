package com.j2core.sts.leetcode.com.string.addStrings;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public String addStrings(String num1, String num2) {

        int delta = 0;
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        int sum = 0;
        StringBuilder builder = new StringBuilder();

        while (index1 > -1 && index2 > -1){
            int first = ((int) num1.charAt(index1)-48);
            int second = ((int) num2.charAt(index2)-48);
            sum = delta + first + second;
            if (sum <= 9) {
                delta = 0;
            } else {
                delta = 1;
                sum = sum % 10;
            }
            builder.append(sum);
            index1--;
            index2--;
        }

        if (index1 > -1 || index2 > -1){
            if (num1.length() < num2.length()){
                num1 = num2;
                index1 = index2;
            }

            while (index1 > -1) {
                sum = delta + (int) num1.charAt(index1) - 48;
                if (sum <= 9) {
                    delta = 0;
                } else {
                    delta = 1;
                    sum = sum % 10;
                }
                builder.append(sum);
                index1--;
            }
        }

        if (delta > 0) builder.append(delta);
        return builder.reverse().toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(addStrings("1234567890", "987654321"), "2222222211");
    }
}
