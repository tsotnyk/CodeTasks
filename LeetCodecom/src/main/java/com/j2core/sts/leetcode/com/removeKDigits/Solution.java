package com.j2core.sts.leetcode.com.removeKDigits;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String removeKdigits(String num, int k) {
        int removeNum = 0;
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < num.length(); i++){
            int value = num.charAt(i) - '0';
            while(removeNum < k && !stack.isEmpty() && stack.peekLast() > value){
                stack.pollLast();
                removeNum++;
            }
            stack.offerLast(value);
        }
        while(removeNum < k){
            stack.pollLast();
            removeNum++;
        }
        StringBuilder sb = new StringBuilder();
        for(Integer i : stack){
            if(i == 0 && sb.length() == 0){
                continue;
            }
            sb.append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    @Test
    public void test(){

        String result = removeKdigits("1432219", 3);

        Assert.assertEquals(result, "1219");

        String result1 = removeKdigits("111111", 3);

        Assert.assertEquals(result1, "111");

    }
}
