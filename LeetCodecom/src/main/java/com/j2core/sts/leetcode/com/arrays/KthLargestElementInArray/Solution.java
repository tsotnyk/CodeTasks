package com.j2core.sts.leetcode.com.arrays.KthLargestElementInArray;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public int findKthLargestOld(int[] nums, int k) {

        int[] largestArray = new int[k];
        largestArray[0] = nums[0];
        int index = 1;

        for (int i = 1; i < nums.length; i++){

            boolean flag = true;

            for (int j = 0; j < index; j++){

                if (nums[i] > largestArray[j]){

                    if (j < k-1){

                        System.arraycopy(largestArray, j, largestArray, j+1, k-j-1);
                    }

                    largestArray[j] = nums[i];
                    flag = false;
                    if (index < k) index++;
                    break;

                }
            }

            if (flag && index < k){
                largestArray[index] = nums[i];
                index++;
            }
        }

        return largestArray[k-1];
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int size = 0;
        for (int i = 0; i < nums.length; i++){
            if (size < k){
                queue.add(nums[i]);
                size++;
            }else {
                if (nums[i] > queue.peek()){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }

        return queue.peek();
    }


    @Test
    public void test(){

        int result = findKthLargest(new int[]{3,2,1,5,6,4}, 2);

        Assert.assertEquals(5, result);

//        int result = findKthLargest(new int[]{7,6,5,4,3,2,1}, 2);
//
//        Assert.assertEquals(6, result);

    }
}
