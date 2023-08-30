package com.j2core.sts.leetcode.com.dotProductOfTwoSpareVectors;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SparseVector {

    List<Integer> indexs;
    HashMap<Integer, Integer> valueMap;
    public SparseVector(int[] nums) {

        this.indexs = new LinkedList<>();
        this.valueMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                this.valueMap.put(i, nums[i]);
                this.indexs.add(i);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {

        int sum = 0;

        for (int index: vec.indexs){
            sum += vec.valueMap.get(index) * this.valueMap.getOrDefault(index, 0);
        }

        return sum;
    }
}
