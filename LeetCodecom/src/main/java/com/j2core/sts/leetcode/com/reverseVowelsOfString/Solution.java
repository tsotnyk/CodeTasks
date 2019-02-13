package com.j2core.sts.leetcode.com.reverseVowelsOfString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String reverseVowels(String s) {

        Set<Character> set = new HashSet<>();

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] array = s.toCharArray();
        int start = 0;
        int end = array.length-1;

        while (start < end){

            char first = array[start];
            while (start < end && !set.contains(first)){
                first = array[++start];
            }
            char second = array[end];
            while (start < end && !set.contains(second)){
                second = array[--end];
            }

            array[start++] = second;
            array[end--] = first;
        }

        return new String(array);
    }

    @Test
    public void test(){

        String result = reverseVowels("hello");

        Assert.assertEquals(result, "holle");

    }
}
