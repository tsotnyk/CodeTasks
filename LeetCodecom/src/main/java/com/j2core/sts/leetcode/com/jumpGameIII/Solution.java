package com.j2core.sts.leetcode.com.jumpGameIII;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public boolean canReach(int[] arr, int start) {

        List<Integer> indexes = new LinkedList<>();

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                indexes.add(i);
            }
        }

        while (!indexes.isEmpty()){

            int index = indexes.remove(0);

            if (index == start) return true;

            indexes.addAll(findJumpIndexes(arr, index, start));
        }

        return false;
    }

    private List<Integer> findJumpIndexes(int[] array, int point, int lastIndex){

        int indexS = point-1;
        int indexB = point+1;
        List<Integer> list = new LinkedList<>();

        int jumpCounter = 1;
        while (indexS > -1){
            if (array[indexS] == jumpCounter++){
                list.add(indexS);
                if (indexS == lastIndex) return list;
            }
            indexS--;
        }

        jumpCounter = 1;
        while (indexB < array.length){
            if (array[indexB] == jumpCounter++){
                list.add(indexB);
                if (indexB == lastIndex){
                    return list;
                }
            }
            indexB++;
        }

        return list;
    }

    public boolean canReachRecursion(int[] arr, int p) {

        if(p < 0|| p >= arr.length) return false;

        if(arr[p] == 0)  return true;

        int k = arr[p];
        arr[p] = arr.length;

        return canReach(arr,p-k) || canReach(arr,p+k);
    }

    @Test
    public void test(){

        Assert.assertTrue(canReachRecursion(new int[]{4,2,3,0,3,1,2}, 0));
        Assert.assertTrue(canReachRecursion(new int[]{4,2,3,0,3,1,2}, 5));
        Assert.assertFalse(canReachRecursion(new int[]{3,0,2,1,2}, 2));
        Assert.assertTrue(canReachRecursion(new int[]{0,3,0,6,3,3,4}, 6));

    }
}
