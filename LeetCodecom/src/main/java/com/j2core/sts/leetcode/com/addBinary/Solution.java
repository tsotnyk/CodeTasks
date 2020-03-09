package com.j2core.sts.leetcode.com.addBinary;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class Solution {

    public String addBinary(String a, String b) {

        String first = a.length() >= b.length() ? a : b;
        String second = a.length() >= b.length() ? b : a;

        Stack<Character> stack = new Stack<>();
        char delta = '0';
        int index1 = first.length()-1;
        int index2 = second.length()-1;
        while (index2 > -1){
            char tmp;
            char tmpDelta = '0';
            if (first.charAt(index1) == '1' && second.charAt(index2) == '1'){
                tmp = '0';
                tmpDelta = '1';
            }else if (first.charAt(index1) == '0' && second.charAt(index2) == '0'){
                tmp = '0';
            }else {
                tmp = '1';
            }
            if (tmp == '1' && delta == '1'){
                tmp = '0';
                tmpDelta = '1';
            }else if ((tmp == '1' && delta == '0') || (tmp == '0' && delta == '1')) {
                tmp = '1';
            }
            stack.push(tmp);
            index1--;
            index2--;
            delta = tmpDelta;
        }

        if (index1 > index2){
            while (index1 > -1){
                if ((first.charAt(index1) == '1' && delta == '1') || (first.charAt(index1) == '0' && delta == '0')){
                    stack.push('0');
                }else {
                    stack.push('1');
                    delta = '0';
                }
                index1--;
            }
        }

        if (delta == '1'){
            stack.push(delta);
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.empty()){
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    @Test
    public void test(){

        Assert.assertEquals(addBinary("1010", "1011"), "10101");
        Assert.assertEquals(addBinary("1111", "1111"), "11110");

    }
}
