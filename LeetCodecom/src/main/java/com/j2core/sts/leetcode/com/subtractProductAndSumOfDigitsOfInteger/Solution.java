package com.j2core.sts.leetcode.com.subtractProductAndSumOfDigitsOfInteger;

public class Solution {

    public int subtractProductAndSumWithString(int n) {

        int[] nums = revertNumToNumArray(n);
        int digits = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++){

            digits *= nums[i];
            sum += nums[i];
        }

        return digits - sum;
    }

    private int[] revertNumToNumArray(int num){

        String number = String.valueOf(num);
        int[] result = new int[number.length()];

        for(int i = 0; i < number.length(); i++){
            result[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }

        return result;
    }

    public int subtractProductAndSum(int n) {

        int sum = 0;
        int digits = 1;

        while (n > 0) {
            int num = n % 10;
            sum += num;
            digits *= num;
            n = n /10;
        }
        return digits - sum;

    }
}
