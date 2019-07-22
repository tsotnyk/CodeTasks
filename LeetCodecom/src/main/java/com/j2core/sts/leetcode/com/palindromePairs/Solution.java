package com.j2core.sts.leetcode.com.palindromePairs;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < words.length-1; i++){

            for (int j = i+1; j < words.length; j++){

                if (j != i){
                    if (isPalindrome(words[i], words[j])){
                        List<Integer> pair = new LinkedList<>();
                        pair.add(i);
                        pair.add(j);

                        result.add(pair);
                    }

                    if (isPalindrome(words[j], words[i])){
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

    private boolean isPalindrome(String word1, String word2){

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

}
