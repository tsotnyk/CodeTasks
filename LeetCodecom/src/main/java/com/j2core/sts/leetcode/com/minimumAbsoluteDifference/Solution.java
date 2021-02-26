package com.j2core.sts.leetcode.com.minimumAbsoluteDifference;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> resultList = null;

        for (int i = 0; i < arr.length-1; i++){
            for (int j = i+1; j < arr.length; j++){
                int diff = Math.abs(arr[i]-arr[j]);
                if (diff <= minDiff){
                    if (diff < minDiff) {
                        resultList = new LinkedList<>();
                    }
                    List<Integer> pair = new LinkedList<>();
                    pair.add(arr[i]);
                    if (arr[i] > arr[j]){
                        pair.add(0, arr[j]);
                    }else {
                        pair.add(arr[j]);
                    }
                    resultList.add(pair);
                    minDiff = diff;
                }else {
                    break;
                }
            }
        }

        return resultList;
    }
}
