package com.j2core.sts.leetcode.com.design.designHitCounter;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class HitCounter {

    LinkedList<Integer> hitQueue;

    public HitCounter() {

        this.hitQueue = new LinkedList<>();
    }

    public void hit(int timestamp) {

        this.hitQueue.add(timestamp);
        removeOldHits(timestamp);
    }

    public int getHits(int timestamp) {
        removeOldHits(timestamp);
        return this.hitQueue.size();
    }

    private void removeOldHits(int timeStamp){

        int timeRange = timeStamp-300;
        while (!this.hitQueue.isEmpty() && this.hitQueue.getFirst() <= timeRange){
            this.hitQueue.removeFirst();
        }
    }

    @Test
    public void test(){

        HitCounter hitCounter = new HitCounter();

        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        Assert.assertEquals(hitCounter.getHits(300), 3);
        hitCounter.hit(300);
        Assert.assertEquals(hitCounter.getHits(301), 4);
    }
}
