package com.j2core.sts.leetcode.com.string.jewelsAndStones;

import java.util.HashSet;

public class Solution {

    public int numJewelsInStonesOld(String J, String S) {

        if (J.length() < 1 || S.length() < 1) return 0;

        int result = 0;

        for (int i = 0; i < J.length(); i++){

            char jewel = J.charAt(i);

            for (int j = 0; j < S.length(); j++){

                if (S.charAt(j) == jewel){

                    result++;

                }
            }
        }

        return result;

    }

    public int numJewelsInStones1(String J, String S) {

        HashSet<Character> uniqJewel = new HashSet<>();

        for (int i = 0; i < J.length(); i++){
            uniqJewel.add(J.charAt(i));
        }

        int counter = 0;

        for (int i = 0; i < S.length(); i++){
            if (uniqJewel.contains(S.charAt(i))){
                counter++;
            }
        }
        return counter;
    }

    public int numJewelsInStones(String J, String S) {
        if (J.length() < 1 || S.length() < 1) return 0;

        int result = 0;

        for (int i = 0; i < S.length(); i++){

            char stone = S.charAt(i);

            for (int j = 0; j < J.length(); j++){

                if (J.charAt(j) == stone){

                    result++;

                }
            }
        }

        return result;
    }
}
