package com.j2core.sts.leetcode.com.arrays.KthLargestElementInArray;

import java.util.PriorityQueue;

public class Solution1 {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums){
            if (queue.size() < k){
                queue.add(num);
                continue;
            }
            if (queue.peek() < num){
                queue.poll();
                queue.add(num);
            }
        }

        return queue.poll();
    }
}
