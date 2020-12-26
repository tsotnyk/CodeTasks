package com.j2core.sts.leetcode.com.tmp.uber;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TmpCodingTasks {

    // Time complexity - worst case O(n*m), best case O(n), where n - length of arrayA, m - length of arrayB
    public int countOfSatisfiesConditionNumber(int[] arrayA, int[] arrayB, int k){

        List<Integer> numList = new LinkedList<>();
        for (int num : arrayA){
            numList.add(num);
        }

        int index = 0;
        while (!numList.isEmpty() && index < arrayB.length){
            List<Integer> nextInterList = new LinkedList<>();
            int smallerNum = arrayB[index]-k;
            int biggerNum = arrayB[index]+k;
            for (int num : numList){
                if (num  < smallerNum || num > biggerNum){
                    nextInterList.add(num);
                }
            }
            numList = nextInterList;
            index++;
        }

        return numList.size();
    }

    @Test
    public void test1(){

        Assert.assertEquals(countOfSatisfiesConditionNumber(new int[]{7,6,9}, new int[]{13,1,4}, 3), 1);
    }

    public int findMaxOfMinValueInSubArray(int[] array, int subarrayLength){

        int minMaxValue = Integer.MAX_VALUE;
        int minNum;
        PriorityQueue<Integer> subArray = new PriorityQueue<>();
        HashMap<Integer, Integer> removeNumber = new HashMap<>();
        int index = 0;

        while (index < subarrayLength){
            int num = array[index++];
            minMaxValue = Math.min(minMaxValue, num);
            subArray.add(num);
        }
        minNum = minMaxValue;
        while (index < array.length){

            if (array[index-subarrayLength] == array[index]){
                index++;
                continue;
            }
            if (array[index-subarrayLength] == minNum){
                subArray.poll();
                subArray.add(array[index]);
                minNum = subArray.peek();
                while (removeNumber.containsKey(minNum)){
                    removeNumber.put(minNum, removeNumber.get(minNum)-1);
                    if (removeNumber.get(minNum) == 0){
                        removeNumber.remove(minNum);
                    }
                    subArray.poll();
                    minNum = subArray.peek();
                }
                minMaxValue = Math.max(minNum, minMaxValue);
            }else {
                int num = array[index-subarrayLength];
                removeNumber.put(num, removeNumber.getOrDefault(num, 0)+1);
                subArray.add(array[index]);
            }
            index++;
        }

        return minMaxValue;
    }

//    public int findMaxOfMinValueInSubArrayDP(int[] array, int subarrayLength){
//
//        int[] dp = new int[array.length-subarrayLength+1];
//
//    }

    @Test
    public void test2(){

        Assert.assertEquals(findMaxOfMinValueInSubArray(new int[]{10,20,30,50,10,70,30}, 2), 30);
        Assert.assertEquals(findMaxOfMinValueInSubArray(new int[]{10,20,30,50,10,70,30}, 1), 70);
        Assert.assertEquals(findMaxOfMinValueInSubArray(new int[]{10,20,30,50,10,70,30}, 4), 10);
        Assert.assertEquals(findMaxOfMinValueInSubArray(new int[]{20,10,30,20,40,100,106,120}, 3), 100);


    }
}
