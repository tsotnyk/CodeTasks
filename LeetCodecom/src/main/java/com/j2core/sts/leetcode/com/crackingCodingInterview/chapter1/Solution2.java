package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Solution2 {

    // work for all symbols
    // Time O(nLogn), space O(n)
    public boolean isPermutationOfStringSort(String base, String permutation){

        if (base == null && permutation == null) return true;
        if (base == null || permutation == null) return false;
        if (base.length() != permutation.length()) return false;
        if (base.length() == 0) return true;

        char[] baseArray = base.toCharArray();
        char[] permutationArray = permutation.toCharArray();

        Arrays.sort(baseArray);
        Arrays.sort(permutationArray);

        for (int i = 0; i < baseArray.length; i++){
            if (baseArray[i] != permutationArray[i]) return false;
        }

        return true;
    }

    // will work with latin alphabet and numbers only
    // Time O(n), space O(1)
    public boolean isPermutationOfStringAdditionalDataStructure(String base, String permutation){

        if (base == null && permutation == null) return true;
        if (base == null || permutation == null) return false;
        if (base.length() != permutation.length()) return false;
        if (base.length() == 0) return true;

        int[] symbolArray = new int[128];

        for (int symbol : base.toCharArray()){
            symbolArray[symbol] += 1;
        }
        for (int symbol : permutation.toCharArray()){
            if (symbolArray[symbol] == 0) return false;
            symbolArray[symbol] -= 1;
        }

        return true;
    }

    // work for all symbols
    // Time O(n), space O(n)
    public boolean isPermutationOfStringAdditionalDataStructureMap(String base, String permutation){

        if (base == null && permutation == null) return true;
        if (base == null || permutation == null) return false;
        if (base.length() != permutation.length()) return false;
        if (base.length() == 0) return true;

        HashMap<Character, Integer> symbolMap = new HashMap<>();
        for (char symbol : base.toCharArray()){
            symbolMap.put(symbol, symbolMap.getOrDefault(symbol, 0)+1);
        }
        for (char symbol : permutation.toCharArray()){
            if (!symbolMap.containsKey(symbol)) return false;
            int counter = symbolMap.get(symbol);
            if (counter == 0) return false;
            symbolMap.put(symbol, counter-1);
        }

        return true;
    }

    @Test
    public void test1(){

        Assert.assertTrue(isPermutationOfStringSort("qwertyuiop", "poiuytrewq"));
        Assert.assertTrue(isPermutationOfStringSort(null, null));
        Assert.assertTrue(isPermutationOfStringSort("", ""));
        Assert.assertFalse(isPermutationOfStringSort(null, ""));
        Assert.assertFalse(isPermutationOfStringSort("", null));
        Assert.assertFalse(isPermutationOfStringSort("1", "12"));
        Assert.assertFalse(isPermutationOfStringSort("12aszx", "34erdf"));
    }

    @Test
    public void test2(){

        Assert.assertTrue(isPermutationOfStringAdditionalDataStructure("qwertyuiop", "poiuytrewq"));
        Assert.assertTrue(isPermutationOfStringAdditionalDataStructure(null, null));
        Assert.assertTrue(isPermutationOfStringAdditionalDataStructure("", ""));
        Assert.assertFalse(isPermutationOfStringAdditionalDataStructure(null, ""));
        Assert.assertFalse(isPermutationOfStringAdditionalDataStructure("", null));
        Assert.assertFalse(isPermutationOfStringAdditionalDataStructure("1", "12"));
        Assert.assertFalse(isPermutationOfStringAdditionalDataStructure("12aszx", "34erdf"));
    }

    @Test
    public void test3(){

        Assert.assertTrue(isPermutationOfStringAdditionalDataStructureMap("qwertyuiop", "poiuytrewq"));
        Assert.assertTrue(isPermutationOfStringAdditionalDataStructureMap(null, null));
        Assert.assertTrue(isPermutationOfStringAdditionalDataStructureMap("", ""));
        Assert.assertFalse(isPermutationOfStringAdditionalDataStructureMap(null, ""));
        Assert.assertFalse(isPermutationOfStringAdditionalDataStructureMap("", null));
        Assert.assertFalse(isPermutationOfStringAdditionalDataStructureMap("1", "12"));
        Assert.assertFalse(isPermutationOfStringAdditionalDataStructureMap("12aszx", "34erdf"));
        Assert.assertFalse(isPermutationOfStringAdditionalDataStructureMap("1222", "2111"));

    }

}
