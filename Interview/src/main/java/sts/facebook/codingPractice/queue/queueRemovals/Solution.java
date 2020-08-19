package sts.facebook.codingPractice.queue.queueRemovals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {


    int[] findPositions(int[] arr, int x) {
        // Write your code here
        int[] result = new int[x];
        int resultIndex = 0;
        int maxValue = -1;
        int maxIndex = -1;
        int index = 0;
        int length = arr.length;
        int subArrLength = x;

        while (x-- > 0){
            maxIndex = -1;
            maxValue = -1;
            int counter = 0;
            while (counter < subArrLength && counter < length){
                if (index == arr.length){
                    index = 0;
                }
                if (arr[index] < 0){
                    index++;
                }else {
                    if (arr[index] > maxValue){
                        maxValue = arr[index];
                        maxIndex = index;
                    }
                    if (arr[index] > 0) {
                        arr[index] -= 1;
                    }
                    index++;
                    counter++;
                }
            }
            arr[maxIndex] = -1;
            length--;
            result[resultIndex++] = maxIndex+1;
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(findPositions(new int[]{1, 2, 2, 3, 4, 5}, 5), new int[]{5, 6, 4, 1, 2});

        Assert.assertEquals(findPositions(new int[]{2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4}, 4), new int[]{2, 5, 10, 13});
    }
}
