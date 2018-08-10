package com.j2core.sts.leetcode.com.fizzBuzz;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> fizzBuzz(int n) {

        List<String> result = new LinkedList<>();
        String treeString = "Fizz";
        String fiveString = "Buzz";

        int num = 1;

        while (num <= n){

            int multiplesTree = num % 3;
            int multiplesFive = num % 5;
            if (multiplesFive == 0 && multiplesTree == 0){
                result.add(treeString+fiveString);
            }else if (multiplesFive == 0){
                result.add(fiveString);
            }else if (multiplesTree == 0){
                result.add(treeString);
            }else {
                result.add(String.valueOf(num));
            }

            num++;
        }

        return result;

    }
}
