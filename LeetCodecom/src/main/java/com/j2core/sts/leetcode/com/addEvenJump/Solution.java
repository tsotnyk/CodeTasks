package com.j2core.sts.leetcode.com.addEvenJump;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.TreeMap;

public class Solution {

    public int oddEvenJumps(int[] A) {

        int counter = 1;
        int length = A.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean[] even = new boolean[length];
        boolean[] odd = new boolean[length];
        length--;

        even[length] = true;
        odd[length] = true;
        map.put(A[length], length--);

        while (length > -1){
            int index;
            Integer key = map.ceilingKey(A[length]);
            if (key != null) {
                index = map.getOrDefault(key, -1);
                if (index > -1) {
                    if (index > length && even[index]) {
                        odd[length] = true;
                        counter++;
                    }
                }
            }

            key = map.floorKey(A[length]);
            if (key != null){
                index = map.getOrDefault(key, -1);
                if (index > -1){
                    if (index > length && odd[index]){
                        even[length] = true;
                    }
                }
            }
            map.put(A[length], length--);
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(oddEvenJumps(new int[]{10, 13, 12, 14, 15}), 2);
        Assert.assertEquals(oddEvenJumps(new int[]{2, 3, 1, 1, 4}), 3);
        Assert.assertEquals(oddEvenJumps(new int[]{5, 1, 3, 4, 2}), 3);

    }
}
