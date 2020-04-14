package com.j2core.sts.leetcode.com.kthLargestElementInStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargest {

    List<Integer> list;
    int kLargestValue;
    int size;
    int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        size = nums.length;
        list = new ArrayList<>();
        for (int num : nums){
            list.add(num);
        }
        Collections.sort(list);
        if (size >= k) {
            kLargestValue = list.get(size - k);
        }
    }

    public int add(int val) {
        size++;
        list.add(val);
        if (size == k || val > kLargestValue){
            Collections.sort(list);
            kLargestValue = list.get(size - k);
        }
        return kLargestValue;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
