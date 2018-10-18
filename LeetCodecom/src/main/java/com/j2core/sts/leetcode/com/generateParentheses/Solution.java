package com.j2core.sts.leetcode.com.generateParentheses;

import java.util.*;

public class Solution {

    public List<String> generateParenthesis(int n) {

        if (n == 0) return new LinkedList<>();
        if (n == 1) {

            List<String> result = new LinkedList<>();
            result.add("()");
            return result;

        } else {
            Set<String> tmpResult = new HashSet<>();
            tmpResult.add("()");

            int i = 1;
            while (i < n){

                Set<String> tmpSet = new HashSet<>();

                for( String builder : tmpResult){

                    tmpSet.addAll(createNewString(builder));

                }

                tmpResult = tmpSet;
                i++;
            }

            return createStringList(tmpResult);
        }
    }

    private Set<String> createNewString(String string) {

        int length = string.length();
        String add = "()";
        Set<String> set = new HashSet<>();

        for (int i = 0; i <= length; i++){

            StringBuilder builder = new StringBuilder();
            if (i == 0){

                builder.append(add);
                builder.append(string);

            }else if (i == length){

                builder.append(string);
                builder.append(add);
            }else {

                builder.append(string.substring(0, i));
                builder.append(add);
                builder.append(string.substring(i));
            }

            set.add(builder.toString());
        }

        return set;

    }

    private List<String> createStringList(Set<String> builders){

        List<String> result = new LinkedList<>();

        result.addAll(builders);

        return result;
    }
}
