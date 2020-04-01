package com.j2core.sts.leetcode.com.string.uniqueWordAbbreviation;

import java.util.HashMap;
import java.util.HashSet;

public class ValidWordAbbr {

    HashMap<String, HashSet<String>> uniqAbbr;

    public ValidWordAbbr(String[] dictionary) {

        uniqAbbr = new HashMap<>();

        for (String word : dictionary){

            int length = word.length();

                String abbr = length > 2 ? word.charAt(0) + String.valueOf(length - 2) + word.charAt(length - 1) : word;

                HashSet<String> set = uniqAbbr.getOrDefault(abbr, new HashSet<>());
                set.add(word);
                uniqAbbr.put(abbr, set);
        }
    }

    public boolean isUnique(String word) {

        int length = word.length();
        String abbr = length > 2 ? word.charAt(0) + String.valueOf(length-2) + word.charAt(length-1) : word;

        HashSet<String> set = uniqAbbr.getOrDefault(abbr, null);

        if (set == null) return true;

        return set.size() == 1 && set.contains(word);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
