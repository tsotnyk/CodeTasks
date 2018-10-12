package com.j2core.sts.leetcode.com.arrays.sum3Closest;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {

        int result = 0;
        int delta = Integer.MAX_VALUE;
        List<List<Integer>> list2Sum = createListSum2Elements(nums);

        for (int i = 0; i < nums.length; i++){

            for (List<Integer> list : list2Sum){

                if (i != list.get(0) && i != list.get(1)){

                    int tmpSum = list.get(2) + nums[i];
                    int tmpDelta = Math.abs(tmpSum - target);

                    if (tmpDelta == 0){
                        return tmpSum;
                    }else if (tmpDelta < delta){
                        delta = tmpDelta;
                        result = tmpSum;
                    }
                }
            }
        }

        return result;
    }

    private List<List<Integer>> createListSum2Elements(int[] nums){

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length-1; i++){

            for (int j = i+1; j < nums.length; j++){

                List<Integer> list = new LinkedList<>();

                list.add(i);
                list.add(j);
                list.add(nums[i] + nums[j]);

                result.add(list);
            }
        }
        return result;
    }

    @Test
    public void test(){


        Assert.assertEquals(2, threeSumClosest(new int[]{-1,2,1,-4}, 1));

    }

}
