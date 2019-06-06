package com.j2core.sts.leetcode.com.permutationsII;

import java.util.*;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        sort(res, nums, 0, nums.length - 1);
        return res;
    }

    private void sort(List<List<Integer>> res, int[] nums, int start, int end) {
        if (start == end) {
            List<Integer> list = new LinkedList<>();
            for (int i : nums) {
                list.add(i);
            }
            res.add(list);
            return;
        }

        Set set = new HashSet();
        for (int i = start; i <= end; i++) {
            if (!set.add(nums[i])) {
                continue;
            }
            swap(nums, i, start);
            sort(res, nums, start + 1, end);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
