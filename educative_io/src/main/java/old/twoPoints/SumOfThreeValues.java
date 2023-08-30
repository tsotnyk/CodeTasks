package old.twoPoints;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SumOfThreeValues {

    public static boolean findSumOfThree1(int[] nums, int target) {

        for (int i = 0; i < nums.length-2; i++){
            for (int j = i+1; j < nums.length-1; j++){
                for (int k = j+1; k < nums.length; k++){
                    if (nums[i]+nums[j]+nums[k] == target) return true;
                }
            }
        }

        return false;
    }

    public static boolean findSumOfThree2(int[] nums, int target) {

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


    @Test
    public void test(){

        Assert.assertTrue(findSumOfThree2(new int[]{-4,-3,-1,1,2,5}, 0));
        Assert.assertTrue(findSumOfThree2(new int[]{-1,2,1,-4,5,-3}, -8));
        Assert.assertTrue(findSumOfThree2(new int[]{3,7,1,2,8,4,5}, 20));
        Assert.assertTrue(findSumOfThree2(new int[]{-1,2,1,4,-2}, 1));
        Assert.assertFalse(findSumOfThree2(new int[]{-1,2,1,4}, 1));
    }
}
