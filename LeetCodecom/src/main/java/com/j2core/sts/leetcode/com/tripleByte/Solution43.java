package com.j2core.sts.leetcode.com.tripleByte;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution43 {

    public static int bracket_match(String bracket_string){

        int result = 0;
        int counter = 0;
        for (int i = 0; i < bracket_string.length(); i++){
            if (bracket_string.charAt(i) == '('){
                counter++;
            }else {
                counter--;
            }
            if (counter < 0){
                result++;
                counter++;
            }
        }

        return counter > 0 ? counter+result : result;
    }

    @Test
    public void test(){

        Assert.assertEquals(bracket_match("(()())"), 0);
        Assert.assertEquals(bracket_match("((())"), 1);
        Assert.assertEquals(bracket_match("(()"), 1);
        Assert.assertEquals(bracket_match("())"), 1);
        Assert.assertEquals(bracket_match(")("), 2);


    }

}
