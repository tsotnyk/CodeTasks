package com.j2core.sts.leetcode.com.tripleByte;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution22 {

    public static int deletion_distance(String str1, String str2){

        if (str1.length() < 1) return str2.length();
        if (str2.length() < 1) return str1.length();

        int[][] matrix = new int[str1.length()+1][str2.length()+1];

        for (int k = 0; k <= str2.length(); k++){
            matrix[0][k] = k;
        }

        for (int i = 1; i <= str1.length(); i++){
            for (int j = 0; j <= str2.length(); j++){
                if(j == 0){
                    matrix[i][j] = matrix[i-1][j]+1;
                }else {
                    if(str1.charAt(i-1) != str2.charAt(j-1)){
                        matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1])+1;
                    }else {
                        matrix[i][j] = matrix[i-1][j-1];
                    }
                }
            }
        }

        return (matrix[str1.length()][str2.length()]);
    }

    @Test
    public void test(){

        Assert.assertEquals(deletion_distance("at", "cat"), 1);
        Assert.assertEquals(deletion_distance("boat", "got"), 3);
        Assert.assertEquals(deletion_distance("thought", "sloughs"), 6);
        Assert.assertEquals(deletion_distance("bat", "cat"), 2);

    }

}
