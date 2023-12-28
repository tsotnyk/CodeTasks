package faang.amazon;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {

        HashMap<Integer, Integer> counterMap = new HashMap<>();
        int res = 0;

        for (int num : nums){
            int counter = counterMap.getOrDefault(num, 0);
            res += counter;
            counterMap.put(num, counter+1);
        }


        return res;
    }

    @Test
    public void test(){

        Assert.assertEquals(4, numIdenticalPairs(new int[]{1,2,3,1,1,3}));
        Assert.assertEquals(6, numIdenticalPairs(new int[]{1,1,1,1}));
    }
}
