package com.j2core.sts.leetcode.com.arrays.triangle;

import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle.isEmpty()) return 0;
        List<Integer> sumList = null;

        for (List<Integer> list : triangle){
            if (list.size() == 1){
                sumList = list;
            }else {
                for (int i = 0; i < list.size(); i++){
                    int num = list.get(i);
                    if (i == 0){
                        list.set(i, num+sumList.get(i));
                    }else if (i == list.size()-1){
                        list.set(i, num+sumList.get(i-1));
                    }else {
                        list.set(i, Integer.min(num+sumList.get(i), num+sumList.get(i-1)));
                    }
                }
                sumList = list;
            }
        }

        int sum = Integer.MAX_VALUE;
        for (int num : sumList) {
            sum = Integer.min(sum, num);
        }
        return sum;
    }
}
