package com.j2core.sts.leetcode.com.reverseInteger;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
   The method reverse digits of an integer.
 */
public class Solution {

    /**
     * The method reverse digits of an integer.
     *
     * @param x     number for reverse
     * @return      resulted number
     */
    public static int reverseOld(int x) {

        int result;
        Integer number = x;
        boolean negativeFlag = false;
        if (x < 0){
            negativeFlag = true;
            number = x * -1;
        }
        char[] origChars = number.toString().toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = origChars.length - 1; i > -1; i--){
            builder.append(origChars[i]);
        }
        try {
            result = Integer.parseInt(builder.toString());

        }catch (NumberFormatException ex){

            return 0;
        }

        return negativeFlag ? result*-1 : result;
    }

    public int reverse1(int x) {

        if (x == 0) return 0;
        boolean flag = x < 0;
        if (flag){
            x *= -1;
        }
        String num = String.valueOf(x);
        StringBuilder builder = new StringBuilder();
        int index = num.length()-1;

        while (num.charAt(index) == '0'){
            index--;
        }

        for (int i = index; i > -1; i--){
            builder.append(num.charAt(i));
        }

        int result;
        try {
            result = Integer.parseInt(builder.toString());
        }catch (NumberFormatException ex){
            return 0;
        }

        return flag ? result*-1 : result;
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    @Test
    public void test(){

        Assert.assertEquals(reverseNew(123), 321);
        Assert.assertEquals(reverseNew(-123), -321);
        Assert.assertEquals(reverseNew(1230), 321);

    }

    public int reverseNew(int x) {

        if(x == Integer.MIN_VALUE) return 0;
        boolean negative = x < 0;
        if (negative){
            x *= -1;
        }

        while ( x > 0 && x%10 == 0){
            x /= 10;
        }

        long newNum = x%10;
        x /=10;

        while (x > 0){
            newNum *= 10;
            newNum += x%10;
            x /= 10;
        }

        if (negative){
            newNum *= -1;
        }

        if (newNum >= Integer.MIN_VALUE && newNum <= Integer.MAX_VALUE) return (int) newNum;
        return 0;
    }
}
