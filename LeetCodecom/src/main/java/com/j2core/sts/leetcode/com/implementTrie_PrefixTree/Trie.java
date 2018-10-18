package com.j2core.sts.leetcode.com.implementTrie_PrefixTree;

import java.util.HashSet;
import java.util.Set;

public class Trie {

    private Set<String> set;
    /** Initialize your data structure here. */
    public Trie() {

        set = new HashSet<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        set.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        return set.contains(word);

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        for (String word : set){

            if (word.indexOf(prefix) == 0){
                return true;
            }
        }

        return false;
    }
}
