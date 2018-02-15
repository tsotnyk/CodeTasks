package com.j2core.sts.leetcode.com.MaximumLengthOfRepeatedSubarray;

public class Solution {

    public int findLength(int[] A, int[] B) {
        int[] lessArray;
        int[] bigArray;
        int result = 0;

        if (A.length < B.length){
            lessArray = A;
            bigArray = B;
        }else {
            lessArray = B;
            bigArray = A;
        }
        int counter = 0;
        for (int i = 0; i < bigArray.length; i++){

            for (int j = 0; j < lessArray.length; j++){

                if (bigArray[i] == lessArray[j]){
                    int lessArrayIndex = j;
                    int bigArrayIndex = i;
                    while (bigArrayIndex < bigArray.length && lessArrayIndex < lessArray.length){
                        if (bigArray[bigArrayIndex] == lessArray[lessArrayIndex]){
                            counter++;
                            lessArrayIndex++;
                            bigArrayIndex++;
                        }else {
                            break;
                        }
                    }
                }
                if (result < counter) {
                    result = counter;
                }
                counter = 0;
            }
            if ((bigArray.length-i) < result) break;
        }

        return result;
    }
}
