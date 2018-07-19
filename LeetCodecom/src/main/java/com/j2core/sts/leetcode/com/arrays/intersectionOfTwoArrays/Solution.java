package com.j2core.sts.leetcode.com.arrays.intersectionOfTwoArrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        int[] smaller;
        int[] bigger;

        if (nums2.length < nums1.length){

            smaller = nums2;
            bigger = nums1;
        }else {

            smaller = nums1;
            bigger = nums2;
        }

        Arrays.sort(smaller);
        Arrays.sort(bigger);

        List<Integer> resultList = new LinkedList<>();

        int index = 0;

        for (int j = 0; j < bigger.length; j++){

            if (index < smaller.length){

                if (bigger[j] == smaller[index]){

                    if (!resultList.contains(bigger[j])) {
                        resultList.add(bigger[j]);
                        index++;
                    }
                }else if(bigger[j] > smaller[index]){

                    index++;
                    j--;
                }

            }else break;

        }

        int[] result = new int[resultList.size()];

        for (int i = 0; i < result.length; i++){

            result[i] = resultList.get(i);
        }

        return result;

    }

}
