package com.j2core.sts.codefights.com.specialTopics.strings.textJustification;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    String[] textJustification(String[] words, int l) {

        List<String> result = new LinkedList<String>();

        for (int i = 0; i < words.length; ){

            int startIndex = i;
            int tmpLength = words[i].length();
            i++;
            int delta = 0;
            while (i < words.length && tmpLength + words[i].length() + delta < l){

                tmpLength = tmpLength + words[i].length();
                delta++;
                i++;
            }

            int amountFreeSpace = l - tmpLength;
            int amountWords = i - startIndex;
            boolean lastWords;
            lastWords = i == words.length;

            result.add(addFreeSpaces(amountWords, lastWords, words, startIndex, amountFreeSpace));

        }

        String[] newResult = new String[result.size()];

        for (int i = 0; i < result.size(); i++){

            newResult[i] = result.get(i);
        }

        return newResult;

    }


    private String addFreeSpaces(int amountWord, boolean lastWords, String[] words, int startIndex, int amountFreeSpaces){

        StringBuilder stringBuilder = new StringBuilder();

        if (amountWord < 2){

            stringBuilder.append(words[startIndex]);
            while (amountFreeSpaces > 0){
                stringBuilder.append(" ");
                amountFreeSpaces--;
            }

        }else if (amountWord == 2 && !lastWords){

            stringBuilder.append(words[startIndex]);
            startIndex++;
            while (amountFreeSpaces > 0){
                stringBuilder.append(" ");
                amountFreeSpaces--;
            }
            stringBuilder.append(words[startIndex]);

        }else if (lastWords){

            stringBuilder.append(words[startIndex]);
            for (int i = startIndex+1; i < words.length; i++){

                stringBuilder.append(" ").append(words[i]);
                amountFreeSpaces--;
            }
            for (int k = 0; k < amountFreeSpaces; k++) {
                stringBuilder.append(" ");
            }

        }else {

            int[] deltaFreeSpaces = new int[amountWord-1];
            for (int h = 0; h < amountFreeSpaces; ){
                for (int j = 0; j < deltaFreeSpaces.length; j++){
                    if (h < amountFreeSpaces){
                        deltaFreeSpaces[j] = deltaFreeSpaces[j] + 1;
                        h++;
                    }else break;
                }
            }
            for (int deltaFreeSpace : deltaFreeSpaces) {

                stringBuilder.append(words[startIndex]);
                for (int k = 0; k < deltaFreeSpace; k++) {
                    stringBuilder.append(" ");
                }
                startIndex++;
            }
            stringBuilder.append(words[startIndex]);
        }

        return stringBuilder.toString();
    }
}
