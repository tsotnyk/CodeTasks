package com.j2core.sts.leetcode.com.replaceElementsWithGreatestElementOnRightSide;

public class Solution {

    public int[] replaceElements(int[] arr) {

        int length = arr.length;
        int maxNum = arr[length-1];
        int[] result = new int[length];
        result[length-1] = -1;

        for (int i = length-2; i > -1; i--){

            result[i] = maxNum;
            if (arr[i] > maxNum){
                maxNum = arr[i];
            }
        }

        return result;
    }
}
