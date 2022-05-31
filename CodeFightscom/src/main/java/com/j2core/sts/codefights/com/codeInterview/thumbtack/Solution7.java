package com.j2core.sts.codefights.com.codeInterview.thumbtack;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution7 {

    int[][] spamClusterization(String[] requests, int[] ids, double threshold) {


        //todo
        return null;
    }

    private List<String> createWordArray(char[] text){
        List<String> list = new LinkedList<>();
        int indexStart = 0;
        int index = 0;
        StringBuilder builder = new StringBuilder();
        while (index < text.length){
            char symbol = text[index];
            if (Character.isLetter(symbol)){
                builder.append(Character.toLowerCase(symbol));
            }else{
                if (index != indexStart){
                    list.add(builder.toString());
                    builder = new StringBuilder();
                    indexStart = index+1;
                }else {
                    indexStart++;
                }
            }
            index++;
        }

        if (index != indexStart){
            list.add(builder.toString());
        }
        return list;
    }

    @Test
    public void test(){

        String text = "I need a new window.";
        List<String> list = createWordArray(text.toCharArray());
        Assert.assertEquals(5, list.size());
    }
}
