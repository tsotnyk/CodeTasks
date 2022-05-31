package slidingWindov.smallestSubarrayWithGreaterSum;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public static int findMinSubArray(int S, int[] arr) {

        int minLength = Integer.MAX_VALUE;
        int iS = 0;
        int iE = 0;
        int sum = 0;
        while (iE < arr.length){
            sum += arr[iE++];
            if (sum >= S){
                minLength = Math.min(minLength, iE-iS);
                while (iS < iE){
                    sum -= arr[iS++];
                    if (sum >= S){
                        minLength = Math.min(minLength, iE-iS);
                    }else {
                        break;
                    }
                }
            }
        }

        while (iS < iE){
            sum -= arr[iS++];
            if (sum >= S){
                minLength = Math.min(minLength, iE-iS);
            }else {
                break;
            }
        }
        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }

    @Test
    public void test(){

        Assert.assertEquals(2, findMinSubArray(7, new int[]{2,1,5,2,3,2}));
        Assert.assertEquals(1, findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        Assert.assertEquals(3, findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));

    }
}
