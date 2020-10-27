package com.j2core.sts.leetcode.com.palindromes.palindromePairs;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Solution {

    public List<List<Integer>> palindromePairsOld(String[] words) {

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < words.length-1; i++){

            for (int j = i+1; j < words.length; j++){

                if (j != i){
                    if (isPalindromeOld(words[i], words[j])){
                        List<Integer> pair = new LinkedList<>();
                        pair.add(i);
                        pair.add(j);

                        result.add(pair);
                    }

                    if (isPalindromeOld(words[j], words[i])){
                        List<Integer> pair = new LinkedList<>();
                        pair.add(j);
                        pair.add(i);

                        result.add(pair);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindromeOld(String word1, String word2){

        String string = word1+word2;

        int indexS = 0;
        int indexE = string.length()-1;

        while (indexS < indexE){
            if (string.charAt(indexS++) != string.charAt(indexE--)){
                return false;
            }
        }

        return true;
    }

    public List<List<Integer>> palindromePairs1(String[] words) {

        List<List<Integer>> palindromePair = new LinkedList<>();

        for (int i = 0; i < words.length-1; i++){
            for (int j = i+1; j < words.length; j++){
                if (i != j){
                    if(isPairWordPalindrome(words[i], words[j])){
                        palindromePair.add(new LinkedList<>(Arrays.asList(i, j)));
                    }
                    if (isPairWordPalindrome(words[j], words[i])){
                        palindromePair.add(new LinkedList<>(Arrays.asList(j, i)));
                    }
                }
            }
        }

        return palindromePair;
    }

    private boolean isPairWordPalindrome(String word1, String word2){

        if (word1.length() == 0) return isWordPalindrome(word2, 0, word2.length()-1);
        if (word2.length() == 0) return isWordPalindrome(word1, 0, word1.length()-1);

        int index1 = 0;
        int index2 = word2.length()-1;

        while (index1 < word1.length() && index2 > -1){
            if (word1.charAt(index1++) != word2.charAt(index2--)) return false;
        }

        if (index1 == word1.length() && index2 == -1){
            return true;
        }else {
            if (index1 == word1.length()){
                return isWordPalindrome(word2, 0, index2);
            }else {
                return isWordPalindrome(word1, index1, word1.length() - 1);
            }
        }
    }

    private boolean isWordPalindrome(String word, int left, int right) {

        while (left < right){
            if (word.charAt(left++) != word.charAt(right--)){
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> pairList = new LinkedList<>();

        if (words == null || words.length < 2) return pairList;

        HashMap<String, Integer> wordReverseMap = new HashMap<>();

        for (int i = 0; i < words.length; i++){
            wordReverseMap.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < words.length; i++){

            String word = words[i];
            int index = 1;

            while (index <= word.length()){
                if (wordReverseMap.containsKey(word.substring(0, index))){
                    int subWordIndex = wordReverseMap.get(word.substring(0, index));
                    if (subWordIndex != i && isPairWordPalindrome(word, new StringBuilder(word.substring(0, index)).reverse().toString())){
                        pairList.add(new LinkedList<>(Arrays.asList(subWordIndex, i)));
                    }
                }
                index++;
            }
        }

        return pairList;
    }

    @Test
    public void test(){

        Assert.assertEquals(palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}).size(), 4);
    }
}
