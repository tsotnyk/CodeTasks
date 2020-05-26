package com.j2core.sts.leetcode.com.tripleByte;

public class Solution21 {

    public static int longest_flat(int[] array){

        if (array == null || array.length < 1) return 0;
        if (array.length == 1) return 1;

        int max = 1;
        int index = 0;
        int num = array[index++];
        int counter = 1;

        while (index < array.length){

            while (index < array.length && num == array[index]){
                counter++;
                index++;
            }
            max = Math.max(max, counter);
            counter = 1;
            if (index < array.length){
                num = array[index++];
            }
        }
        return max;
    }
}
