package com.j2core.sts.leetcode.com.reverseInteger;

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
    public static int reverse(int x) {

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
}
