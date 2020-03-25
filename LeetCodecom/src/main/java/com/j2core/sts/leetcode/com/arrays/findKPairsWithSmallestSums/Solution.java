package com.j2core.sts.leetcode.com.arrays.findKPairsWithSmallestSums;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                List<Integer> tmp = new ArrayList<>(Arrays.asList(nums1[i], nums2[j]));
                result.add(tmp);
            }
        }

        result.sort(new SortList());

        if (result.size() <= k) return result;

        return result.subList(0, k);

    }

    class SortList implements Comparator<List<Integer>>{


        @Override
        public int compare(List<Integer> integers, List<Integer> t1) {

            Integer sum1 = 0;
            for (int num : integers){
                sum1 +=  num;
            }
            int sum2 = 0;
            for (int num : t1){
                sum2 += num;
            }

            return sum1.compareTo(sum2);
        }
    }

    @Test
    public void test(){

        List<List<Integer>> result = kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 2);

        Assert.assertEquals(result.size(), 2);
    }

}
