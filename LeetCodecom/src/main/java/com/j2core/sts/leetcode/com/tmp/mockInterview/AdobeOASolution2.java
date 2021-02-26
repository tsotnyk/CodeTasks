package com.j2core.sts.leetcode.com.tmp.mockInterview;

import java.util.Arrays;

public class AdobeOASolution2 {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i+2){
            sum += nums[i];
        }
        return sum;
    }

    public int reverse(int x) {

        if (x == Integer.MIN_VALUE) return 0;
        if (Math.abs(x) < 10) return x;
        boolean negative = false;
        if (x < 0) {
            x *= -1;
            negative = true;
        }
        while (x%10 == 0){
            x /= 10;
        }
        StringBuilder builder = new StringBuilder(String.valueOf(x));
        long revers = Long.parseLong(builder.reverse().toString());

        if (revers > Integer.MAX_VALUE) return 0;

        return negative ? (int)revers*-1 : (int)revers;
    }
}
