package com.j2core.sts.leetcode.com.numberOfDifferentIntegersInString;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class Solution {

    public int numDifferentIntegers(String word) {

        HashSet<String> numbers = new HashSet<>();

        int indexS = 0;
        int indexE = 0;

        while (indexE < word.length()){

            if (Character.isDigit(word.charAt(indexE))){
                indexE++;
                while (indexE < word.length() && Character.isDigit(word.charAt(indexE))){
                    indexE++;
                }
                String num = word.substring(indexS, indexE);
                int i = 0;
                while (i < num.length()-1){
                    if (num.charAt(i) == '0'){
                        i++;
                    }else {
                        break;
                    }
                }
                numbers.add(num.substring(i));
            }else {
                indexE++;
                indexS = indexE;
            }
        }

        return numbers.size();
    }

    @Test
    public void test(){

        Assert.assertEquals(numDifferentIntegers("leet1234code234"), 2);
        Assert.assertEquals(numDifferentIntegers("a1b01c001"), 1);

    }
}
