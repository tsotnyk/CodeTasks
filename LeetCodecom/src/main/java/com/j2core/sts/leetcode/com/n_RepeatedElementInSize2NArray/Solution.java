package com.j2core.sts.leetcode.com.n_RepeatedElementInSize2NArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int repeatedNTimes(int[] A) {

        int N = A.length/2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : A){

            if (map.containsKey(num)){
                return num;
            }else {
                map.put(num, 1);
            }
        }

        return 0;
    }
}
