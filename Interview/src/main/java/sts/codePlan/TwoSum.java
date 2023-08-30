package sts.codePlan;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;

public class TwoSum {

    public int sumOfTwo(int[] array){

        int first = array[0];
        int second = first;

        for (int i=1; i < array.length; i++){

            int num = array[i];
            if (num > first){
                second = first;
                first = num;
            }
        }

        return first + second;
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, LinkedList<Integer>> map = createIndexesMap(nums);
        int[] result = null;
        for (int i = 0; i < nums.length; i++){
            int delta = target - nums[i];
            if (map.containsKey(delta)){
                if (delta == nums[i]){
                    if (map.get(delta).size() > 1) {
                        return new int[]{map.get(delta).getFirst(), map.get(delta).getLast()};
                    }else continue;
                }
                result = new int[]{i, map.get(delta).getLast()};
                break;
            }

        }

        return result;
    }

    private HashMap<Integer,LinkedList<Integer>> createIndexesMap(int[] nums) {

        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            LinkedList<Integer> list = map.getOrDefault(nums[i], new LinkedList<>());
            list.add(i);
            map.put(nums[i], list);
        }

        return map;
    }

    @Test
    public void test(){

        Assert.assertEquals(new int[]{1,2}, twoSum(new int[]{3,2,4}, 6));
    }
}
