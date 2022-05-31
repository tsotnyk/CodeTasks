package com.j2core.sts.leetcode.com.groupShiftedStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    public List<List<String>> groupStrings(String[] strings) {

        HashMap<DeltaSymbols, List<String>> map = new HashMap<>();

        for (String word : strings){

            DeltaSymbols wordDeltas = createDeltaSymbols(word);
            if (map.containsKey(wordDeltas)){
                map.get(wordDeltas).add(word);
            }else {
                map.put(wordDeltas, new LinkedList<>(Collections.singletonList(word)));
            }
        }

        return new LinkedList<>(map.values());
    }

    private DeltaSymbols createDeltaSymbols(String word){

        List<Integer> list = new LinkedList<>();

        int index = 1;

        while (index < word.length()){
            int delta = (word.charAt(index-1)-word.charAt(index));
            if (delta > 0){
                delta = delta - 26;
            }
            list.add(delta);

            index++;
        }

        return new DeltaSymbols(list);
    }

    class DeltaSymbols{

        List<Integer> deltasList;

        public DeltaSymbols(List<Integer> list){
            this.deltasList = list;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DeltaSymbols object = (DeltaSymbols) o;
            if (this.deltasList.size() != object.deltasList.size()) return false;

            for (int i = 0; i < this.deltasList.size(); i++){

                if (!this.deltasList.get(i).equals( object.deltasList.get(i))) return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(deltasList);
        }
    }

    @Test
    public void test(){

        System.out.println(groupStrings(new String[]{"az","ba"}));
        System.out.println(groupStrings(new String[]{"ab","ba"}));
        System.out.println("************************");
        System.out.println(groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"}));
        System.out.println("*************************");
        System.out.println(groupStrings(new String[]{"a"}));
    }
}
