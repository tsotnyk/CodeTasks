package com.j2core.sts.leetcode.com.previousPermutationWithOneSwap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int[] prevPermOpt2(int[] A) {

        int headPair = 0;
        int first = 0;
        int second = 0;
        int indexHeadPair = -1;
        int indexFirst = -1;
        int indexSecond = -1;

        for (int i = 1; i < A.length; i++){
            if (A[i] > headPair && A[i] < A[0]){
                headPair = A[i];
                indexHeadPair = i;
            }
            if (first < A[i]){
                second = first;
                indexSecond = indexFirst;
                first = A[i];
                indexFirst = i;
            }
            if (A[i] < first && second < A[i]){
                second = A[i];
                indexSecond = i;
            }
        }

        return findBiggerPermutationThanSmallerOriginNum(A, indexHeadPair, indexFirst, indexSecond, headPair, first, second);
    }

    private int[] findBiggerPermutationThanSmallerOriginNum(int[] a, int indexHeadPair, int indexFirst, int indexSecond,
                                                            int headPair, int first, int second) {

        StringBuilder base = new StringBuilder();
        StringBuilder permutation = new StringBuilder();

        for (int i = 0; i < a.length; i++){
            base.append(a[i]);
            if (i == indexFirst){
                permutation.append(second);
            }else if (i == indexSecond){
                permutation.append(first);
            }else {
                permutation.append(a[i]);
            }
        }

        int baseNum = Integer.parseInt(base.toString());
        int permutationNum = Integer.parseInt(permutation.toString());

        if (indexFirst != -1 && indexSecond != -1 && permutationNum < baseNum) {
            a[indexFirst] = second;
            a[indexSecond] = first;
        } else if (indexHeadPair != -1) {
            a[indexHeadPair] = a[0];
            a[0] = headPair;
        }

        return a;
    }

    public int[] prevPermOpt1(int[] A) {

        int index = -1;
        int min = Integer.MAX_VALUE;
        int length = A.length;
        int number = 0;

        for (int i = length-1; i >= 1; i--) {
            if (A[i] < min) {
                min = A[i];
            }
            if (min < A[i-1]) {
                number = A[i-1];
                index= i;
                break;
            }
        }

        if (index == -1)
            return A;

        int maxTemp = -1;
        int indexer = -1;

        for (int i = index; i< length; i++){
            if (A[i] > maxTemp && A[i] < number) {
                maxTemp  = A[i];
                indexer = i;
            }
        }

        int tmp = A[indexer];
        A[indexer] = A[index-1];
        A[index-1] = tmp;

        return A;
    }

    @Test
    public void test(){

        int[] result1 = prevPermOpt1(new int[]{3,2,1});
        Assert.assertEquals(result1, new int[]{3,1,2});

        int[] result2 = prevPermOpt1(new int[]{1,1,5});
        Assert.assertEquals(result2, new int[]{1,1,5});

        int[] result3 = prevPermOpt1(new int[]{1,9,4,6,7});
        Assert.assertEquals(result3, new int[]{1,7,4,6,9});

        int[] result4 = prevPermOpt1(new int[]{3,1,1,3});
        Assert.assertEquals(result4, new int[]{1,3,1,3});

        int[] result5 = prevPermOpt1(new int[]{1,1,1,1,1,1,1,1});
        Assert.assertEquals(result5, new int[]{1,1,1,1,1,1,1,1});

        int[] result6 = prevPermOpt1(new int[]{2,1,2,1,1,2,2,1});
        Assert.assertEquals(result6, new int[]{2,1,2,1,1,2,1,2});
    }
}

