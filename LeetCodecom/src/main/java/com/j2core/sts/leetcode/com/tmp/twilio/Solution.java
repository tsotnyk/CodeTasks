package com.j2core.sts.leetcode.com.tmp.twilio;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public static List<Integer> itemsSort(List<Integer> items) {
        // Write your code here

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : items){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        items.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {

                int count1 = map.get(t1);
                int count2 = map.get(t2);
                if (count1 == count2){
                    return t1.compareTo(t2);
                }else{
                    return count1 - count2;
                }
            }
        });

        return items;

    }

    @Test
    public void test1(){

        Assert.assertEquals(itemsSort(new LinkedList<>(Arrays.asList(4,5,6,5,4,3))), new LinkedList<>(Arrays.asList(3,6,4,4,5,5)));
    }

    public static List<String> missingWords(String s, String t) {
        // Write your code here

        String[] splitS = s.split(" ");
        String[] splitT = t.split(" ");
        List<String> missingWords = new LinkedList<>();

        int index1 = 0;
        int index2 = 0;

        while (index1 < splitS.length && index2 < splitT.length){

            if (splitS[index1].equals(splitT[index2])){
                index1++;
                index2++;
            }else {
                missingWords.add(splitS[index1++]);
            }
        }

        while (index1 < splitS.length){
            missingWords.add(splitS[index1++]);
        }

        return missingWords;
    }

    @Test
    public void test2(){

        Assert.assertEquals(missingWords("I like cheese", "like"), new LinkedList<>(Arrays.asList("I", "cheese")));

    }

    public static int fourthBit(int number) {
        // Write your code here

        String binaryNum = Integer.toBinaryString(number);

        if (binaryNum.length() < 4) return 0;

        return binaryNum.charAt(binaryNum.length()-4) == '1' ? 1 : 0;

    }

    @Test
    public void test3(){

        Assert.assertEquals(fourthBit(23), 0);
        Assert.assertEquals(fourthBit(2), 0);
        Assert.assertEquals(fourthBit(32), 0);
        Assert.assertEquals(fourthBit(77), 1);
    }

    public static long kSub(int k, List<Integer> nums) {
        // Write your code here
//        long counter = 0;
//        int[] matrix = new int[nums.size()];
//        int index = 0;
//        int sum = 0;
//        for (int num : nums){
//            sum += num;
//            matrix[index++] = sum;
//            if (sum%k == 0) counter++;
//        }
//
//        index = 1;
//
//        for (int num : nums){
//
//            for (int i = index; i < matrix.length; i++){
//                int tmp = matrix[i] - num;
//                matrix[i] = tmp;
//                if (tmp%k == 0) counter++;
//            }
//            index++;
//        }
//
//        return counter;


        int[] sums = new int[nums.size()];
        int[] counters = new int[nums.size()+1];
        int sum = 0;
        int counter = 0;
        int index = 0;
        for (int num : nums){
            sum += num;
            sums[index] = sum;
            if (sum %k == 0) counter++;
            index++;
        }
        counters[0] = counter;
        index = 1;
        int delta = 1;
        for (int num : nums){
            if (num%k == 0){
                counters[index] = counters[index-delta]-1;
                delta = 1;
            }else {
                delta++;
            }
            index++;
        }
        counter = 0;
        for (int num : counters){
            counter += num;
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(kSub(5, new LinkedList<>(Arrays.asList(5,10,11,9,5))), 10);
    }
}
