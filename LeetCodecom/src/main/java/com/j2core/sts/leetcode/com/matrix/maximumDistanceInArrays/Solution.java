package com.j2core.sts.leetcode.com.matrix.maximumDistanceInArrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int maxDistance1(List<List<Integer>> arrays) {

        int maxDistance = 0;

        for (int i = 0; i < arrays.size()-1; i++){
            List<Integer> list = arrays.get(i);
            int first = list.get(0);
            int last = list.get(list.size()-1);
            for (int j = i+1; j < arrays.size(); j++){

                List<Integer> secondList = arrays.get(j);

                maxDistance = Math.max(Math.abs(secondList.get(0)-last), maxDistance);
                maxDistance = Math.max(Math.abs(secondList.get(secondList.size()-1)-first), maxDistance);

            }
        }
        return maxDistance;
    }

    public int maxDistanceSlow(List<List<Integer>> arrays) {

        int[] firstNums = new int[arrays.size()];
        int[] lastNums = new int[arrays.size()];
        int index = 0;

        for (List<Integer> list : arrays){
            firstNums[index] = list.get(0);
            lastNums[index] = list.get(list.size()-1);
            index++;
        }
        int maxDistance = 0;
        for (int i = 0; i < firstNums.length; i++){
            for (int j = 0; j < firstNums.length; j++){
                if (i != j) {
                    maxDistance = Math.max(maxDistance, Math.abs(firstNums[i] - lastNums[j]));
                }
            }
        }

        return maxDistance;
    }

    public int maxDistance(List<List<Integer>> arrays) {

        int maxDistance = Integer.MIN_VALUE;
        List<Integer> list = arrays.remove(0);
        int min = list.get(0);
        int max = list.get(list.size() - 1);

        for (List<Integer> nextList : arrays) {
            int first = nextList.get(0);
            int last = nextList.get(nextList.size()-1);
            maxDistance = Math.max(maxDistance, Math.abs(first - max));
            maxDistance = Math.max(maxDistance, Math.abs(last - min));
            min = Math.min(min, first);
            max = Math.max(max, last);
        }
        return maxDistance;
    }

    @Test
    public void test(){

//        List<List<Integer>> list = new LinkedList<>();
//        list.add(new LinkedList<>(Arrays.asList(-8,-7,-7,-5,1,1,3,4)));
//        list.add(new LinkedList<>(Arrays.asList(-2)));
//        list.add(new LinkedList<>(Arrays.asList(-10,-10,-7,0,1,3)));
//        list.add(new LinkedList<>(Arrays.asList(2)));
//
//        Assert.assertEquals(maxDistance(list), 14);

        List<List<Integer>> list1 = new LinkedList<>();
        list1.add(new LinkedList<>(Arrays.asList(1,4,5)));
        list1.add(new LinkedList<>(Arrays.asList(0,2)));

        Assert.assertEquals(maxDistance(list1), 5);
    }
}
