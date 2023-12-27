package com.j2core.sts.leetcode.com.movingAveragefromDataStream;

import java.util.LinkedList;

public class MovingAverage1 {

    LinkedList<Integer> list;
    int sum;
    int size;

    public MovingAverage1(int size) {

        this.list = new LinkedList<>();
        this.sum = 0;
        this.size = size;
    }

    public double next(int val) {

        if (this.list.size() == this.size){
            int last = this.list.removeFirst();
            this.sum -= last;
        }
        this.sum += val;
        this.list.add(val);

        return (double) sum/(double) this.list.size();
    }
}
