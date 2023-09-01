package com.j2core.sts.leetcode.com.minimumRemoveToMakeValidParentheses;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class Solution {

    public String minRemoveToMakeValid(String s) {

        char[] array = s.toCharArray();

        Stack<Integer> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++){

            if (array[i] == ')'){
                if (brackets.isEmpty()){
                    array[i] = '*';
                }else {
                    brackets.pop();
                }
                continue;
            }
            if (array[i] == '('){
                brackets.push(i);
            }
        }

        while (!brackets.isEmpty()){
            array[brackets.pop()] = '*';
        }

        StringBuilder builder= new StringBuilder();

        for (char sym : array){
            if (sym != '*') builder.append(sym);
        }

        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(minRemoveToMakeValid("lee(t(c)o)de)"), "lee(t(c)o)de");
        Assert.assertEquals(minRemoveToMakeValid("a)b(c)d"), "ab(c)d");

        Assert.assertEquals(minRemoveToMakeValid("))(("), "");

    }
}
