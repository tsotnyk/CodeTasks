package com.j2core.sts.leetcode.com.arrays.maximumAverageSubarrayII;

import org.testng.annotations.Test;

public class Solution {

    public double findMaxAverageTimeLimit(int[] nums, int k) {

        long sum = 0;
        int index = 0;
        double average = Double.MIN_VALUE;
        double tmp;

        for (int i = 0; i+k <= nums.length; ){

            if (i == 0){
                while (index < k){
                    sum += nums[index++];
                }
                average = (double) sum/k;
            }else {
                sum -= nums[i-1];
                sum += nums[++index];
                tmp = (double) sum/k;
                average = Math.max(average, tmp);
                index++;
            }

            while (index < nums.length){
                sum += nums[index];
                tmp = (double) sum/(index-i+1);
                average = Math.max(tmp, average);
                index++;
            }

            i++;

            if (i+k <= nums.length){
                while (index > i+k-1){
                    if (index == nums.length){
                        sum -= nums[i-1];
                    }else {
                        sum -= nums[index];
                    }
                    tmp = (double) sum/(index-i);
                    average = Math.max(tmp, average);
                    index--;
                }
                i++;
            }
        }

        return average;
    }

        public double findMaxAverage(int[] nums, int k) {
            double max_val = Integer.MIN_VALUE;
            double min_val = Integer.MAX_VALUE;
            for (int n: nums) {
                max_val = Math.max(max_val, n);
                min_val = Math.min(min_val, n);
            }
            double prev_mid = max_val, error = Integer.MAX_VALUE;
            while (error > 0.00001) {
                double mid = (max_val + min_val) * 0.5;
                if (check(nums, mid, k))
                    min_val = mid;
                else
                    max_val = mid;
                error = Math.abs(prev_mid - mid);
                prev_mid = mid;
            }
            return min_val;
        }
        public boolean check(int[] nums, double mid, int k) {
            double sum = 0, prev = 0, min_sum = 0;
            for (int i = 0; i < k; i++)
                sum += nums[i] - mid;
            if (sum >= 0)
                return true;
            for (int i = k; i < nums.length; i++) {
                sum += nums[i] - mid;
                prev += nums[i - k] - mid;
                min_sum = Math.min(prev, min_sum);
                if (sum >= min_sum)
                    return true;
            }
            return false;
        }

    @Test
    public void test(){

        System.out.println(findMaxAverage(new int[]{4,2,1,3,3}, 2));

        System.out.println(findMaxAverage(new int[]{-1}, 1));

        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));

    }
}
