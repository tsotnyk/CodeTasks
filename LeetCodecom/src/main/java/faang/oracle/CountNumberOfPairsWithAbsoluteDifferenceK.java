package faang.oracle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CountNumberOfPairsWithAbsoluteDifferenceK {

    public int countKDifference(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int res = 0;

        for (int i = nums.length-1; i >= 0; i--){
            if(map.containsKey(nums[i]+k)){
                res+= map.get(nums[i]+k);
            }
            if(map.containsKey(nums[i]-k)){
                res+= map.get(nums[i]-k);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        return res;
    }

    @Test
    public void test(){

        Assert.assertEquals(4, countKDifference(new int[]{1,2,2,1}, 1));
        Assert.assertEquals(3, countKDifference(new int[]{3,2,1,5,4}, 2));
        Assert.assertEquals(0, countKDifference(new int[]{1,3}, 3));

    }
}
