package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class AppleOASolution1 {

    public int balancedStringSplit(String s) {

        int result = 0;
        int counter = 0;
        for (char symbol : s.toCharArray()){
            if (symbol == 'R'){
                counter++;
            }else counter--;
            if (counter == 0) result++;
        }

        return  result;
    }

    public List<String> commonChars(String[] A) {

        int[] symbols = new int[26];
        for (int symbol : A[0].toCharArray()){
            symbols[symbol-'a'] += 1;
        }
        for (int i = 1; i < A.length; i++){
            int[] nextSymbols = new int[26];
            for(int symbol : A[i].toCharArray()){
                int sym = symbol - 'a';
                if (symbols[sym] > nextSymbols[sym]){
                    nextSymbols[sym] += 1;
                }
            }
            symbols = nextSymbols;
        }

        List<String> result = new LinkedList<>();
        char symbol = 'a';
        for (int count : symbols){
            if (count > 0){
                while (count-- > 0){
                    result.add(String.valueOf(symbol));
                }
            }
            symbol++;
        }

        return result;
    }

    @Test
    public void test(){

        Assert.assertEquals(commonChars(new String[]{"bella","label","roller"}).size(), 3);
        Assert.assertEquals(commonChars(new String[]{"cool","lock","cook"}).size(), 2);

    }
}
