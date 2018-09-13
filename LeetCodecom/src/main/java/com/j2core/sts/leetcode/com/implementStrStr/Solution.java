package com.j2core.sts.leetcode.com.implementStrStr;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int strStr(String haystack, String needle) {

        if (needle.length() < 1){
            return 0;
        }

        if (haystack.length() < 1 || needle.length() > haystack.length()){
            return -1;
        }

        int index = haystack.indexOf(needle.charAt(0));

        while (index > -1){

            int tmpIndex = findIndex(index, haystack, needle);

            if (tmpIndex < 0){
                index = haystack.indexOf(needle.charAt(0), index+1);
            }else {
                break;
            }

        }

        return index;
    }

    private int findIndex(int index, String haystack, String needle){

        for (int i = 1; i < needle.length(); i++){

            if (i+index >= haystack.length()) {
                return -1;
            }

            if (needle.charAt(i) != haystack.charAt(i+index)){
                return -1;
            }
        }

        return index;

    }


    @Test
    public void test(){

        int result = strStr("hello", "ll");

        Assert.assertEquals(2, result);

        int result2 = strStr("aaaaaa", "bba");

        Assert.assertEquals(result2, -1);

        int result1 = strStr("aaaaaab", "ab");

        Assert.assertEquals(result1, 5);

        int result3 = strStr("aaa", "aaaa");

        Assert.assertEquals(result3, -1);

        int result4 = strStr("mississippi", "issipi");

        Assert.assertEquals(result4, -1);

    }

}
