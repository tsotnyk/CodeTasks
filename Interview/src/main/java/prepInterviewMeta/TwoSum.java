package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int candidate = target - nums[i];
            if (map.containsKey(candidate)){
                return new int[]{map.get(candidate), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }


    @Test
    public void test(){

        Assert.assertEquals(twoSum(new int[]{2,7,11,15}, 9), new int[]{0,1});
        Assert.assertEquals(twoSum(new int[]{3,2,4}, 6), new int[]{1,2});
        Assert.assertEquals(twoSum(new int[]{3,3}, 6), new int[]{0,1});
    }
}
