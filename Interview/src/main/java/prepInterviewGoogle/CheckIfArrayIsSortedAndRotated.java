package prepInterviewGoogle;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckIfArrayIsSortedAndRotated {

    public boolean check(int[] nums) {

        boolean rotated = false;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i-1]){
                if (rotated) return false;
                if (nums[i] > nums[0]){
                    return false;
                }else {
                    rotated = true;
                }
            }
            if (rotated){
                if (nums[i] > nums[0]) return false;
            }
        }

        return true;
    }

    @Test
    public void test(){

        Assert.assertTrue(check(new int[]{3,4,5,1,2}));
        Assert.assertTrue(check(new int[]{1,2}));
        Assert.assertFalse(check(new int[]{2,1,3,4}));
        Assert.assertFalse(check(new int[]{5,6,1,2,3,6,7,8}));
    }
}
