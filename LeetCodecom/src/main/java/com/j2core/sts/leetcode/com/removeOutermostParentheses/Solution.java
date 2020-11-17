package com.j2core.sts.leetcode.com.removeOutermostParentheses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public String removeOuterParenthesesOld(String S) {

        StringBuilder builder = new StringBuilder();
        int startIndex = 0;
        int counter = 1;
        for (int i = 1; i < S.length(); i++){
            if (counter == 0){
                builder.append(S.substring(startIndex+1, i-1));
                startIndex = i;
            }
            if (S.charAt(i) == '('){
                counter++;
            }else {
                counter--;
            }
        }

        builder.append(S.substring(startIndex+1, S.length()-1));
        return builder.toString();
    }

    public String removeOuterParentheses(String S) {

        StringBuilder builder = new StringBuilder();
        int counter = 0;
        for (char symbol : S.toCharArray()){
            if (symbol == '('){
                counter++;
                if (counter > 1) builder.append(symbol);
            }else {
                counter--;
                if (counter > 0) builder.append(symbol);
            }
        }

        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(removeOuterParentheses("(()())(())"), "()()()");
        Assert.assertEquals(removeOuterParentheses("(()())(())(()(()))"), "()()()()(())");
        Assert.assertEquals(removeOuterParentheses("()()"), "");

    }
}
