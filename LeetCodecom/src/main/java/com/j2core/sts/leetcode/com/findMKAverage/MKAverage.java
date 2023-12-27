package com.j2core.sts.leetcode.com.findMKAverage;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MKAverage {

    int m;
    int k;
    LinkedList<Integer> stream;
    PriorityQueue<Integer> descending;
    PriorityQueue<Integer> increase;

    int sum;
    public MKAverage(int m, int k) {

        this.m = m;
        this.k = k;
        this.stream = new LinkedList<>();
        this.descending = new PriorityQueue<>(Comparator.reverseOrder());
        this.increase = new PriorityQueue<>();
        this.sum = 0;
    }

    public void addElement(int num) {



    }

    public int calculateMKAverage() {

//        if (this.stream.size() < m) return -1;
//        int average = this.sum;
//        int counter = 0;
//        while (counter < k){
//            average
//        }
//
//        return average/(this.m - (2* this.k));
        return -1;
    }
}
