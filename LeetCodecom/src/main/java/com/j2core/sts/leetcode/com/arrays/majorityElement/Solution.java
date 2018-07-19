package com.j2core.sts.leetcode.com.arrays.majorityElement;

import org.testng.annotations.Test;

public class Solution {


    public int majorityElement(int[] nums) {

        if (nums.length < 2){

            return nums[0];

        }else {

            int amountMajorityElement = nums.length / 2;
            int index = 0;
            int[] numbers = new int[amountMajorityElement+1];
            int[] counters = new int[amountMajorityElement+1];

            for (int i = 0; i < nums.length; i++) {

                if (i == 0){

                    numbers[i] = nums[i];
                    counters[i] = 1;
                    index++;

                }else {

                    int numIndex = index;

                    for (int j = 0; j < index; j++){

                        if (numbers[j] == nums[i]){
                            numIndex = j;
                            break;
                        }
                    }

                    if (numIndex == index){

                        numbers[index] = nums[i];
                        counters[index] = 1;
                        index++;

                    }else {

                        counters[numIndex] = counters[numIndex] + 1;

                    }

                }

            }

            int resultIndex = -1;

            for (int k = 0; k < index; k++){

                if (counters[k] > amountMajorityElement){
                    resultIndex = k;
                }

            }
            return numbers[resultIndex];
        }
    }










//    public int majorityElement(int[] nums) {
//
//        if (nums.length < 2){
//
//            return nums[0];
//
//        }else {
//
//            int amountMajorityElement = nums.length / 2;
//
//            List<Integer> uniqueElements = new LinkedList<>();
//
//            for (int i = 0; i <= nums.length / 2; i++) {
//
//                int num = nums[i];
//                if (!uniqueElements.contains(num)) {
//                    int counter = 1;
//                    for (int j = i + 1; j < nums.length; j++) {
//
//                        if (num == nums[j]) {
//
//                            counter++;
//                        }
//
//                    }
//
//                    if (counter > amountMajorityElement) {
//
//                        return num;
//                    }
//
//                }
//            }
//        }
//
//        return -1;
//    }

    @Test
    public void testiku(){


        int[] tn = new int[]{3,2,3};

        int result = majorityElement(tn);

        System.out.print(result);

    }
}
