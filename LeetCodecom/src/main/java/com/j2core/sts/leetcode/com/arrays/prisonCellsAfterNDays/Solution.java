package com.j2core.sts.leetcode.com.arrays.prisonCellsAfterNDays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int[] prisonAfterNDays(int[] cells, int N) {

        N = (N-1) % 14 +1;
        int[] nextDay;
        while (N-- > 0){
            nextDay = new int[8];
            for (int i = 1; i < 7; i++){
                if (cells[i-1] != cells[i+1]){
                    nextDay[i] = 0;
                }else{
                    nextDay[i] = 1;
                }
            }
            cells = nextDay;
        }

        return cells;
    }

    @Test
    public void test(){

        int[] root = new int[]{0,1,0,1,1,0,0,1};
        int[] result = prisonAfterNDays(root, 7);

        Assert.assertEquals(result, root);
    }
}
