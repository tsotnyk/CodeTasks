package com.j2core.sts.leetcode.com.findAllPalindromeWithMinDeleteInsertActions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> findAllPalindromeWithDeleteInsertActions(String word){

        List<String> palindromeList = new LinkedList<>();

        if (word == null) return palindromeList;
        if (word.length() < 1){
            return createFullList();
        }
        if (word.length() == 1 || isPalindrome(word)){
            palindromeList.add(word);
            return palindromeList;
        }

        int minActionDistance = findMinActionDistance(word);
        List<String> potentialPalindromes = new LinkedList<>(Collections.singletonList(word));

        while (minActionDistance-- > 0){
            potentialPalindromes = doDeleteInsertActions(potentialPalindromes);
        }

        createPalindromeList(potentialPalindromes, palindromeList);

        return palindromeList;

    }

    private List<String> doDeleteInsertActions(List<String> potentialPalindromes) {

        List<String> nextPotentialPalindromes = new LinkedList<>();
        for (String word : potentialPalindromes){
            int indexStart = 0;
            int indexEnd = word.length()-1;

            while (indexStart < indexEnd){

                if (word.charAt(indexStart) != word.charAt(indexEnd)){

                    nextPotentialPalindromes.add(word.substring(0, indexStart) + word.substring(indexStart + 1));
                    nextPotentialPalindromes.add(word.substring(0, indexEnd)+ word.substring(indexEnd+1));

                    if (indexStart == 0){
                        nextPotentialPalindromes.add(word.charAt(indexEnd) + word.substring(indexStart));
                    }else {
                        nextPotentialPalindromes.add(word.substring(0, indexStart) + word.charAt(indexEnd) + word.substring(indexStart));
                    }
                    nextPotentialPalindromes.add(word.substring(0, indexEnd+1) + word.charAt(indexStart) + word.substring(indexEnd+1));
                    break;
                }
                indexStart++;
                indexEnd--;
            }
        }

        return nextPotentialPalindromes;
    }

    private void createPalindromeList(List<String> potentialPalindromes, List<String> palindromeList) {

        HashSet<String> setWords = new HashSet<>();
        for (String word : potentialPalindromes){
            if (isPalindrome(word)){
                setWords.add(word);
            }
        }

        palindromeList.addAll(setWords);
    }


    private int findMinActionDistance(String word) {

        String reverseWord = new StringBuilder(word).reverse().toString();

        int[][] matrix = new int[word.length()+1][word.length()+1];

        for (int i = 1; i <= word.length(); i++){
            matrix[0][i] = i;
            matrix[i][0] = i;
        }

        for(int i = 1; i <= word.length(); i++){
            for(int j = 1; j <= word.length(); j++){
                if(reverseWord.charAt(i-1) == word.charAt(j-1))
                    matrix[i][j] = matrix[i-1][j-1];
                else
                    matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1])+1;
            }
        }

        return matrix[word.length()][word.length()]/2;
    }

    private boolean isPalindrome(String word) {

        int indexStart = 0;
        int indexEnd = word.length()-1;

        while (indexStart < indexEnd){

            if (word.charAt(indexStart) != word.charAt(indexEnd)) return false;
            indexStart++;
            indexEnd--;
        }

        return true;
    }

    private List<String> createFullList() {

        List<String> characterList = new LinkedList<>();
        for(char alphabet = 'a'; alphabet <='z'; alphabet ++ ){
            characterList.add(String.valueOf(alphabet));
        }

        return characterList;
    }

    @Test
    public void test(){

        List<String> result1 = findAllPalindromeWithDeleteInsertActions(null);

        Assert.assertTrue(result1.isEmpty());
        System.out.println("List is empty");

        List<String> result2 = findAllPalindromeWithDeleteInsertActions("abba");

        Assert.assertEquals(result2.size(), 1);
        for (String palindrome : result2){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  abba");

        List<String> result3 = findAllPalindromeWithDeleteInsertActions("baac");

        Assert.assertEquals(result3.size(), 5);
        for (String palindrome : result3){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  aa, baab, caac, bcaacb, cbaabc");

        List<String> result4 = findAllPalindromeWithDeleteInsertActions("ababcac");

        Assert.assertEquals(result4.size(), 4);
        for (String palindrome : result4){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  ababa, acbabca, cababac, cacbabcac");

        List<String> result5 = findAllPalindromeWithDeleteInsertActions("");

        Assert.assertEquals(result5.size(), 26);
        for (String palindrome : result5){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  from a to z");

        List<String> result6 = findAllPalindromeWithDeleteInsertActions("a");

        Assert.assertEquals(result6.size(), 1);
        for (String palindrome : result6){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  a");

        List<String> result7 = findAllPalindromeWithDeleteInsertActions("aa");

        Assert.assertEquals(result7.size(), 1);
        for (String palindrome : result7){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  aa");

        List<String> result8 = findAllPalindromeWithDeleteInsertActions("ab");

        Assert.assertEquals(result8.size(), 4);
        for (String palindrome : result8){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  a, b, aba, bab");
    }
}
