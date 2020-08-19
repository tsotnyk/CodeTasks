package sts.facebook.codingPractice.arrays.contiguousSubarrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    int[] countSubarrays(int[] arr) {
        // Write your code here

        int[] result = new int[arr.length];

        findPeak(arr, result, 0, arr.length-1);

        return result;
    }

    private void findPeak(int[] arr, int[] result, int indexStart, int indexEnd){

        if (indexEnd < indexStart){
            return;
        }
        if (indexStart == indexEnd){
            result[indexStart] = 1;
            return;
        }
        int maxValue = arr[indexStart];
        int maxIndex = indexStart;

        for (int i = indexStart+1; i <= indexEnd; i++){
            if (arr[i] > maxValue){
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        result[maxIndex] = indexEnd-indexStart+1;
        findPeak(arr, result, indexStart, maxIndex-1);
        findPeak(arr, result, maxIndex+1, indexEnd);
    }

    @Test
    public void test(){

        Assert.assertEquals(countSubarrays(new int[]{3, 4, 1, 6, 2}), new int[]{1, 3, 1, 5, 1});
    }
}
