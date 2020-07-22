package com.j2core.sts.leetcode.com.deleteOperationForTwoStrings;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int minDistanceOld(String str1, String str2) {

        int len1=str1.length();
        int len2 = str2.length();
        int [][] result = new int [len1+1][len2+1];

        for(int i=1;i<result.length;i++){
            for(int j=1;j<result[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    result[i][j] = result[i-1][j-1]+1;
                else
                    result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
            }
        }
        return (len1+len2) -(result[result.length-1][result[0].length-1]*2);
    }

    public int minDistance1(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0)
                    continue;
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }

    public int minDistance(String word1, String word2) {

        int[][] matrix = new int[word1.length()+1][word2.length()+1];

        for (int i = 0; i <= word1.length(); i++){
            for (int j = 0; j <= word2.length(); j++){
                if (i == 0){
                    matrix[i][j] = j;
                }else {
                    if (j == 0){
                        matrix[i][j] = i;
                    }else {
                        if (word1.charAt(i-1) == word2.charAt(j-1)){
                            matrix[i][j] = matrix[i-1][j-1];
                        }else {
                            matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1])+1;
                        }
                    }
                }
            }
        }

        return matrix[word1.length()][word2.length()];
    }

    public static int deletion_distance(String str1, String str2) {
        /* Well, this is typical dynamic programming problem

         I don't care what is on Wikipedia, actually, all algorithms like deletion distance, edit distance or common
         subsequence are nothing more than typical dynamic programming solution

         So, I'll solve it with dynamic programming and I bet a can of beer, that result will be similar to wikipedia
         */

        // Let's save some time
        if (str1 == null && str2 == null) return 0;
        if (str1 == null || str1.length() == 0) return str2.length();
        if (str2 == null || str2.length() == 0) return str1.length();

        // here is our matrix to keep solutions for substrings. Strings length + empty string as a corner case
        int[][] deletionMatrix = new int[str1.length() + 1][str2.length() + 1];

        // okay, we can easily say that zero string to any substring, the deletion distance is substring length, right?
        for (int i = 0; i < str1.length() + 1; i++) {
            deletionMatrix[i][0] = i;
        }
        for (int i = 0; i < str2.length() + 1; i++) {
            deletionMatrix[0][i] = i;
        }

        // Cool, so, now let's iterate through all the substrings of s2, trying to compare them to all possible
        // substrings of s1
        // For me, would be easier to think in terms of coordinates over matrix
        for (int y = 0; y < str2.length(); y++) {
            // okay, we just added one symbol to s2, let's iterate over all possible substrings of s1
            for (int x = 0; x < str1.length(); x++) {
                // okay, symbol added for s1, did it matched last symbol on s2?
                if (str1.charAt(x) == str2.charAt(y)) {
                    // technically, if ends matched, we can say that deletion distance is the same as for strings
                    // without these ends. So, xxxy and zzzy will have the same deletion distance as xxx and zzz
                    deletionMatrix[x + 1][y + 1] = deletionMatrix[x][y];
                } else {
                    // Okay, we are comparing xxxa and zzzb, I can tell that this is equivalent of xxx and zzzb + 1 or
                    // xxxa and zzz +1, right? Since we are looking for MINIMUM distance, let's choose SMALLEST
                    deletionMatrix[x + 1][y + 1] = Math.min(deletionMatrix[x][y + 1], deletionMatrix[x + 1][y]) + 1;
                }
            }
        }

        // a bit of address magic, size of matrix is +1 to string sizes for empty strings. So, full str1 vs str2 will be
        // at these coordinates
        return deletionMatrix[str1.length()][str2.length()];
    }

    @Test
    public void test(){

        Assert.assertEquals(minDistance("at", "cat"), 1);
        Assert.assertEquals(minDistance("boat", "got"), 3);
        Assert.assertEquals(minDistance("thought", "sloughs"), 6);

    }
}
