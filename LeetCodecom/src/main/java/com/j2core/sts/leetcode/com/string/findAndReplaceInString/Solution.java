package com.j2core.sts.leetcode.com.string.findAndReplaceInString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
//
//        if (S.length() == 0) return S;
//        if (indexes.length == 0 || sources.length == 0 || targets.length == 0) return S;
//
//        Map<Integer, List<String>> map = new TreeMap<>();
//
//        for (int i = 0; i < )


//
//        int strIndex = 0;
//        int index = 0;
//        StringBuilder builder = new StringBuilder();
//
//        while (strIndex < S.length()){
//
//            if (strIndex < indexes[index]){
//                builder.append(S.charAt(strIndex++));
//            }else {
//                if (isPattern(S, indexes[index], sources[index])){
//                    builder.append(targets[index]);
//                    strIndex += sources[index].length();
//                }else {
//                    builder.append(S.charAt(strIndex++));
//                }
//                index++;
//                if (index == indexes.length) break;
//            }
//        }
//
//        if (strIndex < S.length()){
//            builder.append(S.substring(strIndex));
//        }
//        return builder.toString();

        return null;
    }

    private boolean isPattern(String string, int index, String pattern){

        if (string.length()-index < pattern.length()) return false;

        for (int i = 0; i < pattern.length(); i++){
            if (string.charAt(index) != pattern.charAt(i)) return false;
            index++;
        }
        return true;
    }

    @Test
    public void test(){

        Assert.assertEquals(findReplaceString("vmokgggqzp", new int[]{3,5,1}, new String[]{"kg","ggq","mo"}, new String[]{"s","so","bfr"}), "vbfrssozp");
        Assert.assertEquals(findReplaceString("abcd", new int[]{0,2}, new String[]{"a","cd"}, new String[]{"eee","ffff"}), "eeebffff");
        Assert.assertEquals(findReplaceString("abcd", new int[]{0,2}, new String[]{"ab","ec"}, new String[]{"eee","ffff"}), "eeecd");

    }
}
