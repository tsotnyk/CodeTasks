package twoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SumOfThreeValues {

    public static boolean findSumOfThreeOld(int[] nums, int target) {
        Arrays.sort(nums);

        int left, right, triple;

        for (int i = 0; i < nums.length-2; i++){

            left = i+1;
            right = nums.length-1;
            while (left < right){
                triple = nums[i] + nums[left] + nums[right];
                if (triple == target) return true;
                if (triple > target){
                    right--;
                }else {
                    left++;
                }
            }
        }

        return false;
    }

    public static boolean findSumOfThree(int[] nums, int target) {

        // Replace this placeholder return statement with your code
        return false;
    }

    @Test
    public void test_findSumOfThree(){

        Assert.assertFalse(findSumOfThree(new int[]{1,0,-1}, -1));
        Assert.assertTrue(findSumOfThree(new int[]{3,7,1,2,8,4,5}, 10));
        Assert.assertFalse(findSumOfThree(new int[]{3,7,1,2,8,4,5}, 21));
        Assert.assertTrue(findSumOfThree(new int[]{-1,2,1,-4,5,-3}, -8));
        Assert.assertTrue(findSumOfThree(new int[]{-1,2,1,-4,5,-3}, 0));
    }
}
