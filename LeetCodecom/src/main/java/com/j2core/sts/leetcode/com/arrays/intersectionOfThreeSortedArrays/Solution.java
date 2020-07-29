package com.j2core.sts.leetcode.com.arrays.intersectionOfThreeSortedArrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> arraysIntersectionHashSet(int[] arr1, int[] arr2, int[] arr3) {

        HashSet<Integer> set1  = new HashSet<>();
        for (int num : arr1){
            set1.add(num);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : arr2){
            set2.add(num);
        }

        List<Integer> list = new LinkedList<>();
        for (int num : arr3){
            if (set1.contains(num) && set2.contains(num)){
                list.add(num);
            }
        }

        return list;
    }

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        List<Integer> list = new LinkedList<>();

        while (index1 < arr1.length && index2 < arr2.length && index3 < arr3.length){

            if (arr1[index1] == arr2[index2] && arr1[index1] == arr3[index3]){
                list.add(arr1[index1]);
                index1++;
                index2++;
                index3++;
            }else{
                if (arr1[index1] < arr2[index2]){
                    index1++;
                }else if (arr2[index2] < arr3[index3]){
                    index2++;
                }else if (arr3[index3] < arr1[index1]){
                    index3++;
                }
            }
        }

        return list;
    }
}
