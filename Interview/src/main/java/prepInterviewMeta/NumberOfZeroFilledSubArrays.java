package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class NumberOfZeroFilledSubArrays {

    public long zeroFilledSubarray(int[] nums) {

        long result = 0;
        long candidate = 0;

        for (int num : nums) {
            if (num == 0) {
                candidate++;
                result += candidate;
                continue;
            }
            candidate = 0;
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}), 6);
        Assert.assertEquals(zeroFilledSubarray(new int[]{0,0,0,2,0,0}), 9);

    }
}
