package faang.amazon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConcatenationOfArray {

    public int[] getConcatenation(int[] nums) {

        if (nums == null) return null;
        if (nums.length < 1) return new int[0];
        int length = nums.length;
        int[] res = new int[length*2];

        for (int i = 0; i < length; i++){
            res[i] = nums[i];
            res[i+length] = nums[i];
        }

        return res;
    }

    @Test
    public void test_getConcatenation(){

        Assert.assertEquals(new int[]{1,2,1,1,2,1}, getConcatenation(new int[]{1,2,1}));

    }
}
