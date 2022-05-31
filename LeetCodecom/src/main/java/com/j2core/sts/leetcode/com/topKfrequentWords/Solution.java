package com.j2core.sts.leetcode.com.topKfrequentWords;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    class UniqWord{

        String word;
        int count;

        public UniqWord(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public String getWord() {
            return word;
        }
        public int getCount() {
            return count;
        }

        public void setCount() {
            this.count += 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UniqWord uniqWord = (UniqWord) o;
            return Objects.equals(word, uniqWord.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, UniqWord> map = new HashMap<>();

        for (String word : words){
            if (map.containsKey(word)){
                map.get(word).setCount();
            }else {
                map.put(word, new UniqWord(word, 1));
            }
        }

        List<UniqWord> list = new LinkedList<>(map.values());
        Collections.sort(list, (t1, t2) ->{

            if (t2.getCount() == t1.getCount()){
                return t1.getWord().compareTo(t2.getWord());
            }
            return t2.getCount() - t1.getCount();
        });
        List<String> result = new LinkedList<>();
        int index = 0;
        for (UniqWord word : list){
            if (index == k) break;
            result.add(word.getWord());
            index++;
        }
        return result;
    }

    @Test
    public void test(){
        Assert.assertEquals(new LinkedList<>(Arrays.asList("a")), topKFrequent(new String[]{"a", "aa", "aaa"}, 1));

        Assert.assertEquals(new LinkedList<>(Arrays.asList("i", "love")), topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        Assert.assertEquals(new LinkedList<>(Arrays.asList("the", "is", "sunny", "day")), topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},
        4));

    }
}
