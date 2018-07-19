package com.j2core.sts.leetcode.com.string.reorganizeString;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    class CountLetter implements Comparable<CountLetter>{

        private Integer count = 1;
        private char letter;

        public CountLetter(char letter) {
            this.letter = letter;
        }

        @Override
        public int compareTo(CountLetter obj) {

            return count.compareTo(obj.count);
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(int delta) {
            this.count = this.count + delta;
        }

        public char getLetter() {
            return letter;
        }
    }

    public String reorganizeString(String S) {

        int delta = (S.length()) % 2;


        List<CountLetter> countLetters = new LinkedList<>();

        for (int i = 0; i < S.length(); i++){

            char tmp = S.charAt(i);
            boolean flag = true;
            for (CountLetter countLetter : countLetters){

                if (countLetter.letter == tmp){
                    flag = false;
                    countLetter.setCount(1);
                }
            }
            if (flag){
                countLetters.add(new CountLetter(tmp));
            }
        }

        countLetters.sort(CountLetter::compareTo);


        if (countLetters.get(countLetters.size()-1).getCount() > S.length()/2+delta){
            return "";
        }else {

            return mixLetters(countLetters);

        }
    }


    public String mixLetters(List<CountLetter> countLetters){

        StringBuilder result = new StringBuilder();

        int lastIndex = countLetters.size()-1;
        CountLetter countLetter = countLetters.get(lastIndex);
        lastIndex--;

        result.append(countLetter.getLetter());
        countLetter.setCount(-1);

        for (int j = lastIndex; j > -1; j--){

            CountLetter tmpCountLetter = countLetters.get(j);

            for (int k = tmpCountLetter.getCount(); k > 0; k--){

                result.append(tmpCountLetter.getLetter());
                tmpCountLetter.setCount(-1);
                if (countLetter.getCount() > 0) {
                    result.append(countLetter.getLetter());
                    countLetter.setCount(-1);
                    if (countLetter.getCount() == 0){
                        j--;
                        if (j > -1) {
                            countLetter = countLetters.get(j);
                        }
                    }
                }
            }

        }

        if (countLetter.getCount() > 0){

            return countLetter.getLetter() + result.toString();
        }else return result.toString();

    }


    @Test
    public void test(){

        String result = reorganizeString("abbabababbabbbaabaaaaabbbbabbbbbababbbabbabbb");

        Assert.assertTrue(result.length() > 0);

    }
}
