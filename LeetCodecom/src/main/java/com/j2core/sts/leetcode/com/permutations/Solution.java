package com.j2core.sts.leetcode.com.permutations;

import java.util.*;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {

        if (nums.length < 1){
            return null;
        }
        if (nums.length == 1){
            List<Integer> tmp = new LinkedList<>();
            tmp.add(nums[0]);
            List<List<Integer>> result = new LinkedList<>();
            result.add(tmp);
            return result;
        }

        Set<List<Integer>> result = new HashSet<>();
        Set<List<Integer>> tmpResult;
        int index = 0;

        List<Integer> tmp = new ArrayList<>(nums.length);
        tmp.add(nums[index++]);
        result.add(tmp);

        while (index < nums.length){
            tmpResult = new HashSet<>();
            for (List<Integer> list : result){
                for (int i = 0; i < list.size(); i++) {
                    tmp = new ArrayList<>(list);
                    tmp.add(i, nums[index]);
                    tmpResult.add(tmp);
                }
                tmp = new ArrayList<>(list);
                tmp.add(nums[index]);
                tmpResult.add(tmp);
            }
            result = tmpResult;
            index++;
        }

        return new LinkedList<>(result);
    }

}
