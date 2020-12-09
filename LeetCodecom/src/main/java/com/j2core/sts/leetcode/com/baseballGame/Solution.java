package com.j2core.sts.leetcode.com.baseballGame;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class Solution {

    public int calPoints(String[] ops) {

        if (ops == null || ops.length == 0) return 0;
        int scope = 0;
        LinkedList<Integer> lastScope = new LinkedList<>();

        for (String action : ops){
            int curScope;
            switch (action){

                case "+":
                    curScope = lastScope.getLast() + lastScope.get(lastScope.size()-2);
                    scope += curScope;
                    lastScope.add(curScope);
                    break;
                case "D":
                    curScope = 2*lastScope.getLast();
                    scope += curScope;
                    lastScope.add(curScope);
                    break;
                case "C":
                    scope -= lastScope.removeLast();
                    break;
                default:
                    boolean negative = action.charAt(0) == '-';
                    if (negative){
                        curScope = Integer.parseInt(action.substring(1)) * -1;
                    }else {
                        curScope = Integer.parseInt(action);
                    }
                    scope += curScope;
                    lastScope.add(curScope);
            }
        }

        return scope;
    }

    @Test
    public void test(){

        Assert.assertEquals(calPoints(new String[]{"5","2","C","D","+"}), 30);
        Assert.assertEquals(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}), 27);
        Assert.assertEquals(calPoints(new String[]{"1"}), 1);

    }
}
