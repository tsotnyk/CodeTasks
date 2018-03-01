package com.j2core.sts.leetcode.com.numberOfSegmentsInString;

public class Solution {
    public int countSegments(String s) {

        int index;
        int result = 0;

        if (s.length() < 1) return result;
        if (s.length() == 1){
            if (s.charAt(0) == ' ') {
                return 0;
            }else {
                return 1;
            }
        }

        index = s.indexOf(" ");

        if (index == -1){
            return 1;
        }else {

            int oldIndex = -1;
            while (index != -1 && oldIndex+1 < s.length()) {

                if (oldIndex+1 != index) {
                    result++;
                }
                oldIndex = index;
                index = s.indexOf(" ", oldIndex+1);
            }

            if (oldIndex < s.length()-1){
                result++;
            }

            return result;
        }
    }
}
