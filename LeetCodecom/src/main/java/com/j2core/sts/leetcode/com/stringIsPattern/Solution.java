package com.j2core.sts.leetcode.com.stringIsPattern;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean isPatternMatched(String string, String pattern){

        if (string == null && pattern == null) return true;
        if (string == null || pattern == null) return false;

        if (string.length() == 0 && pattern.length() == 0) return true;
        if (pattern.length() == 0) return false;

        if (pattern.length() == 1){
            return pattern.charAt(0) == '*' || pattern.charAt(0) == '.';
        }

        boolean[][] matrix = new boolean[string.length()+1][pattern.length()+1];
        matrix[0][0] = true;

        for (int i = 1; i <= pattern.length(); i++){
            char symbol = pattern.charAt(i-1);
            if (symbol == '.' || symbol == '*') {
                matrix[0][i] = matrix[0][i-1];
            }
        }

        for (int i = 1; i <= string.length(); i++){
            for (int j = 1; j <= pattern.length(); j++){
                char patternSymbol = pattern.charAt(j-1);
                if (patternSymbol == '*'){
                    if (matrix[i-1][j-1] || matrix[i][j-1] || matrix[i-1][j]){
                        matrix[i][j] = true;
                    }
                }else if (patternSymbol == '.'){
                    if (matrix[i-1][j-1] || matrix[i][j-1]){
                        matrix[i][j] = true;
                    }
                }else if (patternSymbol == '?'){
                    if (matrix[i-1][j-1]){
                        matrix[i][j] = true;
                    }
                }else {
                    if (patternSymbol == string.charAt(i-1) && matrix[i-1][j-1]){
                        matrix[i][j] = true;
                    }
                }
            }
        }

        return matrix[string.length()][pattern.length()];
    }

//    @Test
//    public void testCornerCases() {
//        Assert.assertTrue(isPatternMatched("",""));
//        Assert.assertFalse(isPatternMatched("asdfasdf",""));
//        Assert.assertFalse(isPatternMatched("asdfasdf",null));
//        Assert.assertFalse(isPatternMatched(null,"*"));
//        // Most important case, when string is empty and pattern is all permissive
//        Assert.assertTrue(isPatternMatched("","*"));
//        Assert.assertFalse(isPatternMatched("","*a*"));
//    }
//
//    @Test
//    public void testSimpleCases() {
//        Assert.assertTrue(isPatternMatched("osaudfh","."));
//        Assert.assertTrue(isPatternMatched("osaudfh","*"));
//        Assert.assertTrue(isPatternMatched("osaudfh","?*"));
//        Assert.assertFalse(isPatternMatched("osa","?n*"));
//        Assert.assertFalse(isPatternMatched("osaudfh","?n*"));
//        Assert.assertTrue(isPatternMatched("osaudfh","?sa*f?"));
//        Assert.assertFalse(isPatternMatched("osaudfh","?sa*nf?"));
//
//    }
//
//    @Test
//    public void testAdvancedCases() {
//        Assert.assertFalse(isPatternMatched("osaudfh","?osa*nf?"));
//        Assert.assertFalse(isPatternMatched("osaudfh",".osa*nf?"));
//        Assert.assertFalse(isPatternMatched("osaudfh","*osa*nf?"));
//        Assert.assertTrue(isPatternMatched("osaunfh","*osa*nf?"));
//        Assert.assertTrue(isPatternMatched("osaudfh","*osa*df?"));
//    }

    @Test
    public void testCornerCases() {
        Assert.assertTrue(isPatternMatched("",""));
        Assert.assertFalse(isPatternMatched("asdfasdf",""));
        Assert.assertFalse(isPatternMatched("asdfasdf",null));
        Assert.assertFalse(isPatternMatched(null,"*"));
        // Most important case, when string is empty and pattern is all permissive
        Assert.assertTrue(isPatternMatched("","*"));
        Assert.assertFalse(isPatternMatched("","*a*"));
    }

    @Test
    public void testSimpleCases() {
        Assert.assertTrue(isPatternMatched("osaudfh","."));
        Assert.assertTrue(isPatternMatched("osaudfh","*"));
        Assert.assertTrue(isPatternMatched("osaudfh","?*"));
        Assert.assertFalse(isPatternMatched("osa","?n*"));
        Assert.assertFalse(isPatternMatched("osaudfh","?n*"));
        Assert.assertTrue(isPatternMatched("osaudfh","?sa*f?"));
        Assert.assertFalse(isPatternMatched("osaudfh","?sa*nf?"));

    }

    @Test
    public void testAdvancedCases() {
        Assert.assertFalse(isPatternMatched("osaudfh","?osa*nf?"));
        Assert.assertFalse(isPatternMatched("osaudfh",".osa*nf?"));
        Assert.assertFalse(isPatternMatched("osaudfh","*osa*nf?"));
        Assert.assertTrue(isPatternMatched("osaudfh","*osa*f?"));
        Assert.assertTrue(isPatternMatched("osaudfh","**"));
        Assert.assertTrue(isPatternMatched("o","**"));
        Assert.assertTrue(isPatternMatched("","**"));
    }
}
