package com.j2core.sts.leetcode.com.string.goatLatin;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String toGoatLatin(String S) {

        StringBuilder result = new StringBuilder();
        String vowel = "aeiouAEIOU";

        int countWord = 0;

        List<String> wordList = createWordList(S);

        for (String string : wordList){

            if (countWord > 0){
                result.append(' ');
            }

            countWord++;
            if (vowel.indexOf(string.charAt(0)) > -1){

                result.append(string);

            }else {

                result.append(string.substring(1));
                result.append(string.charAt(0));
            }

            result.append("ma");

            for (int i = 0; i < countWord; i++){

                result.append('a');
            }

        }

        return result.toString();
    }





    private List<String> createWordList(String string){

        int index = 0;
        int firstIndex = 0;
        List<String> words = new LinkedList<>();

        while (index < string.length()){

            if (string.charAt(index) == ' '){

                words.add(string.substring(firstIndex, index));
                firstIndex = index + 1;

            }

            index++;
        }

        if (firstIndex < string.length()){
            words.add(string.substring(firstIndex));
        }

        return words;
    }

}
