package com.j2core.sts.leetcode.com.findKClosestElements;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result;

        if (x < arr[0]){
            result = createResultList(arr, k, -1);
        }else if(x > arr[arr.length-1]){
            result = createResultList(arr, k, -2);
        }else {

            int indexX = findIndexXElement(arr, x);

            result = createResultList(arr, k, indexX);

        }

        return result;
    }


    private int findIndexXElement(int[] array, int x){

        int start = 0;
        int stop = array.length-1;
        int median = array.length/2;
        int index = -1;

        while (index < 0){
            int flag = findIndex(array, start, stop, median, x);

            switch (flag){
                case -2:
                    index = start;
                    break;
                case 2:
                    index = stop;
                    break;
                case 0:
                    index = median;
                    break;
                case -1:
                    start = median;
                    break;
                case 1:
                    stop = median;
                    break;
                default:
                    index = flag;
                    break;
            }
            median = start + ((stop - start)/2);
        }

        return index;
    }


    private int findIndex(int[] array, int start, int stop, int median, int x){

        int result;
        if (array[start] >= x){
            result = -2;
        }else if(array[stop] == x){
            result = 2;
        }else {

            if (stop - start < 2){
                result = stop;
            }else {
                result = Integer.compare(array[median], x);

            }

        }
        return result;
    }

    private List<Integer> createResultList(int[] array, int k, int index){

        List<Integer> result = new LinkedList<>();
        List<Integer> listScope = createScopeList(array.length, index, k);

        for (int i = listScope.get(0); i < listScope.get(1); i++){

            result.add(array[i]);
        }

        return result;
    }


    private List<Integer>  createScopeList(int length, int index, int k){

        int startIndex;
        int stopIndex;
        int delta = 0;

        if (index < 0){
            if (index == -1){
                startIndex = 0;
                stopIndex = k;
            }else {
                startIndex = length - k;
                stopIndex = length;
            }
        }else {
            startIndex = index - k;
            if (startIndex  < 0){
                delta = Math.abs(startIndex);
                startIndex = 0;
            }
            stopIndex = index + delta;
        }

        List<Integer> result = new LinkedList<>();

        result.add(startIndex);
        result.add(stopIndex);

        return result;

    }


    @Test
    public void test(){

        List<Integer> result = findClosestElements(new int[]{0,1,1,1,2,3,6,7,8,9}, 9, 4);

        Assert.assertTrue(result.size() == 9);

    }
}
