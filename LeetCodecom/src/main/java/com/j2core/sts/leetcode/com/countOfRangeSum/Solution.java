package com.j2core.sts.leetcode.com.countOfRangeSum;

public class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSum = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) prefixSum[i+1] = prefixSum[i] + nums[i];
        int[] res = new int[1];
        partition(prefixSum, lower, upper, res);
        return res[0];
    }

    private long[] partition(long[] arr, int lower, int upper, int[] res) {
        if (arr.length == 1) return arr;
        int mid = arr.length / 2;
        long[] arr1 = new long[mid];
        long[] arr2 = new long[arr.length-mid];
        for (int i = 0; i < arr.length; i++) {
            if (i < mid) arr1[i] = arr[i];
            else arr2[i-mid] = arr[i];
        }
        return merge(partition(arr1, lower, upper, res), partition(arr2, lower, upper, res), lower, upper, res);
    }

    private long[] merge(long[] arr1, long[] arr2, int lower, int upper, int[] res) {
        long[] arr = new long[arr1.length + arr2.length];
        int j = 0, k = 0, l = 0, t = 0;
        for (int i = 0; i < arr1.length; i++) {
            while (j < arr2.length && arr2[j] < arr1[i]) arr[t++] = arr2[j++];
            while (k < arr2.length && arr2[k] - arr1[i] < lower) k++;
            while (l < arr2.length && arr2[l] - arr1[i] <= upper) l++;
            arr[t++] = arr1[i];
            res[0] += l - k;
        }
        for (; j < arr2.length; j++) arr[t++] = arr2[j];
        return arr;
    }
}
