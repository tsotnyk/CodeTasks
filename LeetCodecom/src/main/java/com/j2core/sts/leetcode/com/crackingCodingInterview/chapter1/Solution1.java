package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class Solution1 {

    // doesn't matter about symbols
    // Time O(n), space O(n)
    public boolean isUniqCharactersWithSet(String input){

        if (input == null || input.length() < 2) return true;
        HashSet<Character> characterSet = new HashSet<>();

        for (char symbol : input.toCharArray()){
            if (characterSet.contains(symbol)) return false;
            characterSet.add(symbol);
        }

        return true;
    }

    @Test
    public void test1(){

        Assert.assertTrue(isUniqCharactersWithSet("qwertydfhg345"));
        Assert.assertTrue(isUniqCharactersWithSet(""));
        Assert.assertTrue(isUniqCharactersWithSet(null));
        Assert.assertFalse(isUniqCharactersWithSet("12121212sjgfhgfds"));
        Assert.assertFalse(isUniqCharactersWithSet("11111111111111111"));
    }

    // work for latin alphabet and numbers
    // Time O(n), space O(n)
    public boolean isUniqAlphabetAndNum(String input){

        if (input == null || input.length() < 2) return true;
        int[] symbols = new int[128];

        for (int symbol : input.toCharArray()){
            if (symbols[symbol] != 0) return false;
            symbols[symbol] += 1;
        }

        return true;
    }

    @Test
    public void test2(){

        Assert.assertTrue(isUniqAlphabetAndNum("qwertydfhg345"));
        Assert.assertTrue(isUniqAlphabetAndNum(""));
        Assert.assertTrue(isUniqAlphabetAndNum("1"));
        Assert.assertTrue(isUniqAlphabetAndNum("12"));
        Assert.assertFalse(isUniqAlphabetAndNum("11"));
        Assert.assertTrue(isUniqAlphabetAndNum(null));
        Assert.assertFalse(isUniqAlphabetAndNum("12121212sjgfhgfds"));
        Assert.assertFalse(isUniqAlphabetAndNum("11111111111111111"));

    }

    // work for latin alphabet and numbers
    // Time O(n), space O(n)
    public boolean isUniqAlphabetAndNum2(String input){

        if (input == null || input.length() < 2) return true;
        boolean[] symbols = new boolean[128];

        for (int symbol : input.toCharArray()){
            if (symbols[symbol]) return false;
            symbols[symbol] = true;
        }

        return true;
    }

    @Test
    public void test3(){

        Assert.assertTrue(isUniqAlphabetAndNum2("qwertydfhg345"));
        Assert.assertTrue(isUniqAlphabetAndNum2(""));
        Assert.assertTrue(isUniqAlphabetAndNum2("1"));
        Assert.assertTrue(isUniqAlphabetAndNum2("12"));
        Assert.assertFalse(isUniqAlphabetAndNum2("11"));
        Assert.assertTrue(isUniqAlphabetAndNum2(null));
        Assert.assertFalse(isUniqAlphabetAndNum2("12121212sjgfhgfds"));
        Assert.assertFalse(isUniqAlphabetAndNum2("11111111111111111"));

    }

}
