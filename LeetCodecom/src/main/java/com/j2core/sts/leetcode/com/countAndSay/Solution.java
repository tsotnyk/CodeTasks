package com.j2core.sts.leetcode.com.countAndSay;

public class Solution {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        return analyze(countAndSay(n - 1));
    }

    private String analyze(String input) {
        StringBuilder builder = new StringBuilder();

        int counter = 1;
        char character = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            char nextChar = input.charAt(i);
            if (nextChar != character) {
                builder.append(counter).append(character);
                character = nextChar;
                counter = 1;
            } else {
                counter++;
            }
        }

        builder.append(counter).append(character);

        return builder.toString();
    }
}
