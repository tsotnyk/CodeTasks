package com.j2core.sts.leetcode.com.elementAppearingMoreThan25ProsentInSortedArray;


public class Solution {

    public int findSpecialInteger(int[] arr) {

        int length = arr.length;
        int amount = length/4;

        int num = arr[0];
        int index = 0;

        while (index < length){
            num = arr[index++];
            int count = 1;
            while (index < length && arr[index] == num){
                index++;
                count++;
                if (count > amount){
                    return num;
                }
            }
            if (count > amount){
                break;
            }
        }
        return num;
    }
}
