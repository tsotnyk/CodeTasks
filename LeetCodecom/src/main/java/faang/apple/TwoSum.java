package faang.apple;

import org.testng.annotations.Test;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){

            int candidate = target - nums[i];
            if (map.containsKey(candidate)) return new int[]{map.get(candidate), i};
            map.put(nums[i], i);
        }

        return null;
    }

    @Test
    public void test(){

        int[] res = twoSum(new int[]{2,7,11,15}, 9);

        System.out.println(res[0]);
        System.out.println(res[1]);
//        Assert.assertEquals(new int[]{0,1}, twoSum(new int[]{2,7,11,15}, 9));
    }
}
