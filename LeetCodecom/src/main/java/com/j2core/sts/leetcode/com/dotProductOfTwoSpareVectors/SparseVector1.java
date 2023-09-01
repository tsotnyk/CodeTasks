package com.j2core.sts.leetcode.com.dotProductOfTwoSpareVectors;

import java.util.HashMap;

public class SparseVector1 {

    HashMap<Integer, Integer> map;

    SparseVector1(int[] nums) {

        this.map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){

            if (nums[i] != 0){
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector1 vec) {

        int sum = 0;
        for(int key : vec.map.keySet()){

            if (this.map.containsKey(key)){
                sum += vec.map.get(key)*this.map.get(key);
            }
//            sum += vec.map.get(key)*this.map.getOrDefault(key, 0);
        }

        return sum;
    }
}
