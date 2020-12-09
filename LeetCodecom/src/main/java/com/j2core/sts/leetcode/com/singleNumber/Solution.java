package com.j2core.sts.leetcode.com.singleNumber;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

/*
   The class find element witch is single onto number's array
 */
public class Solution {

    /**
     * The method find single element onto array
     *
     * @param nums      number's array
     * @return          single element
     */
    public int singleNumberSorting(int[] nums) {
        Arrays.sort(nums);
        int singleNum = nums[0];
        for (int i = 1; i < nums.length; i++){

            if (singleNum == nums[i]){
                i++;
                if (i < nums.length) {
                    singleNum = nums[i];
                }
            }
        }
        return singleNum;
    }

    public int singleNumberMap(int[] nums) {

        Map<Integer, Integer> map = new HashMap();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (int num : map.keySet()){
            if (map.get(num) == 1) return num;
        }

        return 0;
    }

    public int singleNumberSet(int[] nums) {

        Set<Integer> set = new HashSet();
        for (int num : nums){
            if (set.contains(num)){
                set.remove(num);
            }else {
                set.add(num);
            }
        }

        return (int) set.toArray()[0];
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            res = res ^ nums[i];
        }
        return res;
    }

    @Test
    public void test(){

        Assert.assertEquals(singleNumber(new int[]{4,1,2,1,2}), 4);
    }
}
