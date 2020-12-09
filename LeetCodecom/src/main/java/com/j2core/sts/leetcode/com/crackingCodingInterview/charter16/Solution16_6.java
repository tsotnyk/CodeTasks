package com.j2core.sts.leetcode.com.crackingCodingInterview.charter16;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.TreeSet;

public class Solution16_6 {

    // Time complexity O(n2) where n - array.length; Space complexity O(1);
    public int findMinPairDifferenceBF(int[] array1, int[] array2){

        int minDifference = Integer.MAX_VALUE;
        for(int i = 0; i < array1.length; i++){
            for(int j= 0; j < array2.length; j++){
                int diff = Math.abs(array1[i]-array2[j]);
                if(minDifference > diff){
                    minDifference = diff;
                }
            }
        }

        return minDifference;
    }

    // Time complexity O(nLogm+mLogm) , space complaxity O(n) where n - array1.lengt and m - array2.length
    public int findMinPairDifference(int[] array1, int[] array2){

        int minDifference = Integer.MAX_VALUE;
        TreeSet<Integer> tree = new TreeSet<>();
        for(int num : array2){
            tree.add(num);
        }

        for(int num : array1){
            int diff;
            Integer bigger = tree.ceiling(num);
            Integer smaller = tree.floor(num);
            if(bigger != null && smaller != null){
                diff = Math.min(Math.abs(num-bigger), Math.abs(num-smaller));
            }else if(bigger == null){
                diff = Math.abs(num-smaller);
            }else{
                diff = Math.abs(num-bigger);
            }

            if(minDifference > diff){
                minDifference = diff;
            }
        }

        return minDifference;
    }

    @Test
    public void test(){

        Assert.assertEquals(findMinPairDifference(new int[]{1,3,15,11,2}, new int[]{23,127,235,19,8}), 3);
        Assert.assertEquals(findMinPairDifferenceBF(new int[]{1,3,15,11,2}, new int[]{23,127,235,19,8}), 3);

    }
}
