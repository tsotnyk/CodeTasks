package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RunningSumOf1DArray {

    public int[] runningSum(int[] nums) {

        int[] res = new int[nums.length];

        int sum = 0;

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            res[i] = sum;
        }

        return res;
    }

    @Test
    public void test_runningSum(){

        Assert.assertEquals(new int[]{1,3,6,10}, runningSum(new int[]{1,2,3,4}));
    }
}
