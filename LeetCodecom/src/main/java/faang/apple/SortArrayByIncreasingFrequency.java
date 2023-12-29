package faang.apple;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());

        list.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())){
                return b.getKey() - a.getKey();
            }

            return a.getValue() - b.getValue();
        });

        int [] res = new int[nums.length];

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : list){
            int counter = 0;
            while (counter++ < entry.getValue()){
                res[index++] = entry.getKey();
            }
        }

        return res;
    }

    @Test
    public void test(){

        Assert.assertEquals(new int[]{3,1,1,2,2,2}, frequencySort(new int[]{1,1,2,2,2,3}));
    }
}
