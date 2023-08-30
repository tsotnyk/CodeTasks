package com.j2core.sts.leetcode.com.topKfrequentWords;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Solution1 {

    class Word{
        int counter;
        String word;

        public Word(int counter, String word) {
            this.counter = counter;
            this.word = word;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word1 = (Word) o;
            return Objects.equals(word, word1.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word);
        }
    }
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Word> map = new HashMap<>();

        for (String word : words){
            Word curWord = map.getOrDefault(word, new Word( 0, word));
            curWord.counter +=1;
            map.put(word, curWord);
        }

        List<Word> list = new LinkedList<>(map.values());
        list.sort((a, b) -> {
            if (a.counter == b.counter) return a.word.compareTo(b.word);
            return b.counter - a.counter;
        });

        List<String> res = new LinkedList<>();

        for (int i = 0; i < k; i++){
            res.add(list.get(i).word);
        }
        return res;
    }

}
