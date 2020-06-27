package com.j2core.sts.leetcode.com.graphs.similarStringGroups;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int numSimilarGroups(String[] A) {

        int group = 1;
        HashMap<Integer, ArrayList<String>> groupMap = new HashMap<>();

        for (String  word : A){

            boolean newGroup = findGroupForWord(word, groupMap, group-1);
            if (newGroup){

                groupMap.put(group++, new ArrayList<>(Arrays.asList(word)));
            }
        }

        return group-1;
    }

    private boolean findGroupForWord(String word, HashMap<Integer, ArrayList<String>> groupMap, int group) {

        if (groupMap.isEmpty()) return true;
        while (group > 0){
            ArrayList<String> list = groupMap.get(group);
            for (String addedWord : list){
                if (wordSimilar(word, addedWord)){
                    list.add(word);
                    return false;
                }
            }
            group--;
        }
        return true;
    }

    private boolean wordSimilar(String newWord, String oldWord) {
        int diffLetters = 0;

        for (int i = 0; i < newWord.length(); i++){
            if (newWord.charAt(i) != oldWord.charAt(i)){
                diffLetters++;
                if (diffLetters > 2) return false;
            }
        }
        return true;
    }

    @Test
    public void test(){

//        Assert.assertEquals(numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}), 2);
        Assert.assertEquals(numSimilarGroups(new String[]{"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"}), 5);


    }
}
