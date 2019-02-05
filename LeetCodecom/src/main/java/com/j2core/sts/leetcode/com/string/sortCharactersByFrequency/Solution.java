package com.j2core.sts.leetcode.com.string.sortCharactersByFrequency;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String frequencySort(String s) {

        List<CountLetter> collection = new LinkedList<>();

        for (int i = 0; i < s.length(); i++){

            char tmp = s.charAt(i);
            if (collection.isEmpty()){
                collection.add(new CountLetter(tmp));
            }else {

                boolean flag = true;
                for (CountLetter counter : collection){

                    if (counter.letter == tmp){

                        flag = false;
                        counter.setCount();

                    }
                }
                if (flag){
                    collection.add(new CountLetter(tmp));
                }
            }
        }

        collection.sort(CountLetter::compareTo);

        StringBuilder result = new StringBuilder();

        for(int i = collection.size()-1; i > -1; i--){

            CountLetter countLetter = collection.get(i);
            for (int j = 0; j < countLetter.getCount(); j++){

                result.append(countLetter.getLetter());
            }

        }

        return result.toString();

    }

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

        public void setCount() {
            this.count = this.count + 1;
        }

        public char getLetter() {
            return letter;
        }
    }


    @Test
    public void test(){

        String result = frequencySort("bbAa");

        Assert.assertEquals(result, "bbAa");


    }


}
