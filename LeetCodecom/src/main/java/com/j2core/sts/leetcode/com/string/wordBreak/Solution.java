package com.j2core.sts.leetcode.com.string.wordBreak;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    @Test
    public void test(){

        Assert.assertTrue(wordBreak("aaaaaaa", new LinkedList<String>(Arrays.asList("aaaa", "aaa"))));

        Assert.assertTrue(wordBreak("leetcode", new LinkedList<String>(Arrays.asList("leet", "code"))));
        Assert.assertTrue(wordBreak("applepenapple", new LinkedList<String>(Arrays.asList("sts.apple", "pen"))));

    }

}
