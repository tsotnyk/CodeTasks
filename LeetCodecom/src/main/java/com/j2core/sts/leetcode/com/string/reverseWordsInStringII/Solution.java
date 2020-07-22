package com.j2core.sts.leetcode.com.string.reverseWordsInStringII;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public void reverseWords(char[] s) {

        if (s.length > 2){

            int start = 0;
            int end = s.length-1;
            char tmp;

            while (start < end){

                tmp = s[start];
                s[start] = s[end];
                s[end] = tmp;
                start++;
                end--;
            }

            start = 0;
            end = start;
            while (start < s.length){
                while (end+1 < s.length && s[end+1] != ' '){
                    end++;
                }
                int newStart = end+2;
                while (start < end){
                    tmp = s[start];
                    s[start] = s[end];
                    s[end] = tmp;
                    start++;
                    end--;
                }
                start = newStart;
                end = start;
            }
        }
    }

    @Test
    public void test(){

        char[] tmp = new char[]{'a',' ','b'};
        reverseWords(tmp);

        Assert.assertEquals(tmp, new char[]{'b',' ','a'});

        char[] string = new char[]{'t', 'h','e',' ','s','k','y',' ','i','s',' ', 'b','l','u','e'};
        reverseWords(string);
        Assert.assertEquals(string, new char[]{'b', 'l','u','e',' ','i','s',' ','s','k','y', ' ','t','h','e'});
    }
}
