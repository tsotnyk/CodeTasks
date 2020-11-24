package com.j2core.sts.leetcode.com.compareStringsByFrequencyOfTheSmallestCharacter;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        List<Integer> wordCollection = new LinkedList<>();

        for (String word : words){
            wordCollection.add(parsWord(word));
        }
        int[] result = new int[queries.length];
        int index = 0;
        for (String query : queries){
            int smallestCharacter = parsWord(query);
            int counter = 0;
            for (int num : wordCollection){
                if (smallestCharacter < num){
                    counter++;
                }
            }
            result[index++] = counter;
        }
        return result;
    }

    private int parsWord(String word){

       int[] array = new int[26];
       int index = 26;
       for (int symbol : word.toCharArray()){
           if (index > symbol-97) index = symbol-97;
           array[symbol-97] += 1;
       }

        return index == 26 ? 0 : array[index];
    }

    @Test
    public void test(){

        Assert.assertEquals(numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"}), new int[]{1});
        Assert.assertEquals(numSmallerByFrequency(new String[]{"bbb","cc"}, new String[]{"a","aa","aaa","aaaa"}), new int[]{1,2});

    }

}
