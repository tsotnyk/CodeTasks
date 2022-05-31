package com.j2core.sts.leetcode.com.vowelSpellchecker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public String[] spellchecker(String[] wordlist, String[] queries) {

        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        HashSet<String> set = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String, String> caseInsensitive = new HashMap<>();
        HashMap<String, String> replacingVowels = new HashMap<>();
        for (String word : wordlist){

            String insensitive = word.toLowerCase();
            if (!caseInsensitive.containsKey(insensitive)){
                caseInsensitive.put(insensitive, word);
                StringBuilder builder = new StringBuilder();
                for (char symbol : insensitive.toCharArray()){
                    if (vowels.contains(symbol)){
                        builder.append('?');
                    }else {
                        builder.append(symbol);
                    }
                }
                replacingVowels.putIfAbsent(builder.toString(), word);
            }
        }

        String[] result = new String[queries.length];
        int index = 0;
        for (String query : queries){

            if (set.contains(query)){
                result[index++] = query;
                continue;
            }
            String queryInsensitive = query.toLowerCase();
            if (caseInsensitive.containsKey(queryInsensitive)){
                result[index++] = caseInsensitive.get(queryInsensitive);
                continue;
            }
            StringBuilder builder = new StringBuilder();
            for (char symbol : queryInsensitive.toCharArray()){
                if (vowels.contains(symbol)){
                    builder.append('?');
                }else {
                    builder.append(symbol);
                }
            }

            result[index++] = replacingVowels.getOrDefault(builder.toString(), "");
        }

        return result;
    }
}
