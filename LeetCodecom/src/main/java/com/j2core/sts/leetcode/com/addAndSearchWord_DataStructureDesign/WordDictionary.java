package com.j2core.sts.leetcode.com.addAndSearchWord_DataStructureDesign;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordDictionary {

    private Map<Integer, Set<String>> map;
    /** Initialize your data structure here. */
    public WordDictionary() {

        map = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        int first = word.length();
        Set<String> list;
        if (map.containsKey(first)){

            list = map.get(first);
            list.add(word);
            map.put(first, list);
        }else {

            list = new HashSet<>();
            list.add(word);
            map.put(first, list);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {

        int length = word.length();
        if (!map.containsKey(length)) return false;

        Set<String> set = map.get(length);

        if (isFullWord(word)){
            return set.contains(word);
        }else {
            for (String base : set){

                if (equalsString(base, word)) return true;
            }
            return false;
        }
    }

    private boolean isFullWord(String word) {

        return word.indexOf('.') == -1;
    }

    private boolean equalsString(String base, String word){

        if (base.length() != word.length()) return false;

        for (int i = 0; i < word.length(); i++){

            char  tmp = word.charAt(i);
            if (tmp != '.'){
                if (tmp != base.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
