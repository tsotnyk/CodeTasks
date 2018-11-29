package com.j2core.sts.leetcode.com.largestNumber;

import java.util.*;

public class Solution {

    public String largestNumber(int[] nums) {

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



}
