package com.j2core.sts.leetcode.com.mostCommonWord;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {

        dropPunctuationSymbols(paragraph);
        paragraph.toLowerCase();

        Scanner scanner = new Scanner(paragraph);
        String[] wordArray = scanner.nextLine().split(" ");

        Map<String, Integer> map = createWordMap(wordArray);

        return findMostWord(map, banned);

    }


    private String findMostWord(Map<String, Integer> map, String[] array){

        int count = 0;
        String result = null;

        Set<Map.Entry<String, Integer>> set = map.entrySet();

        for (Map.Entry entry : set){

            if ((int)entry.getValue() > count){
                boolean flag = false;
                for (String str : array){
                    if (str.equals(entry.getKey())){
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    count = (int) entry.getValue();
                    result = (String) entry.getKey();
                }
            }

        }

        return result;
    }

    private Map<String, Integer> createWordMap(String[] array){

        Map <String, Integer> map = new HashMap<>();

        for (String string : array){

            if (map.containsKey(string)){
                map.put(string, map.get(string) + 1);
            }else {
                map.put(string, 1);
            }
        }
        return map;
    }

    private void dropPunctuationSymbols(String string){

        String symbols = "!?',;.";

        for (int i = 0; i < symbols.length(); i++){

            String tmp = String.valueOf(symbols.charAt(i));
            if (string.contains(tmp)) {
                string.replaceAll(tmp, "");
            }
        }
    }


    @Test
    public void test(){

        String tmop = mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});

    }
}
