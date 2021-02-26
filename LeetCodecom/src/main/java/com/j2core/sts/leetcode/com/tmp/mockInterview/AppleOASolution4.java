package com.j2core.sts.leetcode.com.tmp.mockInterview;

import java.util.Arrays;
import java.util.HashMap;

public class AppleOASolution4 {

    public int maxNumberOfApples(int[] arr) {

        Arrays.sort(arr);
        int counter = 0;
        int sum = 5000;
        for (int weight : arr){
            sum -= weight;
            if (sum > 0){
                counter++;
            }else break;
        }

        return counter;
    }
}
