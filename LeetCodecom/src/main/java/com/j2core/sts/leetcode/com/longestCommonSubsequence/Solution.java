package com.j2core.sts.leetcode.com.longestCommonSubsequence;

import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public int longestCommonSubsequenceOld(String text1, String text2) {

        int length = text1.length();
        int len2 = text2.length();
        int [][] result = new int [length+1][len2+1];

        for(int i=1;i<result.length;i++){
            for(int j=1;j<result[0].length;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    result[i][j] = result[i-1][j-1]+1;
                else
                    result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
            }
        }
        return result[result.length-1][result[0].length-1];
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] matrix = new int[text2.length()+1][text1.length()+1];

        for (int i = 1; i <= text2.length(); i++){
            for (int j = 1; j <= text1.length(); j++){
                if (text1.charAt(j-1) == text2.charAt(i-1)){
                    matrix[i][j] = matrix[i-1][j-1]+1;
                }else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        return matrix[text2.length()][text1.length()];

    }
    @Test
    public void test(){

        int result = longestCommonSubsequence("papmretkborsrurgtina","nsnupotstmnkfcfavaxgl");
        System.out.println(result);
    }
}
