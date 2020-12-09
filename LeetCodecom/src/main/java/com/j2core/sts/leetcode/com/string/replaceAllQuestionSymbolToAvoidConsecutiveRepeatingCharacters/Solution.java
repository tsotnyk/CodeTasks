package com.j2core.sts.leetcode.com.string.replaceAllQuestionSymbolToAvoidConsecutiveRepeatingCharacters;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public String modifyString(String s) {

        StringBuilder result = new StringBuilder();
        int num;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != '?'){
                result.append(s.charAt(i));
            }else {
                if (i+1 == s.length() && i != 0){
                        num = s.charAt(i-1)+1;
                        if (num > (int) 'a'+26-1){
                            num -= 26;
                        }
                        result.append((char) num);
                }else {
                    if (i == 0){
                        num = 'a';
                    }else {
                        num = result.charAt(i-1)+1;
                    }

                    if (num > (int) 'a'+26-1){
                        num -= 26;
                    }
                    if (i+1 < s.length() && s.charAt(i+1) == (char) num){
                        num += 1;
                        if (num > (int) 'a'+26-1){
                            num -= 26;
                        }
                    }
                    result.append((char) num);
                }
            }
        }

        return result.toString();
    }

    @Test
    public void test(){
        Assert.assertEquals(modifyString("?"),"a");


        Assert.assertEquals(modifyString("??yw?ipkj?"),"abywxipkjk");
    }
}
