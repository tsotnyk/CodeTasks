package com.j2core.sts.leetcode.com.arrays.checkIfNandItsDoubleExist;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    public boolean checkIfExist(int[] arr) {

        HashMap<Integer, List<Integer>> set = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if (set.containsKey(arr[i])){
                set.get(arr[i]).add(i);
            }else {
                set.put(arr[i], new LinkedList<>(Collections.singletonList(i)));
            }
        }

        for (int j = 0; j < arr.length; j++){
            int sum = arr[j]*2;
            if (set.containsKey(sum)){
                List<Integer> indexes = set.get(sum);
                if (indexes.size() > 1) return true;
                if (indexes.size() == 1 && indexes.get(0) != j){
                    return true;
                }
            }
        }

        return false;
    }

    @Test
    public void test(){

        Assert.assertTrue(checkIfExist(new int[]{-20,8,-6,-14,0,-19,14,4}));
        Assert.assertFalse(checkIfExist(new int[]{-2,0,10, -19,4,6,-8}));
        Assert.assertTrue(checkIfExist(new int[]{0,0}));
    }
}
