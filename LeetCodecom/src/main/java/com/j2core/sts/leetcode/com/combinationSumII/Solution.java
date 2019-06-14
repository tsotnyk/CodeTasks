package com.j2core.sts.leetcode.com.combinationSumII;

import java.util.*;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);
        Set<List<Integer>> solutions = new HashSet<>();
        combination(candidates, target, result, new ArrayList<Integer>(), 0, solutions);
        return result;
    }

    private void combination(int[] candidates, int target, List<List<Integer>> result, List<Integer> solution, int pos, Set<List<Integer>> options) {

        int sum = 0;
        for (int i = 0; i < solution.size(); i++) {
            sum += solution.get(i);
        }
        if (sum > target) {
            return;
        }

        if (sum == target) {
            if (!options.contains(solution)) {
                result.add(new LinkedList<>(solution));
                options.add(solution);
                return;
            }
        }

        for (int i = pos; i < candidates.length; i++) {
            solution.add(candidates[i]);
            combination(candidates, target, result, solution, i+1, options);
            solution.remove(solution.size()-1);
        }
    }
}
