package com.j2core.sts.leetcode.com.arrays.rankTransformOfArray;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] arrayRankTransform(int[] arr) {

        int[] copyArray = arr.clone();
        Arrays.sort(copyArray);

        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int counter = 1;
        for (int j : copyArray) {
            if (!rankMap.containsKey(j)) {
                rankMap.put(j, counter++);
            }
        }

        int[] rankArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            rankArray[i] = rankMap.get(arr[i]);
        }

        return rankArray;
    }
}
