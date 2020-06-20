package com.j2core.sts.leetcode.com.arrays.findKClosestElements;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int length = arr.length;
        if (length == k) return createList(arr, -1, length);
        if (arr[0] > x) return createList(arr, -1, k);
        if (arr[length-1] < x) return createList(arr, length-k-1, length);
        int i = 0;

        while (arr[i] < x){
            i++;
        }

        int j = i-1;

        while ((i)-(j+1) < k){
            if (i == length){
                j--;
            }else if (j == -1){
                i++;
            }else {
                if (Math.abs(arr[i]-x) < Math.abs(arr[j]-x)){
                    i++;
                }else {
                    j--;
                }
            }
        }
        return createList(arr, j, i);
    }

    private List<Integer> createList(int[] array, int first, int last){

        ArrayList<Integer> list = new ArrayList<>(last-first);
        for (int i = first+1; i < last; i++){
            list.add(array[i]);
        }
        return list;
    }

    @Test
    public void test(){
        List<Integer> array = findClosestElements(new int[]{1,1,1,10,10,10}, 1, 9); //{1,2,3,4}
        List<Integer> array7 = findClosestElements(new int[]{1,2,3,4,5}, 5, 3); //{1,2,3,4,5}


        List<Integer> array1 = findClosestElements(new int[]{1,2,3,4,5}, 4, 3); //{1,2,3,4}
        List<Integer> array2 = findClosestElements(new int[]{1,2,3,4,5}, 4, -1);//{1,2,3,4}
        List<Integer> array3 = findClosestElements(new int[]{1,2,3,4,5}, 4, 7);//{2,3,4,5}
        List<Integer> array4 = findClosestElements(new int[]{1,2,4,5,6}, 4, 3);//{1,2,4,5}
        List<Integer> array5 = findClosestElements(new int[]{1,3,4,5,6}, 4, 2);//{1,3,4,5}
        List<Integer> array6 = findClosestElements(new int[]{1,2,4,5,7}, 4, 6);//{2,4,5,7}

    }
}
