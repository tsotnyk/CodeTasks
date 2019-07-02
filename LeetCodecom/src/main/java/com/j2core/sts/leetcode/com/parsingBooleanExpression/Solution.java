package com.j2core.sts.leetcode.com.parsingBooleanExpression;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public  boolean parseBoolExpr(String expression) {

        List<Integer> indexes = new LinkedList<>();

        for (int i = expression.length()-2; i > 0; i--){
            if (expression.charAt(i) == '('){
                indexes.add(i-1);
            }
        }

        do {
            int firstIndex = indexes.remove(0);
            int lastIndex = expression.indexOf(')', firstIndex+1);

            String tmpResult = helper(expression.substring(firstIndex, lastIndex));
            if (tmpResult != null){
                expression = expression.substring(0, firstIndex) + tmpResult + expression.substring(lastIndex+1);
            }else {
                expression = null;
                break;
            }

        }while (!indexes.isEmpty());

        if (expression != null){
            return expression.charAt(0) == 't';
        }else return false;
    }

    private  String helper(String expression){

        int t = 0;
        int f = 0;

        for (int i = 2; i < expression.length(); i++){

            if (expression.charAt(i) == 't'){
                t++;
            }
            if (expression.charAt(i) == 'f'){
                f++;
            }
        }

        String result = null;
        switch (expression.charAt(0)){
            case '!':
                if (t+f == 1){
                    if (t != 0){
                        result = "f";
                    }else {
                        result = "t";
                    }
                }
                break;
            case '&':
                if (t != 0 && f == 0){
                    result = "t";
                }else if (f != 0 && t == 0){
                    result = "f";
                }else {
                    result = "f";
                }
                break;
            case '|':
                if (t != 0 && f != 0){
                    result = "t";
                }else if (t != 0){
                    result = "t";
                }else {
                    result = "f";
                }
                break;
        }
        return result;
    }

}
