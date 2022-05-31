package com.j2core.sts.leetcode.com.evaluateBracketPairsOfString;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> map = new HashMap<>();

        for (List<String> list : knowledge){
            map.put(list.get(0), list.get(1));
        }

        StringBuilder builder = new StringBuilder();

        int index = 0;

        while (index < s.length()){
            if (s.charAt(index) == '('){
                int indexE = s.indexOf(')', index);
                String key = s.substring(index+1, indexE);
                builder.append(map.getOrDefault(key, "?"));
                index = indexE;
            }else {
                builder.append(s.charAt(index));
            }
            index++;
        }

        return builder.toString();
    }

    @Test
    public void test(){

        List<List<String>> list = new LinkedList<>();
        list.add(Arrays.asList("name","bob"));
        list.add(Arrays.asList("age","two"));
        Assert.assertEquals(evaluate("(name)is(age)yearsold", list), "bobistwoyearsold");
    }
}
