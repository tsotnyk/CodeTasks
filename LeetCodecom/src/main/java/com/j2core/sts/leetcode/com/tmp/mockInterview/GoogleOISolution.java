package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class GoogleOISolution {

    public String removeDuplicates(String S) {

        ArrayList<Character> charList = new ArrayList<>();
        int index = 0;
        while (index < S.length()-1){
            if (S.charAt(index) == S.charAt(index+1)){
                index += 2;
                continue;
            }
            charList.add(S.charAt(index++));
        }

        if (index != S.length()) {
            charList.add(S.charAt(S.length() - 1));
        }
        boolean removals = true;

        while (removals){
            removals = false;
            for (int j = 0; j < charList.size()-1; j++){
                if (charList.get(j).equals(charList.get(j+1))){
                    removals = true;
                    charList.remove(j);
                    charList.remove(j);
                    break;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char symbol: charList){
            builder.append(symbol);
        }
        return builder.toString();
    }

    @Test
    public void testRemoveDuplicates(){

        Assert.assertEquals("", removeDuplicates("aaaaaaaa"));

        Assert.assertEquals("ca", removeDuplicates("abbaca"));
    }

    public String[] expand(String s) {

        ArrayList<String> list = new ArrayList<>();
        //todo


        return list.toArray(new String[list.size()]);
    }

    class StreamChecker {

        HashSet<String> wordSet;
        StringBuilder queryList;

        public StreamChecker(String[] words) {

            this.wordSet = new HashSet<>();
            this.wordSet.addAll(Arrays.asList(words));
            this.queryList = new StringBuilder();
        }

        public boolean query(char letter) {

            this.queryList.append(letter);
            for (int i = queryList.length()-1; i > -1; i--){
                if (this.wordSet.contains(this.queryList.substring(i))) return true;
            }

            return false;
        }
    }

    int removeOneDigit(String s, String t) {
        int counter = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                if(firstStringSmaller(s, t, i, -1)) counter ++;
            }
        }

        for(int i = 0; i < t.length(); i++){
            if(Character.isDigit(t.charAt(i))){
                if(firstStringSmaller(s, t, -1, i)) counter ++;
            }
        }
        return counter;
    }

    boolean firstStringSmaller(String first, String second, int index1, int index2){

        int i = 0;
        int j = 0;

        while (i < first.length() && j < second.length()){
            if(i == index1){
                i++;
                continue;
            }
            if(j == index2){
                j++;
                continue;
            }
            if(first.charAt(i) == second.charAt(j)){
                i++;
                j++;
                continue;
            }
            return first.charAt(i) < second.charAt(j);
        }

        return i == first.length();
    }

    @Test
    public void test(){

        Assert.assertEquals(removeOneDigit("6","h"), 1);
    }

    int[] longestInversionalSubarray(int[] a, int[] b, int[] c) {

        HashSet<Integer> setC = createSet(c);
        HashSet<Integer> setB = createSet(b);
        int indexS = 0;
        int indexE = 0;
        int tmpS = 0;
        for(int i = 0; i < a.length; i++){
            int num = a[i];
            if(setB.contains(num) && !setC.contains(num)){
                continue;
            }else{
                if(i-tmpS > indexE-indexS){
                    indexS = tmpS;
                    indexE = i;
                }
                tmpS = i+1;
            }
        }

        int[] result = new int[indexE - indexS];
        System.arraycopy(a, indexS, result, 0, indexE-indexS);
        return result;
    }

    HashSet<Integer> createSet(int[] array){

        HashSet<Integer> set = new HashSet<>();

        for(int num : array){
            set.add(num);
        }

        return set;
    }


}
