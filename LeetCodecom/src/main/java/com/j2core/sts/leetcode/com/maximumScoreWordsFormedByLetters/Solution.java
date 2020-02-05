package com.j2core.sts.leetcode.com.maximumScoreWordsFormedByLetters;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String obj1, String obj2) {
                return calculateScore(obj2, score) - calculateScore(obj1, score);
            }
        };

        Arrays.sort(words, comparator);
        int[] char_count = new int[26];

        for (char ch : letters)
            char_count[ch - 'a']++;

        return maxScore(words, char_count, score, 0);
    }

    private int maxScore(String[] words, int[] letters, int[] score, int vidx) {
        if (vidx == words.length || !chars_left(letters))
            return 0;
        int result = 0;
        if (isPossible(words[vidx], letters)) {
            apply(words[vidx], letters);
            result = calculateScore(words[vidx], score) + maxScore(words, letters, score, vidx + 1);
            remove(words[vidx], letters);
        }
        result = Math.max(result, maxScore(words, letters, score, vidx + 1));

        return result;
    }

    private boolean isPossible(String word, int[] chars) {
        apply(word, chars);
        boolean isPossible = true;
        for (int val : chars) {
            if (val < 0) {
                isPossible = false;
                break;
            }
        }
        remove(word, chars);

        return isPossible;
    }

    private int calculateScore(String word, int[] score) {
        int wordScore = 0;

        for (int i = 0; i < word.length(); ++i) {
            wordScore += score[word.charAt(i) - 'a'];
        }

        return wordScore;
    }

    private boolean chars_left(int[] letters) {
        for (int val : letters)
            if (val > 0)
                return true;
        return false;
    }

    private void remove(String word, int[] chars) {
        for (int i = 0; i < word.length(); ++i) {
            chars[word.charAt(i) - 'a']++;
        }

    }

    private void apply(String word, int[] chars) {
        for (int i = 0; i < word.length(); ++i) {
            chars[word.charAt(i) - 'a']--;
        }
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
