package com.j2core.sts.leetcode.com.removeInvalidParentheses;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution1 {
    public List<String> removeInvalidParentheses(String s) {
        var res=new ArrayList<String>();
        recur(s,0,0,new char[]{'(',')'}, res);
        return res;
    }
    private void recur(String s,int left,int right,char[] paranthesis, ArrayList<String> res){

        int val=0;

        for(; right<s.length(); right++){
            char ch = s.charAt(right);
            if(ch == paranthesis[0]) val++;
            else if(ch == paranthesis[1]) val--;
            if(val<0) break;
        }
        if(val<0){
            for(; left <= right; left++){
                char ch = s.charAt(left);
                if(ch != paranthesis[1]) continue;
                if(left > 1 && s.charAt(left) == s.charAt(left-1)) continue;
                String temp = s.substring(0,left)+s.substring(left+1);
                recur(temp,left,right,paranthesis, res);
            }
        }
        else if(val>0){
            recur(new StringBuilder(s).reverse().toString(),0,0,new char[]{')','('}, res);
        }
        else res.add(paranthesis[0]=='('?s:new StringBuilder(s).reverse().toString());
    }

    @Test
    public void test(){

        Assert.assertEquals(removeInvalidParentheses("()())()").size(), 2);
        Assert.assertEquals(removeInvalidParentheses("(a)())()").size(), 2);
        Assert.assertEquals(removeInvalidParentheses(")(").size(), 0);
    }
}
