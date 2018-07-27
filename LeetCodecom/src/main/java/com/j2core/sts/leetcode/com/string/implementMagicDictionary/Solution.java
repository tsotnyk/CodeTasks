package com.j2core.sts.leetcode.com.string.implementMagicDictionary;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    String[] dictionary;

    /** Initialize your data structure here. */
    public Solution() {

    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {

        this.dictionary = dict;

    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {

        for (String str : dictionary) {

            if (str.length() == word.length()) {


                int delta = 0;
                for (int i = 0; i < str.length(); i++) {

                    if (str.charAt(i) == word.charAt(i)) {
                        delta++;
                    }
                }

                if (delta + 1 == word.length()) return true;
            }

        }
        return false;

    }

    @Test
    public void test(){

        Solution magicDictionary = new Solution();

        magicDictionary.buildDict(new String[]{"hello", "hallo", "hell", "leetcode"});

        boolean result = magicDictionary.search("leetcodd");

        Assert.assertTrue(result);

    }
}



