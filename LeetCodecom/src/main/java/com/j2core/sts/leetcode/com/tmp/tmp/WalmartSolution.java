package com.j2core.sts.leetcode.com.tmp.tmp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WalmartSolution {

    public List<String> createAllPermutationOfString(String text){

        if(text == null || text.length() < 1) return new LinkedList<>();
        if(text.length() == 1) return new LinkedList<>(Arrays.asList(text));

        ArrayList<List<Character>> permutationList = new ArrayList<>();
        ArrayList<Character> firstSymbol = new ArrayList<>();
        firstSymbol.add(text.charAt(0));// a
        permutationList.add(firstSymbol);
        int index = 1;

        while(index < text.length()){
            ArrayList<List<Character>> nextPermutations = new ArrayList<>();
            char symbol = text.charAt(index++); // symbol = b , index == 2;
            for(List<Character> tmpList : permutationList){

                for(int i = 0;  i < tmpList.size(); i++){ // tmpList.Size ==1  i < 1;
                    ArrayList<Character> nextTmpList = new ArrayList<>(tmpList);// nextTmpList  = “a”
                    nextTmpList.add(i, symbol); // a,c ,b
                    nextPermutations.add(nextTmpList);
                }
                tmpList.add(symbol);
                nextPermutations.add(tmpList);
            }
            permutationList = nextPermutations;
        }


        List<String> resultList = new LinkedList<>();
        for(List<Character> list : permutationList){

            StringBuilder builder = new StringBuilder();
            for(char symbol : list){

                builder.append(symbol);
            }
            resultList.add(builder.toString());
        }
        return resultList;
    }

    @Test
    public void test(){

        List<String> result = createAllPermutationOfString("abc");
        for (String word : result){
            System.out.println(word);
        }
    }

}
