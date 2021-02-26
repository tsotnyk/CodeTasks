package com.j2core.sts.leetcode.com.tmp.codesignal;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class PracticeTest {

    int[] mutateTheArray(int n, int[] a) {

        if (a.length == 1) return a;

        int[] newArray = new int[a.length];

        for (int i = 0; i < a.length; i++){
            if (i == 0){
                newArray[i] = a[i] + a[i+1];
            }else if(i == a.length-1){
                newArray[i] = a[i-1] + a[i];
            }else {
                newArray[i] = a[i-1] + a[i] + a[i+1];
            }
        }

        return newArray;
    }

    @Test
    public void test1(){

        Assert.assertEquals(mutateTheArray(5, new int[]{4,0,1,-2,3}), new int[]{4,5,-1,2,1});
    }

    int countTinyPairsV1(int[] a, int[] b, int k) {

        int counter = 0;
        int indexRight = b.length-1;
        int numLength = String.valueOf(k).length();

        for (int i : a) {
            String mergeNum = String.valueOf(i) + String.valueOf(b[indexRight]);
            if (mergeNum.length() < numLength) {
                counter++;
            } else if (mergeNum.length() == numLength && Integer.parseInt(mergeNum) < k) {
                counter++;
            }
            indexRight--;
        }
        return counter;
    }

    @Test
    public void test2(){

        Assert.assertEquals(countTinyPairs(new int[]{1,2,3}, new int[]{1,2,3}, 31), 2);
        Assert.assertEquals(countTinyPairs(new int[]{16,1,4,2,14}, new int[]{7,11,2,0,15}, 743), 4);

    }

    int[][] meanGroups(int[][] a) {

        HashMap<Float, List<Integer>> numMap = new HashMap<>();
        for (int i = 0; i < a.length; i++){
            float sum = 0;
            for (int num : a[i]){
                sum += num;
            }
            sum = sum/ a[i].length;
            if (numMap.containsKey(sum)){
                numMap.get(sum).add(i);
            }else {
                List<Integer> list = new LinkedList<>(Arrays.asList(i));
                numMap.put(sum, list);
            }
        }

        List<List<Integer>> arrayList = new LinkedList<>(numMap.values());
        Collections.sort(arrayList, (t1, t2) -> {

            return t1.get(0) - t2.get(0);
        });

        int[][] result = new int[arrayList.size()][];
        int i = 0;
        for (List<Integer> list : arrayList){
            int[] array = new int[list.size()];
            int index = 0;
            for (int num : list){
                array[index++] = num;
            }
            result[i++] = array;
        }

        return result;
    }

    long concatenationsSum(int[] a) {

        long sum = 0;

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length; j++){
                int length = String.valueOf(a[j]).length();
                sum += (a[i]*Math.pow(10, length)) + a[j];
            }
        }

        return sum;

//        List<String> list = new LinkedList<>();
//        for (int k : a) {
//            for (int i : a) {
//                list.add(String.valueOf(k) + String.valueOf(i));
//            }
//        }
//
//        long sum = 0;
//
//        for (String num : list){
//            sum += Long.parseLong(num);
//        }
//
//        return sum;
    }

    @Test
    public void test4(){

        Assert.assertEquals(concatenationsSum(new int[]{10,2}), 1344);
    }

    int countTinyPairs(int[] a, int[] b, int k) {

        int counter = 0;
        int indexRight = b.length-1;
        int numLength = String.valueOf(k).length();

        for (int i : a) {
            String mergeNum = String.valueOf(i) + String.valueOf(b[indexRight]);
            if (mergeNum.length() < numLength) {
                counter++;
            } else if (mergeNum.length() == numLength && Integer.parseInt(mergeNum) < k) {
                counter++;
            }
            indexRight--;
        }
        return counter;
    }

    long digitAnagrams(int[] a) {
        int counter = 0;
        HashMap<String, Integer> set = new HashMap<>();

        for (int num : a){

            int[] array = new int[10];
            while (num > 0){
                array[num%10] += 1;
                num /= 10;
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 10; i++){
                if (array[i] > 0){
                    int count = 0;
                    while (count++ < array[i]){
                        builder.append(i);
                    }
                }
            }
            String number = builder.toString();
            if (set.containsKey(number)){
                counter += set.get(number);
                set.put(number, set.get(number)+1);
            }else {
                set.put(number, 1);
            }
        }

        return  counter;
    }

//    long digitAnagrams(int[] a) {
//
//        int counter = 0;
//        HashMap<String, Integer> numMap = new HashMap<>();
//
//        for(int num : a){
//
//            char[] charArray = String.valueOf(num).toCharArray();
//            Arrays.sort(charArray);
//            String number = String.valueOf(charArray);
//            int pair = numMap.getOrDefault(number, 0);
//            if(pair > 0){
//                counter += pair;
//            }
//            numMap.put(number, pair+1);
//
//        }
//
//        return counter;
//    }

    @Test
    public void test(){

        Assert.assertEquals(digitAnagrams(new int[]{25,35,872,228,53,278,872}), 4);
    }
}
