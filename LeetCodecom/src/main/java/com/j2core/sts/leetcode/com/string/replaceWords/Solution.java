package com.j2core.sts.leetcode.com.string.replaceWords;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String replaceWords(List<String> dict, String sentence) {

        StringBuilder builder = new StringBuilder(sentence);

        for (String string : dict){

            int index = builder.indexOf(string);

            while (index > -1) {

                if (index == 0 || builder.substring(index-1, index).equals( " ")) {
                    index = index + string.length();
                    int lastIndex = builder.indexOf(" ", index);

                    if (lastIndex < 0) {
                        int tmpIndex = sentence.lastIndexOf(" ");
                        lastIndex = index + (sentence.length() - tmpIndex + 1 - string.length());
                    }
                    builder.delete(index, lastIndex);
                }
                index = builder.indexOf(string, index+1);
            }
        }

        return builder.toString();
    }


    @Test
    public void test(){

        List<String> dict = new LinkedList<>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");

        String result = replaceWords(dict, "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa");

        Assert.assertEquals(result, "a a a a a a a a bbb baba a");

//        List<String> dict = new LinkedList<>();
//        dict.add("cat");
//        dict.add("bat");
//        dict.add("rat");
//
//        String result = replaceWords(dict, "the cattle was ratted by the battery");
//
//        Assert.assertEquals(result, "the cat was rat by the bat");

    }
}
