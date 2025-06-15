package prepInterviewApple;

import org.testng.annotations.Test;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> set = new HashMap<>();

        for (int i  = 0; i < nums.length; i++){
            int candidate = target - nums[i];
            if (set.containsKey(candidate)){
                return new int[]{i, set.get(candidate)};
            }
            set.put(nums[i], i);
        }

        return null;
    }

    @Test
    public void test(){

        int[] arr = new int[]{2,7,11,15};

        twoSum(arr, 9);
    }
}
