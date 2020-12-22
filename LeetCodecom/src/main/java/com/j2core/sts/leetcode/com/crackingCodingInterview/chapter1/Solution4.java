package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution4 {

    // Time O(nLogn+n), space O(n)
    public boolean isPermutationOfPalindromeSort(String input){

        input = input.toLowerCase();
        char[] palindrome = input.toCharArray();
        Arrays.sort(palindrome);
        int index = 0;
        int counter = 0;

        while (index+1 < palindrome.length){
            if (palindrome[index] == ' '){
                index++;
            } else if (palindrome[index] == palindrome[index+1]){
                index += 2;
            }else {
                index++;
                counter++;
                if (counter > 1) return false;
            }
        }

        if (index < palindrome.length){
            counter++;
        }

        return counter <= 1;
    }

    @Test
    public void test1(){

        Assert.assertTrue(isPermutationOfPalindromeSort("Tact Coa"));
        Assert.assertFalse(isPermutationOfPalindromeSort("qwqwq w q wqwqwqwas"));
    }

    // Time O(n), space O(1)
    public boolean isPermutationOfPalindromeArray(String input){

        input = input.toLowerCase();
        int[] characterArray = new int[26];

        int index = 0;

        while (index < input.length()){
            char symbol = input.charAt(index++);
            if (symbol != ' '){
                int i = (int) symbol - 'a';
                characterArray[i] += 1;
            }
        }

        int counter = 0;

        for (int num : characterArray){
            if (num%2 != 0){
                counter++;
                if (counter > 1) return false;
            }
        }

        return true;
    }

    // Time O(n), space O(1)
    public boolean isPermutationOfPalindromeArrayOpt(String input){

        input = input.toLowerCase();
        int[] characterArray = new int[26];

        int index = 0;
        int oddCounter = 0;
        while (index < input.length()){
            char symbol = input.charAt(index++);
            if (symbol != ' '){
                int i = (int) symbol - 'a';
                characterArray[i] += 1;
                if (characterArray[i]%2 == 0){
                    oddCounter--;
                }else {
                    oddCounter++;
                }
            }
        }

        return oddCounter <= 1;
    }

    @Test
    public void test2(){

        Assert.assertTrue(isPermutationOfPalindromeArray("Tact Coa"));
        Assert.assertFalse(isPermutationOfPalindromeArray("qwqwq w q wqwqwqwas"));
        Assert.assertTrue(isPermutationOfPalindromeArrayOpt("Tact Coa"));
        Assert.assertFalse(isPermutationOfPalindromeArrayOpt("qwqwq w q wqwqwqwas"));
    }
}
