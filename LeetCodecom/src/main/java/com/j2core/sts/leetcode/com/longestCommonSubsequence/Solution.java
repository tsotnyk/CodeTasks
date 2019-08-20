package com.j2core.sts.leetcode.com.longestCommonSubsequence;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) return 0;

        List<Character> repeatedChar = new ArrayList<>();

        for (char ch : text1.toCharArray()){
            if (text2.indexOf(ch) > -1){
                repeatedChar.add(ch);
            }
        }

        if (repeatedChar.isEmpty()) return 0;
        if (repeatedChar.size() == 1) return 1;

        int result = 1;
        List<List<Character>> tmpText = new LinkedList<>();
        tmpText.add(repeatedChar);

        while (!tmpText.isEmpty()){

            int tmpResult = 0;
            List<Character> word = tmpText.remove(0);
            int index = 0;
            for (int i = 0; i < text2.length() && index < word.size(); i++){
                if (text2.charAt(i) == word.get(index)){
                    index++;
                    tmpResult++;
                }
            }

            if (result < tmpResult){
                result = tmpResult;
            }

            if (word.size()-1 > result){
                List<Character> tmp;
                for (int i = 0; i < word.size(); i++){
                    tmp = new ArrayList<>(word);
                    tmp.remove(i);
                    tmpText.add(tmp);
                }
            }
        }
        return result;
    }

    @Test
    public void test(){

        int result = longestCommonSubsequence("papmretkborsrurgtina","nsnupotstmnkfcfavaxgl");
    }
}
