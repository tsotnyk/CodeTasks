package com.j2core.sts.leetcode.com.countItemsMatchingRule;

import java.util.List;

public class Solution {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int counter = 0;
        int index;
        switch (ruleKey){
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            default:
                index = 2;
        }

        for (List<String> list : items){
            if (list.get(index).equals(ruleValue)) counter++;
        }

        return counter;
    }
}
