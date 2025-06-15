package prepInterviewMeta;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;

public class SumOfUniqueElements {

    public int sumOfUnique(int[] nums) {

        HashMap<Integer, Boolean> numMap = new HashMap<>();

        int sum = 0;
        for (int num : nums){
            if (numMap.containsKey(num)){
                if (numMap.get(num)){
                    numMap.put(num, false);
                    sum -= num;
                    continue;
                }
                continue;
            }
            sum += num;
            numMap.put(num, true);
        }

        return sum;
    }

    @Test
    public void test(){

//        Assert.assertEquals(sumOfUnique(new int[]{1,2,3,2}), 4);
        Assert.assertEquals(sumOfUnique(new int[]{1,1,1,1,1}), 0);
        Assert.assertEquals(sumOfUnique(new int[]{1,2,3,4,5}), 15);

    }
}
