package com.j2core.sts.leetcode.com.detonateMaximumBombs;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int maximumDetonation(int[][] bombs) {

        Arrays.sort(bombs, (a,b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        List<Bomb> list = new LinkedList<>();

        for (int[] data : bombs) {
            boolean flag = true;
            int xMax = data[0] + data[2];
            int xMin = data[0] - data[2];
            int yMin = data[1] - data[2];
            int yMax = data[1] + data[2];
            for (Bomb item : list) {
                if (xMin <= item.xMax && yMin <= item.yMax) {
                    item.xMin = Math.min(xMin, item.xMin);
                    item.xMax = Math.max(xMax, item.xMax);
                    item.yMin = Math.min(yMin, item.yMin);
                    item.yMax = Math.max(yMax, item.yMax);
                    item.counter += 1;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(new Bomb(xMin, xMax, yMin, yMax, 1));
            }
        }

        int max = 1;

        for (Bomb item : list){
            max = Math.max(max, item.counter);
        }

        return max;
    }

    @Test
    public void test(){

        int[][] array = new int[][]{
                {1,2,3},
                {2,3,1},
                {3,4,2},
                {4,5,3},
                {5,6,4}
        };

        Assert.assertEquals(maximumDetonation(array), 5);
    }

    class Bomb{
        int xMin;
        int xMax;
        int yMin;
        int yMax;
        int counter;

        public Bomb(int xMin, int xMax, int yMin, int yMax, int counter) {
            this.xMin = xMin;
            this.xMax = xMax;
            this.yMin = yMin;
            this.yMax = yMax;
            this.counter = counter;
        }
    }
}
