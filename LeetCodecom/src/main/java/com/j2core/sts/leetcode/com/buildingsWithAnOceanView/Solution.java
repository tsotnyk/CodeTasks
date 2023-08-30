package com.j2core.sts.leetcode.com.buildingsWithAnOceanView;

import org.testng.annotations.Test;

import java.util.Stack;

public class Solution {

    public int[] findBuildings(int[] heights) {

        Stack<Integer> bV = new Stack<>();
        int maxH = 0;
        for (int i = heights.length-1; i > -1; i--){
            if (heights[i] <= maxH) continue;
            maxH = heights[i];
            bV.push(i);
        }

        int[] result = new int[bV.size()];

        for (int i = 0; i < result.length; i++){
            result[i] = bV.pop();
        }

        return result;
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == nums1.length) return;
        for(int i = 0; i < m; i++){

            nums1[i+m] = nums1[i];
        }

        int i = 0; int j = 0;

        while (j < n && m < nums1.length){
            if (nums2[j] < nums1[m]){
                nums1[i++] = nums2[j++];
            }else {
                nums1[i++] = nums1[m++];
            }
        }

       while (j < n){
           nums1[i++] = nums2[j++];
       }
    }

    @Test
    public void test(){


        int[] array = new int[]{1,2,3,0,0,0};
        int[] ar = new int[]{2,5,6};

        merge(array, 3, ar, 3);

        System.out.println();
    }
}
