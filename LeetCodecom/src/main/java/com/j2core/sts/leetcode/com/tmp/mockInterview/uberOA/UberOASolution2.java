package com.j2core.sts.leetcode.com.tmp.mockInterview.uberOA;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UberOASolution2 {

    public int findUnsortedSubarray(int[] nums) {

        if (nums.length < 2) return 0;
        int indexS = 0;
        int indexE = nums.length-1;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] >= nums[indexS] && indexS+1 == i) {
                indexS++;
                continue;
            }
            if (nums[i] < nums[indexS]) {
                indexS--;
                if (indexS < 0) break;
                i--;
            }
        }

        for (int j = nums.length-2; j > -1; j--){
            if (nums[j] <= nums[indexE] && j == indexE-1){
                indexE--;
                continue;
            }
            if (nums[j] > nums[indexE]) {
                indexE++;
                if (indexE == nums.length) break;
                j++;
            }
        }
        return indexE > indexS ? indexE-indexS-1 : 0;
    }

    @Test
    public void test1(){

        Assert.assertEquals(2, findUnsortedSubarray(new int[]{1,3,2,3,3}));

        Assert.assertEquals(0, findUnsortedSubarray(new int[]{1,2,3,3,3}));

        Assert.assertEquals(0, findUnsortedSubarray(new int[]{1,2,3,4}));

        Assert.assertEquals(5, findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }

    public List<Integer> pancakeSortV1(int[] arr) {

        List<Integer> result = new LinkedList<>();
        int index = arr.length;

        while (index > 1){
            int numIndex = 0;
            for (int i = index-1; i > 0; i--){
                if (arr[i] == index){
                    numIndex = i;
                    break;
                }
            }

            if (numIndex != 0){
                result.add(numIndex+1);
                swapNums(arr, 0, numIndex);
            }

            result.add(index);
                swapNums(arr,0, index-1);
            index--;
        }
       return  result;
    }

    private void swapNums(int[] array, int indexS, int indexE){

        while (indexS < indexE){
            int tmp = array[indexS];
            array[indexS] = array[indexE];
            array[indexE] = tmp;
            indexS++;
            indexE--;
        }
    }

    public List<Integer> pancakeSort(int[] arr) {
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=arr.length;i>=1;i--)
        {
            int j=0;
            for(;j<arr.length;j++)
            {
                if(arr[j]==i)
                    break;
            }

            int k=0;
            if(k!=j)
                al.add(j+1);
            while(k<j)
            {
                int temp=arr[j];
                arr[j]=arr[k];
                arr[k]=temp;
                k++;
                j--;
            }

            k=i-1;
            j=0;
            if(k!=j)
                al.add(k+1);
            while(j<k)
            {
                int temp=arr[j];
                arr[j]=arr[k];
                arr[k]=temp;
                k--;
                j++;
            }
        }

        return al;
    }

    @Test
    public void test2(){

        Assert.assertEquals(new LinkedList<>(Arrays.asList(4,2,4,3)), pancakeSort(new int[]{3,2,4,1}));
    }
}
