package com.j2core.sts.leetcode.com.graphs.stringTransformsIntoAnotherString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {

    public boolean canConvert(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        if (str1.equals(str2)) return true;

        Map<Character, Character> str1LetterMap = new HashMap<>();
        Map<Character, Character> str2LetterMap = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {

            if (str1LetterMap.containsKey(str1.charAt(i))){

                if (!str2LetterMap.containsKey(str2.charAt(i))){
                    return false;
                }else {
                    if (str1LetterMap.get(str1.charAt(i)) != str2.charAt(i) || str2LetterMap.get(str2.charAt(i)) != str1.charAt(i)){
                        return false;
                    }
                }
            }

            str1LetterMap.put(str1.charAt(i), str2.charAt(i));
            str2LetterMap.put(str2.charAt(i), str1.charAt(i));

        }

        return str2LetterMap.size() != 26;
    }

    public boolean canConvertOld(String str1, String str2) {

        if (str1.length() != str2.length()) return false;
        if (str1.equals(str2)) return true;

        HashMap<Character, Character> convertLetterMap = new HashMap<>();
        HashSet<Character> usedLetter = new HashSet<>();

        for (int i = 0; i < str1.length(); i++){

            if (!convertLetterMap.containsKey(str1.charAt(i))){
                if (!usedLetter.contains(str2.charAt(i))) {
                    convertLetterMap.put(str1.charAt(i), str2.charAt(i));
                    usedLetter.add(str2.charAt(i));
                }else {
                    return false;
                }
            }else{
                if (str2.charAt(i) != convertLetterMap.get(str1.charAt(i))){
                    return false;
                }
            }
        }

        return usedLetter.size() != 26;
    }

    @Test
    public void test(){

        Assert.assertTrue(canConvert("aabcc", "ccdee"));
        Assert.assertFalse(canConvert("leetcode", "codeleet"));
        Assert.assertFalse(canConvert("abcdefghijklmnopqrstuvwxyz","bcdefghijklmnopqrstuvwxyza"));
        Assert.assertTrue(canConvert("abcdefghijklmnopqrstuvwxy","bcdefghijkamnopqrstuvwxyz"));

    }
}
