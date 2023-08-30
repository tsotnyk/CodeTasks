package com.j2core.sts.leetcode.com.remove.removeKDigits;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class Solution1 {

    public String removeKdigits(String num, int k) {

        Stack<Character> nums = new Stack<>();

        for (char sym : num.toCharArray()){
            if(nums.isEmpty() || k == 0){
                nums.push(sym);
                continue;
            }
            if(sym == '0'){
                nums.pop();
                k--;
                continue;
            }
            if (nums.peek() > sym){
                nums.pop();
                nums.push(sym);
                k--;
            }
            k--;
        }

        if (k > 0){
            while (!nums.isEmpty() && k-- > 0){
                nums.pop();
            }
        }

        return nums.isEmpty() ? "0" : String.valueOf(nums);

    }

    @Test
    public void test(){

        Assert.assertEquals(removeKdigits("1432219", 3), "1219");
    }
}
