package com.j2core.sts.leetcode.com.maximumNumberOfRemovableCharacters;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class Solution {

    public int maximumRemovals(String s, String p, int[] removable) {

        if(s.length() == p.length()) return 0;

        HashSet<Character> symbolSet = new HashSet<>();

        for (char symbol : p.toCharArray()){
            symbolSet.add(symbol);
        }

        boolean[] removedSymbol = new boolean[s.length()];
        int i = 0;
        while (i < removable.length){

            if (symbolSet.contains(s.charAt(removable[i]))){
                int index = 0;
                int j = 0;
                removedSymbol[removable[i]] = true;
                while (index < p.length() && j < s.length()){
                    if (!removedSymbol[j]){
                        if (s.charAt(j) == p.charAt(index)){
                            index++;
                        }

                    }
                    j++;
                }
                if (index < p.length()) return i;
            }
            i++;
            if (p.length()+i == s.length()) break;
        }

        return i;
    }

    @Test
    public void test(){

        Assert.assertEquals(maximumRemovals("abcbdddd", "abcd", new int[]{3,2,1,4,5,6}), 1);
        Assert.assertEquals(maximumRemovals("abcab", "abc", new int[]{0,1,2,3,4}), 0);
        Assert.assertEquals(maximumRemovals("abcacb", "ab", new int[]{3,1,0}), 2);
    }
}
