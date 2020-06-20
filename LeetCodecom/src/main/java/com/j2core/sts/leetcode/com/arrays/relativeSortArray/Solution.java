package com.j2core.sts.leetcode.com.arrays.relativeSortArray;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.TreeSet;

public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int index = 0;
        int[] sortArray = new int[arr1.length];
        int counter;

        for (int num : arr2){
            counter = map.get(num);
            while (counter-- > 0){
                sortArray[index++] = num;
            }
            map.remove(num);
        }

        TreeSet<Integer> leftNum = new TreeSet<>(map.keySet());

        for (int num : leftNum){
            counter = map.get(num);
            while (counter-- > 0) {
                sortArray[index++] = num;
            }
        }

        return sortArray;
    }

    @Test
    public void test(){

        Assert.assertNotNull(relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6}));
    }
}
