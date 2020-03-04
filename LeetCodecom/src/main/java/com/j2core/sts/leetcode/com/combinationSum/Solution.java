package com.j2core.sts.leetcode.com.combinationSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<candidates.length;i++){
            sum = candidates[i];
            stack.push(candidates[i]);
            findCombination(candidates, target, sum, i, stack, lists);
            stack.clear();
        }
        return lists;
    }

    private void findCombination(int[] nums, int target, int sum, int index, Stack<Integer> stack, List<List<Integer>> lists){
        for(int i=index;i<nums.length;i++){
            if(sum == target){
                lists.add(new ArrayList<>(stack));
                return;
            }
            else if(sum > target){
                return;
            }
            stack.push(nums[i]);
            sum += nums[i];
            findCombination(nums, target, sum, i, stack, lists);
            if(!stack.isEmpty()){
                sum -= stack.peek();
                stack.pop();
            }
        }
    }
}
