package com.j2core.sts.leetcode.com.removeDuplicateLetters;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }


//    public String removeDuplicateLetters(String s) {
//
//        HashSet<Character> uniqChar = new HashSet<>();
//
//        StringBuilder builder = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++){
//            char character = s.charAt(i);
//            if (!uniqChar.contains(character)){
//                uniqChar.add(character);
//                builder.append(character);
//            }else {
////                builder = compareTo(builder, character);
////                char tmp = builder.charAt(builder.length()-1);
////                if (tmp > character){
////                    int index = builder.indexOf(String.valueOf(character));
////                    builder.replace(index, index+1, "");
////                    builder.append(character);
////                }
//            }
//        }
//        return builder.toString();
//    }
//
//    private StringBuilder compareTo(StringBuilder builder, char character){
//
//        StringBuilder tmpBuilder = new StringBuilder(builder);
//        int index = tmpBuilder.indexOf(String.valueOf(character));
//        tmpBuilder.replace(index, index+1, "");
//        tmpBuilder.append(character);
//
//        for (int i = 0; i < builder.length(); i++){
//            if (builder.charAt(i) != tmpBuilder.charAt(i)){
//                if (builder.charAt(i) < tmpBuilder.charAt(i)){
//                    return builder;
//                }else {
//                    return tmpBuilder;
//                }
//            }
//        }
//
//        return builder;
//    }

    @Test
    public void test(){

        Assert.assertEquals(removeDuplicateLetters("bcabc"), "abc");
//        Assert.assertEquals(removeDuplicateLetters("bbbcabc"), "abc");
//        Assert.assertEquals(removeDuplicateLetters("cbacdcbc"), "acdb");


    }
}
