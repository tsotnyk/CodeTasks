package com.j2core.sts.leetcode.com.arrays.putBoxesIntoWarehouseI;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {

        Arrays.sort(boxes); // Time complexity O(nLogn) where n == boxes.length, because Arrays.sort use merge sort algorithm

        // Time complexity O(m) where m == warehouse.length
        int[] maxValue = new int[warehouse.length];
        maxValue[0] = warehouse[0];
        for (int i = 1; i < maxValue.length; i++){
            maxValue[i] = Math.min(warehouse[i], maxValue[i-1]);
        }

        Arrays.sort(maxValue); // Time complexity O(mLogm) where m == warehouse.length, because Arrays.sort use merge sort algorithm

        int boxIndex = 0;
        int warehouseIndex = 0;

        // Time complexity O(m) where m == warehouse.length
        while (boxIndex < boxes.length && warehouseIndex < warehouse.length){
            if (boxes[boxIndex] <= maxValue[warehouseIndex]){
                boxIndex++;
            }
            warehouseIndex++;
        }

        // Total time complexity O(2m+mLogm+nLogn) => O(m+mLogm+nLogn);
        return boxIndex;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxBoxesInWarehouse(new int[]{4,5,6}, new int[]{3,3,3,3,3}), 0);
        Assert.assertEquals(maxBoxesInWarehouse(new int[]{1,2,3}, new int[]{1,2,3,4}), 1);
        Assert.assertEquals(maxBoxesInWarehouse(new int[]{1,2,2,3,4}, new int[]{3,4,1,2}), 3);
        Assert.assertEquals(maxBoxesInWarehouse(new int[]{4,3,4,1}, new int[]{5,3,3,4,1}), 3);

    }
}
