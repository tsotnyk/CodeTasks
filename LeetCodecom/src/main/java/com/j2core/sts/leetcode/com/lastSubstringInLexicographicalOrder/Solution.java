package com.j2core.sts.leetcode.com.lastSubstringInLexicographicalOrder;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public String lastSubstring(String s) {

        char[] arr = s.toCharArray();
        int curr = 0;
        int i = 1;
        while( i < s.length()){
            if( arr[i] > arr[curr]){
                curr = i++;
            } else if ( arr[i] == arr[curr]){
                int j = 1;
                while( i+j < s.length() && arr[i+j] == arr[curr+j])
                    j++;

                int tmp = curr;
                if( i+j < s.length() && arr[i+j] > arr[curr+j]){
                    curr = i;
                    i++;
                } else {
                    i += j;
                }
            } else {
                i++;
            }
        }
        return s.substring(curr);

    }

//    public String lastSubstring(String s) {
//
//        HashMap<Character, List<String>> map = new HashMap<>();
////        char maxSymbol = findMaxStartingSubstringCharacter(map, s);
//
//        char maxChar = findMaxLexicographicalSubString(map, s);
//        LinkedList<String> list = (LinkedList<String>) map.get(maxChar);
//        Collections.sort(list);
//        return list.removeLast();
//
//
////        if (map.size() == 1) return s;
////        List<Integer> candidate2Substring = map.get(maxSymbol);
////
////        if (candidate2Substring.size() == 1) return s.substring(candidate2Substring.get(0));
////
////        return findMaxLexicographicalSubstring(candidate2Substring, s);
//    }
//
//    private char findMaxLexicographicalSubString(Map<Character, List<String>> characterMap, String str){
//        char maxSymbol = str.charAt(0);
//        characterMap.put(str.charAt(0), new LinkedList<>(Arrays.asList(str.substring(0))));
//        for (int i = 1; i < str.length(); i++){
//            char symbol = str.charAt(i);
//            if (characterMap.containsKey(symbol)){
//                characterMap.get(symbol).add(str.substring(i));
//            }else {
//                characterMap.put(symbol, new LinkedList<>(Arrays.asList(str.substring(i))));
//            }
//            if (maxSymbol < symbol){
//                maxSymbol = symbol;
//            }
//        }
//
//        return maxSymbol;
//    }
//
//    private String findMaxLexicographicalSubstring(List<Integer> candidate2Substring, String str) {
//
//        int index = candidate2Substring.remove(0);
//        String candidate = str.substring(index);
//
//        while (!candidate2Substring.isEmpty()){
//            index = candidate2Substring.remove(0);
//            String nextCandidate = str.substring(index);
//            if (nextCandidateBigger(nextCandidate, candidate)){
//                candidate = nextCandidate;
//            }
//        }
//
//        return candidate;
//    }
//
//    private boolean nextCandidateBigger(String nextCandidate, String candidate) {
//
//        int length = Math.min(nextCandidate.length(), candidate.length());
//        for (int i = 1; i < length; i++){
//            if (nextCandidate.charAt(i) != candidate.charAt(i)){
//                return nextCandidate.charAt(i) > candidate.charAt(i);
//            }
//        }
//
//        return nextCandidate.length() > length;
//    }
//
//    private char findMaxStartingSubstringCharacter (Map<Character, List<Integer>> characterMap, String str){
//
//        char maxSymbol = str.charAt(0);
//        characterMap.put(str.charAt(0), new LinkedList<>(Arrays.asList(0)));
//        for (int i = 1; i < str.length(); i++){
//            char symbol = str.charAt(i);
//            if (characterMap.containsKey(symbol)){
//                characterMap.get(symbol).add(i);
//            }else {
//                characterMap.put(symbol, new LinkedList<>(Arrays.asList(i)));
//            }
//            if (maxSymbol < symbol){
//                maxSymbol = symbol;
//            }
//        }
//
//        return maxSymbol;
//    }

    @Test
    public void test(){

        Assert.assertEquals(lastSubstring("abab"), "bab");
        Assert.assertEquals(lastSubstring("leetcode"), "tcode");
    }
}
