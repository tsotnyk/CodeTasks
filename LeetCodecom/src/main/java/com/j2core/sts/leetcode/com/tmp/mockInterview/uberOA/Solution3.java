package com.j2core.sts.leetcode.com.tmp.mockInterview.uberOA;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int[] result = new int[arr1.length];
        int index = 0;

        for (int num : arr2){
            int count = map.remove(num);
            while (count-- > 0){
                result[index++] = num;
            }
        }
        List<Integer> numbers = new LinkedList<>(map.keySet());
        Collections.sort(numbers);

        for (int num : numbers){
            int count = map.remove(num);
            while (count-- > 0){
                result[index++] = num;
            }
        }

        return result;
    }

    @Test
    public void test1(){

        Assert.assertArrayEquals(new int[]{2,42,38,0,43,21,5,7,12,12,13,23,24,24,27,29,30,31,33,48}, relativeSortArray(new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31}, new int[]{2,42,38,0,43,21}));

        Assert.assertArrayEquals(new int[]{2,2,2,1,4,3,3,9,6,7,19}, relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6}));
    }

}
