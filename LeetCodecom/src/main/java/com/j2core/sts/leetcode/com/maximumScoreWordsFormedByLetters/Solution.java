package com.j2core.sts.leetcode.com.maximumScoreWordsFormedByLetters;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int[] lettersArray = createLettersArray(letters);

        List<int[]> wordList = createWordList(words, lettersArray);

        if (wordList.isEmpty()) return 0;

        //todo

        return 0;
    }

    private List<int[]> createWordList(String[] words, int[] lettersArray){

        List<int[]> result = new LinkedList<>();

        for (String word : words){

            int[] array = createLettersArray(word.toCharArray());
            boolean flag = true;

            for (int i = 0; i < lettersArray.length; i++){
                if(lettersArray[i] < array[i]){
                    flag = false;
                    break;
                }
            }

            if (flag){
                result.add(array);
            }else {
                flag = true;
            }
        }

        return result;
    }

    private int[] createLettersArray(char[] letters){

        int[] result = new int[26];

        for (int character : letters) {
            result[character - 97] += 1;
        }
        return result;
    }

    @Test
    public void test(){

//        int tmp = maxScoreWords(new String[]{"leetcode"}, new char[]{'l', 'e', 't', 'c', 'o', 'd'}, new int[]{0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0});
//        int tmp1 = maxScoreWords(new String[]{"xxxz","ax","bx","cx"}, new char[]{'z', 'a', 'b', 'c', 'x', 'x', 'x'}, new int[]{4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10});
        int tmp2 = maxScoreWords(new String[]{"dog","cat","dad","good"}, new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'}, new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0});

//        Assert.assertEquals(tmp, 0);
//        Assert.assertEquals(tmp1, 27);
        Assert.assertEquals(tmp2, 23);
    }
}
