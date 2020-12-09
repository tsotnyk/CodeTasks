package com.j2core.sts.leetcode.com.numberOfRecentCalls;

import java.util.LinkedList;

public class RecentCounter {

    LinkedList<Integer> pingList;

    public RecentCounter() {

        pingList = new LinkedList<>();
    }

    public int ping(int t) {

        pingList.add(t);

        while (t - pingList.getFirst() > 3000){
            pingList.removeFirst();
        }
        return pingList.size();
    }


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
