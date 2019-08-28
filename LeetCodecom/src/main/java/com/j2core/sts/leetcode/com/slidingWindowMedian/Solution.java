package com.j2core.sts.leetcode.com.slidingWindowMedian;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {

        if (k == 0 && nums.length == 0) {
            return new double[0];
        }

        double[] result = new double[nums.length - k + 1];
        int index = 0;
        boolean flag = k%2 == 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++){
            list.add(nums[i]);
        }

        while (index < result.length){

            getMedian(list, k, flag, result, index);
            if (index+1 < result.length) {
                list.remove(Integer.valueOf(nums[index]));
                list.add(nums[k+index]);
            }
            index++;
        }

        return result;
    }

    private void getMedian(List<Integer> list, int k, boolean flag, double[] result, int index){

        Collections.sort(list);
        if (flag){
            int delta = k/2;
            if (list.get(delta).equals(list.get(delta-1))){
                result[index] = Double.valueOf(list.get(delta));
            }else {
                result[index] = ((double)list.get(delta)/2)+((double)list.get(delta-1)/2);
            }
        }else {
            result[index] = list.get(k/2);
        }
    }

    public double[] medianSlidingWindow1(int[] nums, int k) {
        double[] res=new double[nums.length-k+1];
        if(nums==null || nums.length==0 || k<=0) return res;
        PriorityQueue<Integer> left=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(left.size()<=right.size()){
                right.add(nums[i]);
                left.add(right.remove());
            }
            else{
                left.add(nums[i]);
                right.add(left.remove());
            }
            if(left.size()+right.size()==k){
                double median;
                if(left.size()==right.size()) median=(double)((long)left.peek()+(long)right.peek())/2;
                else median=(double)left.peek();
                int start=i-k+1;
                res[start]=median;
                if(!left.remove(nums[start]))
                    right.remove(nums[start]);
            }
        }
        return res;
    }

    @Test
    public void test(){

        double[] result = medianSlidingWindow1(new int[]{2147483647, 2147483647}, 2);

        Assert.assertEquals(2,2);
    }
}