package com.j2core.sts.leetcode.com.longestStringChain;

import java.util.Arrays;

public class Solution {

    public int longestStrChain(String[] words) {

        if (words == null || words.length == 0) return 0;

        int length = words.length;
        if (length == 1) return 1;

        Arrays.sort(words,(a, b) -> a.length() - b.length());

        int max_possible = 0;
        int[] options = new int[length];
        for(int i = 0; i < length; ++i){
            options[i] = 1;
            for(int j = i-1; j >= 0; --j){
                if(words[i].length()-words[j].length() > 1) break;
                if(words[i].length()-words[j].length() == 0) continue;
                if(checkStrings(words[i],words[j]) == words[j].length()){
                    options[i] = Math.max(options[j] + 1,options[i]);
                }
            }

            max_possible = Math.max(max_possible,options[i]);
        }


        return max_possible;
    }

    private int checkStrings(String a,String b){
        int result = 0,len1 = a.length(),len2 = b.length();

        for(int i=0;i<len1 && result < len2;++i){
            if(a.charAt(i) == b.charAt(result)) result++;
        }

        return result;
    }
}
