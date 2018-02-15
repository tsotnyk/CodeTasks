package com.j2core.sts.leetcode.com.FirstUniqueCharacterInString;

public class Solution {

    public int firstUniqChar(String s) {
        int result = -1;

        for (int i = 0; i < s.length(); i++){

            char tmp = s.charAt(i);
            if (s.lastIndexOf(tmp) == i && s.indexOf(tmp) == i){
                result = i;
                break;
            }
            while (i < s.length()-1 && tmp == s.charAt(i+1)){
                i++;
            }

        }

        return result;
    }
}
