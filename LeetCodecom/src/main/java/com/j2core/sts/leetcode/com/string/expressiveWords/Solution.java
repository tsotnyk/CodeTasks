package com.j2core.sts.leetcode.com.string.expressiveWords;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public int expressiveWords(String S, String[] words) {

        class SymbolCounter{
            int counter;
            char symbol;

            public SymbolCounter(char symbol, int counter){
                this.counter = counter;
                this.symbol = symbol;
            }

            public boolean isCorrectPair(char symbol, int counter){

                if (this.symbol != symbol) return false;
                if (this.counter < 3) return this.counter == counter;
                if (this.counter == 3) return counter == 1;
                return counter <= 2;
            }
        }
        if (S.length() < 1) return 0;

        List<SymbolCounter> symbols = new ArrayList<>();

        int index = 0;
        char symbol = S.charAt(index++);
        int counter = 1;

        while (index <  S.length()){
            if (symbol == S.charAt(index)){
                counter++;
            }else {
                symbols.add(new SymbolCounter(symbol, counter));
                counter = 1;
                symbol = S.charAt(index);
            }
            index++;
        }

        symbols.add(new SymbolCounter(symbol, counter));
        int count = 0;
        for (String word : words){
            boolean flag = true;
            int pairIndex = 0;
            int i = 0;
            char tmpSymbol = word.charAt(i++);
            int countChar = 1;
            while (i < word.length()){
                if (tmpSymbol == word.charAt(i)){
                    countChar++;
                }else {
                    if (!symbols.get(pairIndex).isCorrectPair(tmpSymbol, countChar)){
                        flag = false;
                        break;
                    }else {
                        tmpSymbol = word.charAt(i);
                        countChar = 1;
                        pairIndex++;
                    }
                }
                i++;
            }
            if (flag && symbols.get(pairIndex++).isCorrectPair(tmpSymbol, countChar)){
                if (pairIndex == symbols.size()) {
                    count++;
                }
            }
        }
        return count;
    }

//    public int expressiveWords(String S, String[] words) {
//
//        Map<Integer, Set<Character>> inputMap = createInputMap(S);
//        int counter = 0;
//        for (String word : words){
//            boolean flag = true;
//            for (int i = 0; i < word.length(); i++){
//                if (!inputMap.get(i).contains(word.charAt(i))){
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) counter++;
//        }
//
//        return counter;
//    }
//
//    private Map<Integer, Set<Character>> createInputMap(String s) {
//
//        Map<Integer, Set<Character>> inputMap = new HashMap<>();
//
//        int mapIndex = 0;
//        int index = 0;
//        char symbol = s.charAt(index++);
//        int counter = 1;
//
//        do {
//            if (index < s.length() && s.charAt(index) == symbol){
//                counter++;
//            }else {
//                switch (counter){
//                    case 1:
//                    case 3:
//                        addCharacter(inputMap, mapIndex++, symbol);
//                        break;
//                    case 2:
//                        addCharacter(inputMap, mapIndex++, symbol);
//                        addCharacter(inputMap, mapIndex++, symbol);
//                        break;
//                    default:
//                        addCharacter(inputMap, mapIndex, symbol);
//                        addCharacter(inputMap, mapIndex+1, symbol);
//                        mapIndex++;
//                        break;
//                }
//
//                counter = 1;
//                if (index < s.length()){
//                    symbol = s.charAt(index);
//                }
//            }
//            index++;
//        }while (index <= s.length());
//
//
//
//        return inputMap;
//    }
//
//    private void addCharacter(Map<Integer, Set<Character>> map, int index, char symbol){
//        if (map.containsKey(index)){
//            map.get(index).add(symbol);
//            Set<Character> set = new HashSet<>();
//            set.add(symbol);
//            map.put(index+1, set);
//        }else {
//            Set<Character> set = new HashSet<>();
//            set.add(symbol);
//            map.put(index, set);
//        }
//    }

    @Test
    public void test(){

        List<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Collections.reverse(list);

        Assert.assertEquals(expressiveWords("dddiiiinnssssssoooo", new String[]{"dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"}), 3);
        Assert.assertEquals(expressiveWords("abcd", new String[]{"abc"}), 0);

        Assert.assertEquals(expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}), 1);
        Assert.assertEquals(expressiveWords("heeellllooo", new String[]{"hello", "hi", "helo"}), 2);
    }
}
