package faang.amazon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BuildArrayFromPermutation {

    public int[] buildArray(int[] nums) {

        if (nums == null) return null;
        if (nums.length < 1) return new int[0];

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++){

            res[i] = nums[nums[i]];
        }

        return res;
    }

    @Test
    public void test_buildArray(){

        Assert.assertEquals(new int[]{4,5,0,1,2,3}, buildArray(new int[]{5,0,1,2,3,4}));
    }
}
