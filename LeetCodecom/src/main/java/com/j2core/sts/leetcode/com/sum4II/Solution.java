package com.j2core.sts.leetcode.com.sum4II;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Long, Integer> twoSum = new HashMap<>();
        int length = A.length;

        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                long sum = A[i] + B[j];
                if (twoSum.containsKey(sum)){
                    twoSum.put(sum, twoSum.get(sum)+1);
                }else {
                    twoSum.put(sum, 1);
                }
            }
        }
        return findPair(twoSum, C, D);
    }

    private int findPair(Map<Long, Integer> map, int[] C, int[] D){

        int length = C.length;
        int counter = 0;

        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){

                long sum = (C[i] + D[j]) * -1;
                if (map.containsKey(sum)){
                    counter = counter + map.get(sum);
                }
            }
        }
        return counter;
    }
}
