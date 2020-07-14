package com.j2core.sts.leetcode.com.sum.sum3;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public List<List<Integer>> threeSumOld(int[] nums) {

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


    public List<List<Integer>> threeSumTimeLimit(int[] nums) {

        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length-2; i++){
            if (nums[i] > 0) break;
            for (int j = i+1; j < nums.length-1; j++){
                if (nums[i] + nums[j] > 0) break;
                for (int k = nums.length-1; k > i; k--){
                    if (nums[k] < 0) break;
                    int sum = nums[i]+nums[j]+nums[k];
                    if (k != j && sum == 0){
                        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        Collections.sort(list);
                        result.add(list);
                    }else if (sum < 0) break;
                }
            }
        }

        return new LinkedList<>(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i])
                twoSumII(nums, i, res);
        return res;
    }
    void twoSumII(int[] nums, int i, List<List<Integer>> res) {

        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0 || (lo > i + 1 && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (sum > 0 || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
        }
    }


    @Test
    public void test(){



        Assert.assertEquals(threeSum(new int[]{-1,0,1,2,-1,-4}).size(), 2);
    }

}
