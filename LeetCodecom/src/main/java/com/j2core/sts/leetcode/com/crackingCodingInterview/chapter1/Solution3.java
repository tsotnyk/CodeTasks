package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution3 {

    public String urlChangeWithStringReplacement(String input){

        if (input == null || input.length() == 0) return input;
        int index = input.length()-1;

        while (index > -1 && input.charAt(index) == ' '){
            index--;
        }

        if (index == -1) return "";

        input = input.substring(0, index+1);
        input = input.replaceAll(" ", "%20");

        return input;
    }

    public String urlConvect(String input){

        StringBuilder builder = new StringBuilder();
        for (int i = input.length()-1; i > -1; i--){
            if (input.charAt(i) == ' '){
                if (builder.length() > 0) builder.append("02%");
            }else {
                builder.append(input.charAt(i));
            }
        }

        return builder.reverse().toString();
    }

    // if in input got char[]
    public void urlConvect(char[] input, int length){

        int index = input.length-1;
        int indexStart = length-1;
        while (indexStart > -1){
            if (input[indexStart] == ' '){
                input[index--] = '0';
                input[index--] = '2';
                input[index] = '%';
            }else {
                input[index] = input[indexStart];
            }
            index--;
            indexStart--;
        }
    }

    @Test
    public void test(){

        Assert.assertEquals(urlChangeWithStringReplacement("Hi my home!   "), "Hi%20my%20home!");
        Assert.assertEquals(urlChangeWithStringReplacement("   "), "");

        Assert.assertEquals(urlConvect("Hi my home!   "), "Hi%20my%20home!");
        Assert.assertEquals(urlConvect("   "), "");

        char[] url = new char[]{'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' '};
        urlConvect(url, 13);
        Assert.assertEquals(url, new char[]{'M','r','%','2','0','J','o','h','n','%','2','0','S','m','i','t','h'});
    }
}
