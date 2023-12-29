package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaximumProductDifferenceBetweenTwoPairs {

    public int maxProductDifference(int[] nums) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums){
            if (num > max2){
                if (num > max1){
                    max2 = max1;
                    max1 = num;
                }else {
                    max2 = num;
                }
            }
            if (num < min2){
                if (num < min1){
                    min2 = min1;
                    min1 = num;
                }else {
                    min2 = num;
                }
            }
        }

        return (max1*max2) - (min1*min2);
    }

    @Test
    public void test(){

        Assert.assertEquals(34, maxProductDifference(new int[]{5,9,4,6}));
        Assert.assertEquals(64, maxProductDifference(new int[]{4,2,5,9,7,4,8}));
        Assert.assertEquals(34, maxProductDifference(new int[]{5,6,2,7,4}));
    }
}
