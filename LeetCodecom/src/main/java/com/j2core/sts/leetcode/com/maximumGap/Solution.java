package com.j2core.sts.leetcode.com.maximumGap;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public int maximumGap1(int[] nums) {

        Arrays.sort(nums);

        int delta = 0;
        int tmpDelta;

        for (int i = 1; i < nums.length; i++){
            tmpDelta = nums[i] - nums[i-1];
            if (tmpDelta > delta){
                delta = tmpDelta;
            }
        }
        return delta;
    }

    public int maximumGap(int[] nums) {

        if (nums.length < 2) return 0;
        Set<Integer> set = new TreeSet<>();

        for (int value : nums) {
            set.add(value);
        }

        int delta = 0;
        int num = -1;

        for (int setNum : set){

            if (num == -1){
                num = setNum;
            }else {
                delta = Math.max(delta, setNum-num);
                num = setNum;
            }
        }
        return delta;
    }
}
