package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class MajorityElement {

    public int majorityElement(int[] nums) {

        int target = (nums.length/2);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            int counter = map.getOrDefault(num, 0)+1;
            if (counter > target) return num;
            map.put(num, counter);
        }

        return nums[0];
    }

    @Test
    public void test(){

        Assert.assertEquals(5, majorityElement(new int[]{6,5,5}));
    }
}
