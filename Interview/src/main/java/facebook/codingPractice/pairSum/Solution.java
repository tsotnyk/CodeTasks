package facebook.codingPractice.pairSum;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    int numberOfWays(int[] arr, int k) {
        // Write your code here
        int counter = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++){
            int delta = k- arr[i];
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] == delta){
                    counter++;
                }else if (arr[j] > delta){
                    break;
                }
            }
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(numberOfWays(new int[]{1}, 6), 0);
        Assert.assertEquals(numberOfWays(new int[]{1,2,3,4,5}, 6), 2);
        Assert.assertEquals(numberOfWays(new int[]{1,5,3,3,3}, 6), 4);

    }
}
