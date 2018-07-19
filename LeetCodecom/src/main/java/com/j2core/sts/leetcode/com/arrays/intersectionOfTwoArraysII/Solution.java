package com.j2core.sts.leetcode.com.arrays.intersectionOfTwoArraysII;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] smaller;
        int[] bigger;

        if (nums2.length < nums1.length){

            smaller = nums2;
            bigger = nums1;
        }else {

            smaller = nums1;
            bigger = nums2;
        }

        List<Integer> resultList = new LinkedList<>();

        int index = 0;

        for (int j = 0; j < bigger.length; j++){

            if (index < smaller.length){

                if (bigger[j] == smaller[index]){

                    resultList.add(bigger[j]);
                    index++;

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

    @Test
    public void test(){

        int[] result = intersect(new int[]{-2147483648, 1, 2, 3}, new int[]{1, -2147483648, -2147483648});

        Assert.assertEquals(result, new int[]{-2147483648, 1});

    }

}
