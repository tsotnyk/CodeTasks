package com.j2core.sts.leetcode.com.distinctNumbersInEachSubarray;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public int[] distinctNumbers(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[nums.length-k+1];
        for (int i = 0; i < k; i++){
            int value = nums[i];
            set.add(value);
            map.put(value, map.getOrDefault(value, 0)+1);
        }
        int i = 0;
        result[i++] = set.size();

        while (i+k <= nums.length){
            int valueOld = nums[i-1];
            int valueNew = nums[i+k-1];
            if (valueNew != valueOld){
                int count = map.get(valueOld);
                if (count == 1){
                    set.remove(valueOld);
                }
                map.put(valueOld, count-1);
                set.add(valueNew);
                map.put(valueNew, map.getOrDefault(valueNew, 0)+1);
            }
            result[i] = set.size();
            i++;
        }

        return result;
    }

    public int[] distinctNumbersArray(int[] nums, int k) {
        int [] result = new int[nums.length - k + 1];
        int [] map = new int[(int)1e5 + 1];

        int index = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(map[nums[i]]++ == 0) count++;
            if(i >= k){
                if(--map[nums[i - k]] == 0) count--;
            }
            if(i >= k - 1){
                result[index++] = count;
            }
        }
        return result;
    }

    @Test
    public void test(){

        Assert.assertArrayEquals(distinctNumbers(new int[]{1,2,3,2,2,1,3}, 3), new int[]{3,2,2,2,3});
        Assert.assertArrayEquals(distinctNumbers(new int[]{1,1,1,1,2,3,4}, 4), new int[]{1,2,3,4});

    }
}
