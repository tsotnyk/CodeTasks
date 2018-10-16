package com.j2core.sts.leetcode.com.minimumAddToMakeParenthesesValid;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int minAddToMakeValid(String S) {

        int result = 0;
        int index = 0;
        int count = 0;

        while (index < S.length()){

            char tmp1 = S.charAt(index++);
            count = 1;

            while (index < S.length() && S.charAt(index) == tmp1){
                index++;
                count++;
            }

            if (tmp1 == '('){

                while (index < S.length() && count != 0){

                    if (S.charAt(index++) == ')'){
                        count--;
                    }else {
                        count++;
                    }
                }

            }else {
                result = result+count;
                count = 0;
            }

        }

        return result+count;
    }

    @Test
    public void test(){

        int result = minAddToMakeValid("(()())((");

        Assert.assertEquals(result, 2);

    }

}
