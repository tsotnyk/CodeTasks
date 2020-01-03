package com.j2core.sts.leetcode.com.deleteOperationForTwoStrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minDistance(String word1, String word2) {

        int len1=word1.length();
        int len2 = word2.length();
        int [][] result = new int [len1+1][len2+1];

        for(int i=1;i<result.length;i++){
            for(int j=1;j<result[0].length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    result[i][j] = result[i-1][j-1]+1;
                else
                    result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
            }
        }
        return (len1+len2) -(result[result.length-1][result[0].length-1]*2);
    }
}
