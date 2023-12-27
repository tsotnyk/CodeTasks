package com.j2core.sts.leetcode.com.regularExpressionMatching;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Objects;

public class Solution1 {

    class Pair{

        int strI;
        int patI;

        public Pair(int str, int pat) {
            this.strI = str;
            this.patI = pat;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return strI == pair.strI && patI == pair.patI;
        }

        @Override
        public int hashCode() {
            return Objects.hash(strI, patI);
        }
    }

    public boolean isMatch(String s, String p) {

        HashMap<Pair, Boolean> resMap = new HashMap<>();
        resMap.put(new Pair(s.length(), p.length()), true);
        return isMatchPart(s, p, 0, 0, resMap);

    }

    private boolean isMatchPart(String s, String p, int sI, int pI, HashMap<Pair, Boolean> resMap){

        Pair pair = new Pair(sI, pI);

        if (resMap.containsKey(pair)) return resMap.get(pair);

        while (sI < s.length() && pI < p.length()){
            char sym = p.charAt(pI++);
            switch (sym){
                case '.':
                    sI++;
                    break;
                case '*':
                    int indexS = 0;
                    while (sI+indexS <= s.length()){
                        if (isMatchPart(s,p, indexS+sI, pI, resMap)){
                            sI += indexS;
                            break;
                        }else indexS++;
                    }
                    break;
                default:
                    if (s.charAt(sI) != sym){
                        resMap.put(pair, false);
                        return false;
                    }
                    sI++;
            }
        }

        return sI == s.length() && pI == p.length();
    }

    @Test
    public void test(){

        Assert.assertFalse(isMatch("aa", "a"));
        Assert.assertTrue(isMatch("aa", "a*"));
        Assert.assertTrue(isMatch("ab", ".*"));
    }
}
