package com.j2core.sts.leetcode.com.arrays.canPlaceFlowers;

public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int counterFreeSpace = 1;
        int counterFlowerSpace = 0;

        for (int i = 0; i < flowerbed.length; i++){

            if (flowerbed[i] == 0){
                counterFreeSpace++;
                if (counterFreeSpace == 3){
                    counterFlowerSpace++;
                    counterFreeSpace = 1;
                }
            }else {
                counterFreeSpace = 0;
            }

            if (i == flowerbed.length-1){
                if (counterFreeSpace == 2){
                    counterFlowerSpace++;
                }
            }

        }

        return n <= counterFlowerSpace;
    }
}
