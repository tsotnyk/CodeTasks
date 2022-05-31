package com.j2core.sts.leetcode.com.maximumUnitsOnaTruck;

import java.util.Arrays;

public class Solution {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (t1, t2) -> {
            return t2[1] - t1[1];
        });

        int index = 0;
        int counter = 0;

        while (index < boxTypes.length && truckSize > 0){

            int boxes = boxTypes[index][0];
            int units = boxTypes[index][1];
            index++;

            if (boxes <= truckSize){
                truckSize = truckSize - boxes;
                counter += boxes*units;
            }else {
                counter += truckSize*units;
                truckSize = 0;
            }
        }

        return counter;
    }
}
