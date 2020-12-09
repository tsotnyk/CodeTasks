package com.j2core.sts.leetcode.com.largestNumber;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public String largestNumberOld(int[] nums) {

        Map<Integer, List<String>> numMap = createMap(nums);
        StringBuilder builder = new StringBuilder();

        for (int i = 9; i > -1; i--){

            List<String> numList = numMap.get(i);
            numList.sort(new MyComparator());

            for (String num : numList){

                builder.append(num);
            }
        }
        return builder.toString();
    }

    private Map<Integer, List<String>> createMap(int[] nums){

        Map<Integer, List<String>> result = new HashMap<>();

        for (int i = 0; i < 10; i++){
            result.put(i, new LinkedList<>());
        }

        for (int num : nums){
            String first = String.valueOf(num);
            switch (first.charAt(0)){
                case '9':
                    result.get(9).add(first);
                    break;
                case '8':
                    result.get(8).add(first);
                    break;
                case '7':
                    result.get(7).add(first);
                    break;
                case '6':
                    result.get(6).add(first);
                    break;
                case '5':
                    result.get(5).add(first);
                    break;
                case '4':
                    result.get(4).add(first);
                    break;
                case '3':
                    result.get(3).add(first);
                    break;
                case '2':
                    result.get(2).add(first);
                    break;
                case '1':
                    result.get(1).add(first);
                    break;
                default:
                    result.get(0).add(first);
                    break;
            }

        }
        return result;
    }

    class MyComparator implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {


            String first = (String) o1;
            String second = (String) o2;
            if (first.length() == second.length() && first.length() == 1) return 0;
            String small = first.length() < second.length() ? first : second;
            String big = second.length() > first.length() ? second : first;

            if (small.length() == 1){
                int smallNum =small.charAt(0);
                for (int i = 1; i < big.length(); i++){
                    int tmp = big.charAt(i);
                    if (smallNum < tmp){
                        if (small.equals(first)){
                            return -1;
                        }else {
                            return 1;
                        }
                    }else if (smallNum > tmp){
                        if (small.equals(first)){
                            return 1;
                        }else {
                            return -1;
                        }
                    }
                }
            }
            return 0;
        }
    }

    public String largestNumber(int[] nums) {

        List<String> numList = new LinkedList<>();
        for (int num : nums){
            numList.add(String.valueOf(num));
        }

        Collections.sort(numList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                int index1 = 0;
                int index2 = 0;

                if (s1.charAt(index1) == s2.charAt(index2)){

                    while (index1 < s1.length() && index2 < s2.length()){
                        index1++;
                        index2++;
                        if (index1 == s1.length()){
                            if (index2 == s2.length()) break;
                            index1 = 0;
                        }
                        if (index2 == s2.length()){
                            index2 = 0;
                        }
                        if (s1.charAt(index1) == s2.charAt(index2)){
                            continue;
                        }else {
                            return s2.charAt(index2) - s1.charAt(index1);
                        }
                    }

                    if (index1 == s1.length()){
                        index1--;
                    }
                    if (index2 == s2.length()){
                        index2--;
                    }
                }
                return s2.charAt(index2) - s1.charAt(index1);
            }
        });

        if (numList.get(0).equals("0")) return "0";

        StringBuilder builder = new StringBuilder();

        for (String num : numList){
            builder.append(num);
        }
        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(largestNumber(new int[]{3544,3013,3061,468}), "468354430613013");
        Assert.assertEquals(largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247}), "9609938824824769735703560743981399");

        Assert.assertEquals(largestNumber(new int[]{3,30,34,5,9}), "9534330");
        Assert.assertEquals(largestNumber(new int[]{10,2}), "210");
        Assert.assertEquals(largestNumber(new int[]{1,1,1}), "111");

    }
}
