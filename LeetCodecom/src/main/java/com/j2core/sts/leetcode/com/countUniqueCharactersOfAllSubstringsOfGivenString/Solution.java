package com.j2core.sts.leetcode.com.countUniqueCharactersOfAllSubstringsOfGivenString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public int uniqueLetterString(String s) {

        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int counter = 0;
        int sI = 0;

        HashMap<Character, Integer> letters = new HashMap<>();
        HashSet<Character> uniqLetter = new HashSet<>();

        while (sI < s.length()){
            for (int i = sI; i < s.length(); i++){
                addLetter(s.charAt(i), letters, uniqLetter);
                counter += uniqLetter.size();
            }
            removeLetter(s.charAt(sI++), letters, uniqLetter);
            for (int i = s.length()-1; i >= sI; i--){
                counter += uniqLetter.size();
                removeLetter(s.charAt(i), letters, uniqLetter);
            }
            sI++;
        }

        return counter;
    }

    private void addLetter(char symbol, HashMap<Character, Integer> letters, HashSet<Character> uniq){

        int counter = letters.getOrDefault(symbol, 0);
        letters.put(symbol, counter+1);
        if (counter == 0){
            uniq.add(symbol);
            return;
        }
        if (counter == 1) uniq.remove(symbol);

    }

    private void removeLetter(char symbol, HashMap<Character, Integer> letters, HashSet<Character> uniq){

        uniq.remove(symbol);
        int counter = letters.get(symbol);
        letters.put(symbol, --counter);
        if (counter == 1) uniq.add(symbol);
    }

    @Test
    public void test(){

        Assert.assertEquals(uniqueLetterString("LEETCODE"), 92);
    }

    public int uniqueLetterString1(String s) {

        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 0;
        int counter = 0;

        HashMap<Character, Integer> letters = new HashMap<>();
        HashSet<Character> uniqLetter = new HashSet<>();

        int[] countUniqLetter = countUniqLetters(s, letters, uniqLetter);

        for (int i = 0; i < s.length(); i++){
            // todo 2. remove i char from letters and uniqLetter 3. move to next iteration
            for (int index = i; index < s.length(); index++){
                counter+= countUniqLetter[index];
            }
            char removeChar = s.charAt(i);
            if (uniqLetter.contains(removeChar)){

            }
        }

        return counter;
    }

    private int[] countUniqLetters(String s, HashMap<Character, Integer> letters, HashSet<Character> uniqLetter){

        int[] array= new int[s.length()];
        int index = 0;
        for (char symbol : s.toCharArray()){
            if (letters.containsKey(symbol)){
                letters.put(symbol, letters.get(symbol)+1);
            }else {
                if (uniqLetter.contains(symbol)){
                    uniqLetter.remove(symbol);
                    letters.put(symbol, 2);
                }else {
                    uniqLetter.add(symbol);
                }
            }
            array[index++] = uniqLetter.size();
        }
        return array;
    }
}
