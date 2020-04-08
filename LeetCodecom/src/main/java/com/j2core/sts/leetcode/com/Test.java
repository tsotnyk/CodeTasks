package com.j2core.sts.leetcode.com;

import org.testng.Assert;

import java.util.*;

public class Test {


    public int findMinDifference(List<String> timePoints) {

        if (timePoints.size() < 2) return 0;

        int[]  tmpList = createDeltaTimeList(timePoints);

        int result = 24*60;

        for (int i = 0; i < tmpList.length - 2; i = i+2){

            int tmpResult = result;
            int firstDelta = tmpList[i];
            int secondDelta = tmpList[i+1];

            for (int j = i+2; j < tmpList.length; j++){


                if (result == 0) return 0;
            }

        }

        return result;
    }

    private int[] createDeltaTimeList(List<String> timePoints){

        int[] result = new int[timePoints.size()*2];
        int index = 0;

        for (String point : timePoints){

            int h = Integer.parseInt(point.substring(0, 2));
            int m = Integer.parseInt(point.substring(3));

            if (h == 0 && m == 0){

                result[index++] = 0;
            }else {

                int deltaH = 24 - h;
                result[index++] = (deltaH * 60) - m;
            }

            result[index++] = (h*60) + m;
        }

        return result;
    }


    public boolean find132pattern(int[] nums) {

        int length = nums.length;
        for (int i = 0; i < length-2; i++){

            int first = nums[i];

            for (int j = i+1; j < length-1; j++){

                int second = nums[j];

                if (first >= second) {
                    break;
                }else if(first+1 != second){

                    for (int k = j + 1; k < length; k++) {

                        if (nums[k] < second && nums[k] > first){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }


    public String decodeAtIndex(String S, int K) {

        int length = 0;

        for (int i = 0; i < S.length(); i++) {

            if (Character.isDigit(S.charAt(i))) {

                int num = Integer.parseInt(String.valueOf(S.charAt(i)));
                int count = 1;
                while (count < num && K > length) {
                    K = K - length;
                    count++;
                }
                if (count != num) {
                    return decodeAtIndex(S, K);
                } else {
                    length = length * num;
                }
            } else {
                length++;
                K--;
                if (K == 0) {
                    return String.valueOf(S.charAt(i));
                }
            }
        }
        return "";
    }



//    public List<String> findAndReplacePattern(String[] words, String pattern) {
//
//        List<String> result = new LinkedList<>();
//        int length = pattern.length();
//
//        for (String word : words){
//
//            String tmp = equalsPattern(word, pattern, length);
//
//            if (tmp != null){
//
//                result.add(word);
//
//            }
//        }
//
//        return result;
//    }
//
//
//    private String equalsPattern(String word, String pattern, int length){
//
//        if (word.length() != length) return null;
//
//        Map<Character, Character> map = new HashMap<>();
//        int index = 0;
//
//        while (index < length){
//
//            char symbol = pattern.charAt(index);
//            char tmp = word.charAt(index);
//            if (map.containsKey(symbol)){
//                if (tmp != map.get(symbol)){
//                    return null;
//                }
//            }else {
//               if (map.containsValue(tmp)){
//                   return null;
//               }else {
//                   map.put(symbol, tmp);
//               }
//            }
//
//            index++;
//
//        }
//
//        return word;
//
//    }

    @org.testng.annotations.Test
    public void test(){

        boolean[] test = new boolean[5];

        List<String> tmp = new LinkedList<>();
        tmp.add("05.31");
        tmp.add("22.08");
        tmp.add("00.35");

        int result = findMinDifference(tmp);

        Assert.assertEquals(result, 147);

    }
}
