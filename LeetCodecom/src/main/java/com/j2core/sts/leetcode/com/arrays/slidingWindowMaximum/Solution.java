package com.j2core.sts.leetcode.com.arrays.slidingWindowMaximum;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length-k+1];
        int resultIndex = 0;

        int maxValue = Integer.MIN_VALUE;
        PriorityQueue<Integer> subArray = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> removeNumberList = new HashMap<>();
        int index = 0;
        while (index < nums.length){
            if (index < k){
                subArray.add(nums[index]);
                maxValue = Math.max(maxValue, nums[index++]);
            }else {
                result[resultIndex++] = maxValue;
                if (nums[index-k] == nums[index]){
                    index++;
                    continue;
                }
                if (nums[index-k] == maxValue){
                    subArray.poll();
                    subArray.add(nums[index]);
                    maxValue = subArray.peek();
                    while (removeNumberList.containsKey(maxValue)){
                        subArray.poll();
                        removeNumberList.put(maxValue, removeNumberList.get(maxValue)-1);
                        if (removeNumberList.get(maxValue) == 0) removeNumberList.remove(maxValue);
                        maxValue = subArray.peek();
                    }
                }else {
                    int removeNum = nums[index-k];
                    removeNumberList.put(removeNum, removeNumberList.getOrDefault(removeNum, 0)+1);
                    int num = nums[index];
                    subArray.add(num);
                    maxValue = Math.max(maxValue, num);
                }
                index++;
            }
        }

        result[resultIndex] = maxValue;
        return result;
    }

    public int[] maxSlidingWindowDP(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k || k == 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] leftmax = new int[len];
        int[] rightmax = new int[len];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i = i + k) {
            int end = i + k - 1 < len ? i + k - 1 : len - 1;
            max = nums[i];
            leftmax[i] = max;
            for (int j = i + 1; j <= end; j++) {
                if(nums[j] > max) {
                    max = nums[j];
                }
                leftmax[j] = max;
            }

            max = nums[end];
            rightmax[end] = max;
            for (int j = end - 1; j >= i; j--) {
                if(nums[j] > max) {
                    max = nums[j];
                }
                rightmax[j] = max;
            }
        }

        int[] res = new int[len - k + 1];
        for (int start = 0; start < len - k + 1; start++) {
            int end = start + k - 1;
            res[start] = Math.max(rightmax[start], leftmax[end]);
        }
        return res;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3), new int[]{3,3,5,5,6,7});
        Assert.assertEquals(maxSlidingWindow(new int[]{1, -1}, 2), new int[]{1});
        Assert.assertEquals(maxSlidingWindow(new int[]{1}, 1), new int[]{1});
        Assert.assertEquals(maxSlidingWindow(new int[]{1, -1}, 1), new int[]{1, -1});
        Assert.assertEquals(maxSlidingWindow(new int[]{9, 11}, 2), new int[]{11});
        Assert.assertEquals(maxSlidingWindow(new int[]{4, -2}, 2), new int[]{4});

    }
}
