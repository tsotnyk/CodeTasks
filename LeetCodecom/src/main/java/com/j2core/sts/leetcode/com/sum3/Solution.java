package com.j2core.sts.leetcode.com.sum3;


import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> resultSet = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++){

            if (nums[i] > 0) break;
            createResultList(nums, i, resultSet);

        }

        return new LinkedList<>(resultSet);
    }


    private void createResultList(int[] nums, int indexI, Set<List<Integer>> collection){

        for (int i = indexI+1; i < nums.length-1; i++){

            for (int j = nums.length-1; j > i; j--){

                int sum = nums[indexI] + nums[i] + nums[j];
                if ( sum == 0) {
                    List<Integer> pair = new LinkedList<>();
                    pair.add(nums[indexI]);
                    pair.add(nums[i]);
                    pair.add(nums[j]);

                    Collections.sort(pair);
                    collection.add(pair);
                }else if (sum < 0) break;
            }
        }
    }




}
