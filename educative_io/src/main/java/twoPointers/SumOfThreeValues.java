package twoPointers;

import java.util.Arrays;

public class SumOfThreeValues {

    public static boolean findSumOfThree(int[] nums, int target) {
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
}
