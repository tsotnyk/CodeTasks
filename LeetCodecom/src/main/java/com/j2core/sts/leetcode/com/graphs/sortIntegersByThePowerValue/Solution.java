package com.j2core.sts.leetcode.com.graphs.sortIntegersByThePowerValue;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {

    public int getKth(int lo, int hi, int k) {

        if (hi - lo == 0 && k == 1) return lo;

        ArrayList<int[]> numList = countTransformSteps(lo, hi);

        Collections.sort(numList, new Comparator<int[]>() {
            @Override
            public int compare(int[] array1, int[] array2) {

                int result = array1[1] - array2[1];
                return result != 0 ? result : array1[0] - array2[0];
            }
        });

        return numList.get(k-1)[0];
    }

    private ArrayList<int[]> countTransformSteps(int smrNum, int hgtNum){

        ArrayList<int[]> numList = new ArrayList<>(hgtNum-smrNum+1);
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = smrNum; i <= hgtNum; i++){
            int num = i;
            if (numMap.containsKey(num)){
                numList.add(new int[]{num, numMap.get(num)});
            }else {
                int sumSteps = 0;
                while (num != 1){
                    if (num%2 == 0){
                        num /= 2;
                    }else {
                        num = (num*3)+1;
                    }
                    sumSteps++;
                    if (numMap.containsKey(num)){
                        sumSteps += numMap.get(num);
                        break;
                    }
                }
                numMap.put(i, sumSteps);
                numList.add(new int[]{i, sumSteps});
            }
        }
        return numList;
    }

    @Test
    public void test(){

        Assert.assertEquals(getKth(12, 15, 2), 13);
        Assert.assertEquals(getKth(1, 1, 1), 1);
        Assert.assertEquals(getKth(7, 11, 4), 7);
        Assert.assertEquals(getKth(10, 20, 5), 13);
        Assert.assertEquals(getKth(1, 1000, 777), 570);

    }
}
