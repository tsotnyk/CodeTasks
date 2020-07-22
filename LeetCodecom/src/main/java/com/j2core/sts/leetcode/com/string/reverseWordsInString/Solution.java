package com.j2core.sts.leetcode.com.string.reverseWordsInString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String reverseWordsOld(String s) {

        if (s.length() < 1) return s;

        List<String> words = trimString(s);

        if (words.size() == 0) return "";

        StringBuilder builder = new StringBuilder();

        for (int i = words.size()-1; i > 0; i--){

            builder.append(words.get(i));
            builder.append(" ");

        }

        builder.append(words.get(0));

        return builder.toString();

    }


    private List<String>  trimString(String string){

        List<String> result = new LinkedList<>();
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < string.length(); i++){

            if (string.charAt(i) != ' '){

                endIndex = i;

            }else {
                if (i != startIndex) {
                    result.add(string.substring(startIndex, i));
                }
                startIndex = i+1;
            }

        }
        if (startIndex < string.length()){
            result.add(string.substring(startIndex, endIndex+1));
        }

        return result;
    }

    public String reverseWords(String s) {

        if (s.length() < 1) return s;

        StringBuilder builder = new StringBuilder();

        int indexEnd = s.length()-1;
        int indexStart = indexEnd;

        while (indexEnd > -1){

            if (s.charAt(indexEnd) != ' '){
                indexStart = indexEnd;
                while (indexStart > -1 && s.charAt(indexStart) != ' '){
                    indexStart--;
                }
                builder.append(s.substring(indexStart+1, indexEnd+1)).append(" ");
                indexEnd = indexStart;

            }
            indexEnd--;
        }

        return builder.length() > 0 ? builder.toString().substring(0, builder.length()-1) : "";
    }


    @Test
    public void test(){

//        String result = reverseWords("a     ");
//
//        Assert.assertEquals(result, "a");
        Assert.assertEquals(reverseWords("    hello word!   "), "word! hello");


        Assert.assertEquals(reverseWords("the sky is blue"), "blue is sky the");

    }

}
