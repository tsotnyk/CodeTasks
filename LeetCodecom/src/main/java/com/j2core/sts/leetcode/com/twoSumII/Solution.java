package com.j2core.sts.leetcode.com.twoSumII;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int length = numbers.length;
        int[] result = new int[2];

        for (int i = length-1; i > 0 ; i--){

                int secondNum = target - numbers[i];

                for (int j = 0; j < i; j++){
                    int num = numbers[j];
                    if (num == secondNum){

                        result[0] = j+1;
                        result[1] = i+1;
                        return result;

                    }else if (num > secondNum){
                        break;
                    }

                }

            }

        return result;

    }
}
