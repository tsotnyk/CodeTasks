package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

public class AdobeOASolution1 {

    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        String number = String.valueOf(x);

        int i = 0;
        int j = number.length()-1;

        while (i < j){
            if (number.charAt(i) != number.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public String addStrings(String num1, String num2) {
        int zero = '0';
        StringBuilder builder = new StringBuilder();
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        int delta = 0;
        while (index1 > -1 && index2 > -1){
            int sum = ((int)num1.charAt(index1)-zero) + ((int)num2.charAt(index2)-zero) + delta;
            if (sum > 9){
                delta = 1;
                sum = sum%10;
                builder.append((char) (sum + zero));
            }else {
                delta = 0;
                builder.append((char) (sum + zero));
            }
            index1--;
            index2--;
        }
        String num;
        int index;
        if (index1 > -1){
            num = num1;
            index = index1;
        }else {
            num = num2;
            index = index2;
        }

        while (index > -1){
            int sum = (num.charAt(index)-zero) +delta;
            if (sum > 9){
                delta = 1;
                sum = sum%10;
                builder.append((char) (sum + zero));
            }else {
                delta = 0;
                builder.append((char) (sum + zero));
            }
            index--;
        }
        if (delta > 0) builder.append('1');

        return builder.reverse().toString();
    }

    @Test
    public void test(){

        Assert.assertEquals("10001", addStrings("9999", "2"));
    }
}
