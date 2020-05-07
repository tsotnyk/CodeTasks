package com.j2core.sts.leetcode.com.arrays.majorityElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {


    public int majorityElementOld(int[] nums) {

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


    public int majorityElement1(int[] nums) {

        int half = nums.length/2+1;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ){

            int counter = 1;
            int num = nums[i++];
            while (i < nums.length && nums[i] == num){
                counter++;
                i++;
            }
            if (counter >= half) return num;
        }

        return 0;
    }

    public int majorityElement2(int[] nums) {

        int half = (nums.length/2) + 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int tmp = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++tmp);
            if (tmp >= half) return nums[i];
        }

        return 0;
    }

    public int majorityElement3(int[] nums) {

        int half = (nums.length/2) + 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] array = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            int tmp = map.getOrDefault(num, index);
            array[tmp] += 1;
            if (array[tmp] >= half) return num;
            if (tmp == index) {
                map.put(num, index++);
            }
        }

        return 0;
    }

    public int majorityElement(int[] nums) {

        int half = (nums.length/2) + 1;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                int num = nums[i];
                int counter = 1;
                for (int j = i+1; j < nums.length; j++){
                    if (nums[j] == num){
                        counter++;
                    }
                }
                if (counter >= half) return num;
                set.add(num);
            }
        }

        return 0;
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
        Assert.assertEquals(result, 3);
    }
}
