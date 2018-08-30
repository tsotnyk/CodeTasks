package com.j2core.sts.leetcode.com.findAllAnagramsInString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new LinkedList<>();

        if (p.length() > 0 && p.length() <= s.length()){

            int lengthP = p.length();
            int lengthS = s.length();
            List<Character> characterList  = new LinkedList<>();
            Map<Character, Integer> anagram = createCharacterMap(p, characterList);
            Map<Character, Integer> subString = createCharacterMap(s.substring(0, p.length()), null);

            int index = 0;

            while (index <= lengthS - lengthP){
                if (comparingMap(subString, anagram, characterList)){

                    result.add(index);
                }

                if (index+lengthP < lengthS) {
                    changeSubStringMap(subString, s.charAt(index), s.charAt(index + lengthP));
                }
                index++;

            }
        }

        return result;

    }


    private void changeSubStringMap(Map<Character, Integer> subString, char oldChar, char newChar){

        if (oldChar != newChar){

            if (subString.get(oldChar) > 1){
                subString.put(oldChar, subString.get(oldChar) - 1);
            }else {
                subString.remove(oldChar);
            }

            if (subString.containsKey(newChar)){
                subString.put(newChar, subString.get(newChar) + 1);
            }else {
                subString.put(newChar, 1);
            }
        }

    }


    private Map<Character, Integer> createCharacterMap(String string, List<Character> characterList){

        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < string.length(); i++){

            char tmpChar = string.charAt(i);
            if (!result.containsKey(tmpChar)){

                if (characterList != null){

                    characterList.add(tmpChar);
                }

                result.put(tmpChar, 1);
            }else {

                result.put(tmpChar, result.get(tmpChar)+1);
            }
        }
        return result;
    }


    private boolean comparingMap(Map<Character, Integer> subString, Map<Character, Integer> anagram, List<Character> characterList){

        for (Character character : characterList){

            if (!subString.containsKey(character)) return false;

            if (!subString.get(character).equals(anagram.get(character))) return false;
        }

        return true;
    }


    @Test
    public void test(){

        List<Integer> result = findAnagrams("af", "be");

        Assert.assertEquals(result.size(), 0);

        List<Integer> result1 = findAnagrams("abab", "ab");

        Assert.assertEquals(result1.size(), 3);

        List<Integer> result2 = findAnagrams("cbaebabacd", "abc");

        Assert.assertEquals(result2.size(), 2);

        List<Integer> result3 = findAnagrams("acdcaeccde", "c");

        Assert.assertEquals(result3.size(), 4);


    }


}
