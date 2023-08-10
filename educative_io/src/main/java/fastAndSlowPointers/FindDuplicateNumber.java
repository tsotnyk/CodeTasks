package fastAndSlowPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {

        // Write your code here
        boolean[] array = new boolean[nums.length];
        int index = nums[0];
        while (!array[index]){
            array[index] = true;
            index = nums[index];
        }
        return index;
    }

    @Test
    public void test(){

        Assert.assertEquals(findDuplicate(new int[]{1,3,3,4,2,5}), 3);
    }
}
