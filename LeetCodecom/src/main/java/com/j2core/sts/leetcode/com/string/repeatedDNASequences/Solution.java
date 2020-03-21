package com.j2core.sts.leetcode.com.string.repeatedDNASequences;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> setDNA = new HashSet<>();
        Set<String> doubleDNA = new HashSet<>();
        int indexS = 0;
        int indexF = 10;

        while (indexF <= s.length()){
            String tmp = s.substring(indexS++, indexF++);
            if (setDNA.contains(tmp)){
                doubleDNA.add(tmp);
            }else {
                setDNA.add(tmp);
            }

        }
        return new LinkedList<>(doubleDNA);
    }
}
