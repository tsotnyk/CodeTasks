package com.j2core.sts.leetcode.com.dotProductOfTwoSpareVectors;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SparseVector2 {

    HashMap<Integer, Integer> map;
    List<Integer> list;

    public SparseVector2(int[] nums) {

        this.list = new LinkedList<>();
        this.map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                this.map.put(i, nums[i]);
                this.list.add(i);
            }
        }
    }

    public int dotProduct(SparseVector2 vec) {

        int sum = 0;
        for (int index : vec.list){
            sum += vec.map.get(index)*this.map.getOrDefault(index, 0);
        }

        return sum;
    }

}
