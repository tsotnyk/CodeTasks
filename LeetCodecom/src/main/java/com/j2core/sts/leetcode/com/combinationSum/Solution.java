package com.j2core.sts.leetcode.com.combinationSum;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public List<List<Integer>> combinationSumOld(int[] candidates, int target) {
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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        ArrayList<HashSet<List<Integer>>> matrix = new ArrayList<>(target+1);
        matrix.add(new HashSet<>());

        for (int i = 1; i <= target; i++){
            HashSet<List<Integer>> nextSet = new HashSet<>();

            for (int j = 0; j < candidates.length; j++){
                if (candidates[j] <= i){
                    int prevNum = i - candidates[j];
                    if (!matrix.get(prevNum).isEmpty()){
                        for (List<Integer> list : matrix.get(prevNum)){
                            ArrayList<Integer> nextList = new ArrayList<>(list);
                            nextList.add(candidates[j]);
                            Collections.sort(nextList);
                            nextSet.add(nextList);
                        }
                    }
                    if (candidates[j] == i){
                        nextSet.add(new ArrayList<>(Arrays.asList(candidates[j])));
                    }
                }else break;
            }

            matrix.add(nextSet);
        }

        return new ArrayList<>(matrix.get(target));
    }

    @Test
    public void test(){

        List<List<Integer>> result = combinationSum(new int[]{2,3,5}, 8);

        List<List<Integer>> result2 = combinationSum(new int[]{8,7,4,3}, 11);


        HashSet<List<Integer>> set = new HashSet<>();
        set.add(new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9)));
        set.add(new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9)));

        ArrayList<List<Integer>> list = new ArrayList<>(set);

        Assert.assertEquals(set.size(), 1);
    }
}
