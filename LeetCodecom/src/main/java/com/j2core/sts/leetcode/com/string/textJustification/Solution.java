package com.j2core.sts.leetcode.com.string.textJustification;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {

        return createStringList(findWordsForEachRow(words, maxWidth), maxWidth);
    }

    private List<List<String>> findWordsForEachRow(String[] words, int maxWidth){

        List<List<String>> result = new ArrayList<>();
        List<String> tmpList = new ArrayList<>();
        tmpList.add(words[0]);
        int counter = words[0].length();

        for (int i = 1; i < words.length; i++){
            if (counter+1+words[i].length() <= maxWidth){
                tmpList.add(words[i]);
                counter += words[i].length()+1;
            }else {
                result.add(tmpList);
                tmpList.add(String.valueOf(counter));
                tmpList = new ArrayList<>();
                tmpList.add(words[i]);
                counter = words[i].length();
            }
        }

        if (!tmpList.isEmpty()){
            tmpList.add(String.valueOf(counter));
            result.add(tmpList);
        }
        return result;
    }

    private List<String> createStringList(List<List<String>> rows, int maxWidth){

        List<String> result = new ArrayList<>(rows.size());
        int counter = 0;

        while (counter < rows.size()-1){

            result.add(createString(rows.get(counter), maxWidth));
            counter++;
        }

        List<String> tmpList = rows.get(counter);
        StringBuilder builder = new StringBuilder();
        builder.append(tmpList.get(0));
        for (int i = 1; i < tmpList.size()-1; i++){
            builder.append(' ').append(tmpList.get(i));
        }
        int tmpCounter = Integer.parseInt(tmpList.get(tmpList.size()-1));
        while (tmpCounter++ < maxWidth){
            builder.append(' ');
        }
        result.add(builder.toString());

        return result;
    }

    private String createString(List<String> list, int maxWidth){

        int size = list.size();
        int spaceCounter = size-2;
        StringBuilder builder = new StringBuilder();
        int minLength = Integer.parseInt(list.get(size-1));

        if (spaceCounter == 0){
            builder.append(list.get(0));
            int spaces = maxWidth - minLength;
            while (spaces-- > 0){
                builder.append(' ');
            }
        }else if (spaceCounter == 1){
            builder.append(list.get(0)).append(' ');
            while (minLength++ < maxWidth){
                builder.append(' ');
            }
            builder.append(list.get(1));
        }else {
            int[] array = new int[spaceCounter];
            int spaces = maxWidth - minLength + spaceCounter;
            int spacesBetweenWords = spaces/spaceCounter;
            Arrays.fill(array, spacesBetweenWords);
            int delta = spaces%spaceCounter;
            if (delta != 0){
                for (int j = 0; j < array.length; j++){
                    if (delta == 0){
                        break;
                    }
                    array[j] += 1;
                    delta--;
                }
            }
            for (int i = 0; i < size-2; i++){
                builder.append(list.get(i));
                int count = array[i];
                while (count-- > 0){
                    builder.append(' ');
                }
            }
            builder.append(list.get(size-2));
        }

        return builder.toString();
    }

    @Test
    public void test(){

        List<String> result = fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        Assert.assertEquals(result.size(), 3);
        Assert.assertEquals(result.get(0).length(), 16);
        Assert.assertEquals(result.get(1).length(), 16);
        Assert.assertEquals(result.get(2).length(), 16);

        //["Science  is  what we","understand       well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
    }
}
