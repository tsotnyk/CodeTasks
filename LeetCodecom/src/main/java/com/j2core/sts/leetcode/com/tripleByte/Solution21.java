package com.j2core.sts.leetcode.com.tripleByte;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution21 {

    public static int longest_flat(int[] array){

        if (array==null || array.length == 0) return 0;
        if (array.length == 1) return 1;

        int maxSequenceLength = 1; // because if we have at least 1 number in array, max=1
        int currentSequenceLength = 0;
        int currentSequenceNumber = 0; // even if we have leading zero in array, currentSequenceLength is set to 0

        for (int number : array) {
            if (currentSequenceNumber == number) {
                currentSequenceLength++;
                if (currentSequenceLength > maxSequenceLength) {
                    maxSequenceLength = currentSequenceLength;
                }
            } else {
                currentSequenceNumber = number;
                currentSequenceLength = 1;
            }
        }

        return maxSequenceLength;

//        if (array == null) return 0;
//
//        int length = array.length;
//        if (length <= 1) return length;
//
//        int maxLength = 1;
//        int num = array[0];
//        int index = 1;
//
//        while (index < length){
//            int counter = 1;
//            while (index < length && num == array[index]){
//                counter++;
//                index++;
//            }
//            maxLength = Math.max(maxLength, counter);
//            if (index < length){
//                num = array[index++];
//            }
//        }
//        return maxLength;
    }

    @Test
    public void test(){

        Assert.assertEquals(longest_flat(new int[]{1,7,7,3}), 2);
    }


}
