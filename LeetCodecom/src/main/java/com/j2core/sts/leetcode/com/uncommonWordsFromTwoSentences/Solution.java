package com.j2core.sts.leetcode.com.uncommonWordsFromTwoSentences;

import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public String[] uncommonFromSentences(String A, String B) {

        Map<String, Integer> map = new HashMap<>();

        getWords(A, map);
        getWords(B, map);

        List<String> list = new LinkedList<>();

        Set<Map.Entry<String, Integer>> set = map.entrySet();

        for (Map.Entry<String, Integer> entry : set){

            if(entry.getValue() < 2){
                list.add(entry.getKey());
            }
        }

        return createArray(list);
    }


    private String[] createArray(List<String> list){

        String[] result = new String[list.size()];

        int index = 0;

        for(String str : list){

            result[index] = str;
            index++;
        }
        return result;
    }


    private void getWords(String string, Map<String, Integer> map){

        Scanner scanner = new Scanner(string);

        while (scanner.hasNext()){

            String str = scanner.next();

            if (map.containsKey(str)){

                map.put(str, map.get(str)+1);
            }else {
                map.put(str, 1);
            }
        }

    }


    @Test
    public void test(){

        Map<String, Integer> map = new HashMap<>();

        getWords("word the word a try", map);

    }

}
