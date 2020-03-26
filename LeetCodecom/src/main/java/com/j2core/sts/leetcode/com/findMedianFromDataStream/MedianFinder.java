package com.j2core.sts.leetcode.com.findMedianFromDataStream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MedianFinder {

    List<Integer> store;
    /** initialize your data structure here. */
    public MedianFinder() {

        this.store = new ArrayList<>();
    }

    public void addNum(int num) {
        int left = 0, right = store.size() - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(num >= store.get(mid)) left = mid + 1;
            else right = mid - 1;
        }
        store.add(left, num);
    }

    public double findMedian() {

        int half = store.size()/2;
        return store.size()%2 == 1 ? store.get(half) : (store.get(half-1) + store.get(half)) * 0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
