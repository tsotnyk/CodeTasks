package com.j2core.sts.leetcode.com.frogJump;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public boolean canCross(int[] stones) {
        int length = stones.length;
        Map<Integer, Set<Integer>> map = IntStream.range(0, length).boxed().collect(Collectors.toMap(i -> stones[i], i -> new HashSet<>(), (a, b) -> b));
        map.get(0).add(0);
        IntStream.range(0, length).forEach(i -> {
            for (int k : map.get(stones[i])) {
                if (k - 1 > 0 && map.containsKey(k - 1 + stones[i])) map.get(k - 1 + stones[i]).add(k - 1);
                if (k > 0 && map.containsKey(k + stones[i])) map.get(k + stones[i]).add(k);
                if (k + 1 > 0 && map.containsKey(k + 1 + stones[i])) map.get(k + 1 + stones[i]).add(k + 1);
            }
        });
        return map.get(stones[length-1]).size()>0;
    }

    @Test
    public void test(){

        Assert.assertTrue(canCross(new int[]{0,1,3,5,6,8,12,17}));
        Assert.assertFalse(canCross(new int[]{0,1,2,3,4,8,9,11}));
        Assert.assertFalse(canCross(new int[]{0,1,3,6,7}));
    }
}
