package com.j2core.sts.leetcode.com.design.designSearchAutocompleteSystem;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class AutocompleteSystem {

    String input;
    Map<Character, List<Pair>> sentencesMap;

    class Pair implements Comparable<Pair>{

        String sentences;
        int times;

        public Pair(String sentences, int times) {
            this.sentences = sentences;
            this.times = times;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(sentences, pair.sentences);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sentences);
        }

        @Override
        public int compareTo(Pair pair) {
            if (times == pair.times){
                return sentences.compareTo(pair.sentences);
            }
            return pair.times - times;
        }

        public boolean comparePrefix(String prefix){

            if (prefix.length() > sentences.length()) return false;
            if (sentences.length() == prefix.length()) return sentences.equals(prefix);

            return prefix.equals(sentences.substring(0, prefix.length()));
        }
    }

    public AutocompleteSystem(String[] sentences, int[] times) {

        this.input = "";
        this.sentencesMap = new HashMap<>();
        List<Pair> list;

        for (int i = 0; i < sentences.length; i++){
            list = sentencesMap.getOrDefault(sentences[i].charAt(0), new LinkedList<>());
            list.add(new Pair(sentences[i], times[i]));
            sentencesMap.put(sentences[i].charAt(0), list);
        }

        for (Character key : sentencesMap.keySet()){
            list = sentencesMap.get(key);
            Collections.sort(list);
        }
    }

    public List<String> input(char c) {

        List<String> result = new LinkedList<>();
        if (c == '#'){
            addNewSentences(this.input);
            this.input = "";
            return result;
        }

        this.input += c;

        List<Pair> list = this.sentencesMap.getOrDefault(this.input.charAt(0), null);

        if (list != null){
            int counter = 3;
            for (Pair pair : list){
                if (pair.comparePrefix(this.input)){
                    result.add(pair.sentences);
                    if (counter < 2) break;
                    counter--;
                }
            }
        }

        return result;
    }

    private void addNewSentences(String newSentences){

        List<Pair> list = this.sentencesMap.getOrDefault(newSentences.charAt(0), new LinkedList<>());
        boolean flag = true;
        for (Pair pair : list){
            if (pair.sentences.equals(newSentences)){
                pair.times += 1;
                flag = false;
            }
        }

        if (flag) {
            list.add(new Pair(newSentences, 1));
        }
        Collections.sort(list);
        sentencesMap.put(newSentences.charAt(0), list);
    }

    @Test
    public static void test(){

        AutocompleteSystem system = new AutocompleteSystem(new String[]{"i love you", "island","ironman", "i love leetcode"}, new int[]{5,3,2,2});
        List<String> result1 = system.input('i');
        List<String> result2 = system.input(' ');
        List<String> result3 = system.input('a');
        List<String> result4 = system.input('#');
        List<String> result5 = system.input('i');
        List<String> result6 = system.input(' ');
        List<String> result7 = system.input('a');
        List<String> result8 = system.input('#');
        List<String> result9 = system.input('i');
        List<String> result10 = system.input(' ');
        List<String> result11 = system.input('a');
        List<String> result12 = system.input('#');

        Assert.assertEquals(result12.size(), 0);

//        AutocompleteSystem system = new AutocompleteSystem(new String[]{"abc","abbc","a"}, new int[]{3,3,3});
//        List<String> result1 = system.input('b');
//        List<String> result2 = system.input('c');
//        List<String> result3 = system.input('#');
//        List<String> result4 = system.input('b');
//        List<String> result5 = system.input('c');
//        List<String> result6 = system.input('#');
//        List<String> result7 = system.input('a');
//        List<String> result8 = system.input('b');
//        List<String> result9 = system.input('c');
//        List<String> result10 = system.input('#');
//        List<String> result11 = system.input('a');
//        List<String> result12 = system.input('b');
//        List<String> result13 = system.input('c');
//        List<String> result14 = system.input('#');
//
//        Assert.assertEquals(result14.size(), 0);

    }
}
