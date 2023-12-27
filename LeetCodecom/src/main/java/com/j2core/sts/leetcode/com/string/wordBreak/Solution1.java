package com.j2core.sts.leetcode.com.string.wordBreak;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution1 {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();

        for (String word : wordDict){
            set.add(word);
        }

        HashMap<String, Boolean> memo = new HashMap<>();
        memo.put("", true);

        return isWords(s, set, memo);

    }

    private boolean isWords(String str, HashSet<String> set, HashMap<String, Boolean> memo){

        if (memo.containsKey(str)) return memo.get(str);

        for (int i = 1; i <= str.length(); i++){
            if (set.contains(str.substring(0, i))){
                if (isWords(str.substring(i), set, memo)){
                    memo.put(str, true);
                    return true;
                }
            }
        }

        memo.put(str, false);
        return false;
    }

    @Test
    public void test(){

        Assert.assertTrue(wordBreak("leetcode", new LinkedList<>(Arrays.asList("leet", "code"))));
        Assert.assertTrue(wordBreak("applepenapple", new LinkedList<>(Arrays.asList("apple", "pen"))));
        Assert.assertFalse(wordBreak("catsandog", new LinkedList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
    }
}
