package com.j2core.sts.leetcode.com.arrays.singleNumberII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums){

            int value = map.getOrDefault(num, 0);
            if (value == 2){
                map.remove(num);
            }else {
                map.put(num, value + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());

        return list.get(0);
    }
}
