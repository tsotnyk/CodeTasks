package com.j2core.sts.leetcode.com.arrays.a24Game;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Solution {

    public boolean judgePoint24(int[] nums) {

        ArrayList<ArrayList<Double>> combinations = new ArrayList<>();
        ArrayList<Double> base = new ArrayList<>();
        for (double num : nums){
            base.add(num);
        }
        combinations.add(base);
        int counter = 1;

        while (counter < nums.length){
            ArrayList<ArrayList<Double>> tmpCombinations = new ArrayList<>();
            while (!combinations.isEmpty()) {
                base = combinations.remove(0);
                for (int i = 1; i <= nums.length-counter; i++) {
                    ArrayList<Double> tmpBase = new ArrayList<>(base);
                    tmpBase.remove(i-1);
                    ArrayList<Double> tmp1 = new ArrayList<>(tmpBase);
                    tmp1.set(i-1, base.get(i-1)+ base.get(i));
                    tmpCombinations.add(tmp1);
                    ArrayList<Double> tmp2 = new ArrayList<>(tmpBase);
                    tmp2.set(i-1, base.get(i-1)-base.get(i));
                    tmpCombinations.add(tmp2);
                    ArrayList<Double> tmp3 = new ArrayList<>(tmpBase);
                    tmp3.set(i-1, base.get(i-1)*base.get(i));
                    tmpCombinations.add(tmp3);
                    ArrayList<Double> tmp4 = new ArrayList<>(tmpBase);
                    tmp4.set(i-1, base.get(i-1)/base.get(i));
                    tmpCombinations.add(tmp4);
                }
            }
            combinations = tmpCombinations;
            counter++;
        }

        for (ArrayList<Double> list : combinations){
            if (Math.abs(list.get(0)-24) < 0.0001) return true;
        }
        return false;
    }

    @Test
    public void test(){

        Assert.assertTrue(judgePoint24(new int[]{4,1,8,7}));
    }

}
