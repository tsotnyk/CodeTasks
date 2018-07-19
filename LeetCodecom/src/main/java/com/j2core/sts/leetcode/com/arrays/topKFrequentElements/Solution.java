package com.j2core.sts.leetcode.com.arrays.topKFrequentElements;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.List;



public class Solution {

    class Number implements Comparable<Number>{

        Integer num;
        Integer count;

        Number(int num){
            this.num = num;
            this.count = 1;
        }

        public void setCount(){
            this.count = this.count + 1;
        }


        @Override
        public int compareTo(Number obj) {

            int tmp = obj.count.compareTo(count);

            if (tmp != 0){
                return tmp;
            }else {
                return num.compareTo(obj.num);
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new LinkedList<>();
        List<Number> numList = new LinkedList<>();
        for (int num : nums){

            boolean flag = false;
            for (Number number : numList){

                if (number.num == num){
                    number.setCount();
                    flag = true;
                    break;
                }
            }
            if (!flag){
                numList.add(new Number(num));
            }
        }

        Collections.sort(numList);

        for (int i = 0; i < k; i++){

            result.add(numList.get(i).num);
        }

        return result;
    }

    @Test
    public void test(){

                List<Integer> result = topKFrequent(new int[]{1,1,1,2,2,3}, 2);

        Assert.assertEquals(result.size(), 2);

//        List<Integer> result = topKFrequent(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 10);
//
//        Assert.assertEquals(result.size(), 10);
//
//        List<Integer> result = topKFrequent(new int[]{3,0,1,0}, 1);
//
//        Assert.assertEquals(result.size(), 1);
//
//        List<Integer> result = topKFrequent(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 10);
//
//        Assert.assertEquals(result.size(), 10);

    }
}
