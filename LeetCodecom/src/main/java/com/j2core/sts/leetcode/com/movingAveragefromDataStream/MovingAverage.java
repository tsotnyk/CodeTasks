package com.j2core.sts.leetcode.com.movingAveragefromDataStream;

public class MovingAverage {

    private int size = 0;
    private int index = 0;
    private int capacity;
    private double[] array;
    private double sum = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {

        this.capacity = size;
        this.array = new double[size];
    }

    public double next(int val) {
        if (size < capacity){
            array[index++] = val;
            size++;
            sum += val;

        }else {
            sum -= array[index];
            sum += val;
            array[index++] = val;
        }
        if (index == capacity){
            index = 0;
        }
        return sum/size;
    }
}
