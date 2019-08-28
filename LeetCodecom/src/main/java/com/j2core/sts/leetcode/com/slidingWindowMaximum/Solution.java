package com.j2core.sts.leetcode.com.slidingWindowMaximum;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (k == 0 && nums.length == 0){
            return new int[0];
        }

        if (k == 1) {
            return nums;
        }

        int length = nums.length;
        int[] result = new int[length-k+1];
        int index = 0;
        int nextIndex = k;
        int maxEl = findMaxElement(0, k, nums);
        while (nextIndex < length){

            result[index] = maxEl;

            if (nums[nextIndex] > maxEl){
                maxEl = nums[nextIndex];
            }else if (maxEl == nums[index]){
                maxEl = findMaxElement(index+1, k, nums);
            }
            index++;
            nextIndex++;
        }

        result[index] = maxEl;
        return result;
    }

    private int findMaxElement(int indexStart, int amount, int[] nums){

        int maxNum = Integer.MIN_VALUE;

        for (int i = indexStart; i < amount+indexStart; i++){
            if (nums[i] > maxNum){
                maxNum = nums[i];
            }
        }

        return maxNum;
    }
}
