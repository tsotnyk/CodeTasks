package old.slidingWindov.longestSubarrayWithOnesAfterReplacement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public static int findLength(int[] arr, int k) {
        // TODO: Write your code here

        int maxLength = k;
        int iS = 0;
        int iE = 0;
        int zeros = 0;

        while (iE < arr.length){
            if (arr[iE++] != 1){
                zeros++;
                if (zeros > k){
                    while (arr[iS] != 0){
                        iS++;
                    }
                    zeros--;
                    iS++;
                }
            }
            maxLength = Math.max(maxLength, iE-iS);
        }
        return maxLength;
    }

    @Test
    public void test(){

        Assert.assertEquals(9, findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
