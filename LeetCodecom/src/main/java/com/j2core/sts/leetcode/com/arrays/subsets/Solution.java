package com.j2core.sts.leetcode.com.arrays.subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            output.addAll(newSubsets);
        }
        return output;
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();

        output.add(new ArrayList<>());

        for (int num : nums){
            ArrayList<ArrayList<Integer>> nextIter = new ArrayList<>();
            for (List<Integer> list : output){
                ArrayList<Integer> next = new ArrayList<>(list);
                next.add(num);
                nextIter.add(next);
            }
            output.addAll(nextIter);
        }

        return output;
    }
}
