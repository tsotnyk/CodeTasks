package containerWithMostWater;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxArea(int[] height) {

        int sum = 0;

        for (int i = 0; i < height.length-1; i++){

            int j = height.length-1;

            while (i < j){

                int tmpSum = Math.min(height[i], height[j]) * (j-i);

                if (sum < tmpSum){
                    sum = tmpSum;
                }
                j--;
            }
        }

        return sum;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxArea(new int[]{1,8,6,2,5,4,8,3,7}), 49);

    }
}
