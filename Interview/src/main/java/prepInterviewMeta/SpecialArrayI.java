package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SpecialArrayI {

    public boolean isArraySpecial(int[] nums) {

        if(nums.length < 2) return true;

        for (int i = 1; i < nums.length; i++){

            if ((nums[i] + nums[i-1])%2 == 0) return false;
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(isArraySpecial(new int[]{1}));
        Assert.assertTrue(isArraySpecial(new int[]{2,1,4}));
        Assert.assertFalse(isArraySpecial(new int[]{4,3,1,6}));
    }
}
