package com.j2core.sts.leetcode.com.sum4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> list2sum = create2Sum(nums);

        Set<List<Integer>> result = new HashSet<>();

        for (List<Integer> firstList : list2sum){

            for (List<Integer> secondList : list2sum){

                if (!firstList.get(1).equals(secondList.get(1)) && !firstList.get(1).equals(secondList.get(2)) &&
                        !firstList.get(2).equals(secondList.get(1)) && !firstList.get(2).equals(secondList.get(2))){

                    if (firstList.get(0)+secondList.get(0) == target){

                        List<Integer> tmp = new LinkedList<>();
                        tmp.add(firstList.get(3));
                        tmp.add(firstList.get(4));
                        tmp.add(secondList.get(3));
                        tmp.add(secondList.get(4));

                        Collections.sort(tmp);

                        result.add(tmp);

                    }
                }
            }
        }

        return createList(result);

    }


    private List<List<Integer>> create2Sum(int[] nums){

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length-1; i++){

            for (int j = i+1; j < nums.length; j++){

                List<Integer> list = new LinkedList<>();

                list.add(nums[i] + nums[j]);
                list.add(i);
                list.add(j);
                list.add(nums[i]);
                list.add(nums[j]);

                result.add(list);
            }
        }

        return result;
    }


    private List<List<Integer>> createList(Set<List<Integer>> set){

        List<List<Integer>> result = new LinkedList<>();

        result.addAll(set);

        return result;
    }


    @Test
    public void test(){

        Assert.assertEquals(3, fourSum(new int[]{1,0,-1,0,-2,2}, 0).size());

    }
}
