package com.j2core.sts.leetcode.com.string.validParenthesisString;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public boolean checkValidString(String s) {

        if (s.length() < 1) return true;
        if (s.length() < 2){
            return s.charAt(0) == '*';
        }
        char[] line = s.toCharArray();
        int index = s.lastIndexOf('(');

        while (index > -1){
            if (!removePair('(', index, line)) return false;
            index = lastIndex(line, index);
        }

        if (!isEmptyLine(line)){
            index = firstIndex(line, -1);
            while (index > -1){
                if (!removePair('*', index, line)) return false;
                index = firstIndex(line, index);
            }
        }

        return isEmptyLine(line);
    }

    private boolean isEmptyLine(char[] line){

        for (int i = 0; i < line.length; i++) {
            if (line[i] != '*' && line[i] != ' ') return false;
        }

        return true;
    }

    private int firstIndex(char[] line, int afterIndex){
        for (int i = afterIndex+1; i < line.length; i++){
            if (line[i] == '*') return i;
        }

        return -1;
    }

    private int lastIndex(char[] line, int beforeIndex){

        for (int i = beforeIndex-1; i > -1; i--){
            if (line[i] == '('){
                return i;
            }
        }

        return -1;
    }

    private boolean removePair(char pairSymbol, int index, char[] line){

        if (pairSymbol == '*'){
            for (int i = index; i < line.length; i++){
                if (line[i] == ')') {
                    line[i] = ' ';
                    line[index] = ' ';
                    break;
                }
            }
            return true;
        }else {

            int indexHelper = -1;
            for (int i = index + 1; i < line.length; i++) {
                if (line[i] == '*' && indexHelper == -1) {
                    indexHelper = i;
                } else if (line[i] == ')') {
                    line[i] = ' ';
                    line[index] = ' ';
                    return true;
                }
            }

            if (indexHelper > -1) {
                line[indexHelper] = ' ';
                line[index] = ' ';
                return true;
            }

            return false;
        }
    }

    @Test
    public void test(){

        Assert.assertTrue(checkValidString("(*))"));
        Assert.assertTrue(checkValidString("(*)"));
        Assert.assertFalse(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        Assert.assertFalse(checkValidString("(((((()*)(*)*))())())(()())())))((**)))))(()())()"));
        Assert.assertTrue(checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));

    }
}
