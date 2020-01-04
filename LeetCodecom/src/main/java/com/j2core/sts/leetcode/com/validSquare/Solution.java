package com.j2core.sts.leetcode.com.validSquare;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> collection = new HashMap<>();
        collection.put(dist(p1, p2), collection.getOrDefault(dist(p1, p2), 0) + 1);
        collection.put(dist(p1, p3), collection.getOrDefault(dist(p1, p3), 0) + 1);
        collection.put(dist(p1, p4), collection.getOrDefault(dist(p1, p4), 0) + 1);
        collection.put(dist(p2, p3), collection.getOrDefault(dist(p2, p3), 0) + 1);
        collection.put(dist(p2, p4), collection.getOrDefault(dist(p2, p4), 0) + 1);
        collection.put(dist(p3, p4), collection.getOrDefault(dist(p3, p4), 0) + 1);
        if(collection.size() != 2) {
            return false;
        }
        for (int val : collection.values()) {
            if (val != 2 && val != 4) {
                return false;
            }
        }
        List<Integer> distVal = new ArrayList<>();
        for (int key : collection.keySet()) {
            distVal.add(key);
        }
        int longer = Math.max(distVal.get(0), distVal.get(1));
        int shorter = Math.min(distVal.get(0), distVal.get(1));
        return shorter + shorter == longer;
    }

    int dist(int[] p1, int[] p2) {
        return (p1[0] - p2[0])* (p1[0] - p2[0]) + (p1[1] - p2[1])* (p1[1] - p2[1]);
    }

    @Test
    public void test(){

        Assert.assertTrue(validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{0,1}, new int[]{1,0}));
        Assert.assertTrue(validSquare(new int[]{0,0}, new int[]{-3,3}, new int[]{0,6}, new int[]{3,3}));

    }
}
