package com.j2core.sts.leetcode.com.sortArrayByParity;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[] sortArrayByParityOld(int[] A) {

        List<Integer> even = new LinkedList<>();
        List<Integer> odd = new LinkedList<>();

        for (int num : A) {

            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        even.addAll(odd);

        int index = 0;

        for (Integer num : even){

            A[index++] = num;
        }

        return A;
    }


    public int[] sortArrayByParity(int[] nums) {

        int indexR = nums.length-1;
        int indexL = 0;

        while (indexR > indexL){

            if (nums[indexR]%2 != 0){
                indexR--;
            }else{
                int tmp = nums[indexL];
                nums[indexL] = nums[indexR];
                nums[indexR] = tmp;
                indexL++;
            }
        }

        return nums;
    }

    @Test
    public void test(){

        Assert.assertArrayEquals(new int[]{4,2,1,3}, sortArrayByParity(new int[]{3,1,2,4}));
    }

}
