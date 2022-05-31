package com.j2core.sts.leetcode.com.kthSmallestPrimeFraction;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        PriorityQueue<Pair> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length-1; i++){
            for (int j = i+1; j < arr.length; j++){
                if (queue.size() < k){
                    queue.add(new Pair((double) arr[i]/arr[j], arr[i], arr[j]));
                }else {
                    double sum = (double) arr[i]/arr[j];
                    if (queue.peek().sum > sum){
                        queue.poll();
                        queue.add(new Pair(sum, arr[i], arr[j]));
                    }
                }
            }
        }

        Pair result = queue.peek();
        return new int[]{result.valueI, result.valueJ};
    }

    class Pair implements Comparable{

        Double sum;
        int valueI;
        int valueJ;

        public Pair(double sum, int indexI, int indexJ) {
            this.sum = sum;
            this.valueI = indexI;
            this.valueJ = indexJ;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Double.compare(pair.sum, sum) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sum);
        }

        @Override
        public int compareTo(Object o) {
            Pair obj = (Pair) o;
            return this.sum.compareTo(obj.sum);
        }
    }

    @Test
    public void test(){

        Assert.assertArrayEquals(new int[]{2,5}, kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3));
    }
}
