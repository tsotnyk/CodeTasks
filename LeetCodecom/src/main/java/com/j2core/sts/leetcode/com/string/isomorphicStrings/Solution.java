package com.j2core.sts.leetcode.com.string.isomorphicStrings;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public boolean isIsomorphicOld(String s, String t) {

        List<Character> characterList = new LinkedList<>();
        int index;
        for (int i = 0; i < s.length(); i++){

            char tmpChar = s.charAt(i);
            if (!characterList.contains(tmpChar)) {

                characterList.add(tmpChar);

                List<Integer> charIndexS = new LinkedList<>();

                charIndexS.add(i);
                index = s.indexOf(tmpChar, i+1);
                while (index > -1){

                    charIndexS.add(index);
                    index = s.indexOf(tmpChar, index+1);

                }

                List<Integer> charIndexT = new LinkedList<>();
                tmpChar = t.charAt(i);
                charIndexT.add(i);
                index = t.indexOf(tmpChar, i+1);
                while (index > -1){

                    charIndexT.add(index);
                    index = t.indexOf(tmpChar, index+1);

                }

                if (charIndexT.size() != charIndexS.size()){
                    return false;
                }else {

                    for (int j = 0; j < charIndexS.size(); j++){

                        if (!charIndexS.get(j).equals(charIndexT.get(j))){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> lettersMap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++){
            if (lettersMap.containsKey(s.charAt(i))){
                if (!lettersMap.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }
            }else {
                if (set.contains(t.charAt(i))) return false;
                lettersMap.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
        }

        return true;
    }

    @Test
    public void test(){

        boolean result =  isIsomorphic("aab", "aaa");

        Assert.assertFalse(result);
        Assert.assertFalse(isIsomorphic("foo", "bar"));
        Assert.assertFalse(isIsomorphic("aba", "baa"));
        Assert.assertTrue(isIsomorphic("egg", "add"));
        Assert.assertTrue(isIsomorphic("paper", "title"));

    }
}
