package com.j2core.sts.leetcode.com.tmp.mockInterview.googleOA;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Solution1 {

    public int numUniqueEmails(String[] emails) {

        HashSet<String> uniqName = new HashSet<>();

        for (String email : emails){
            StringBuilder builder = new StringBuilder();
            boolean place = false;
            for (int i = 0; i < email.length(); i++){
                char symbol = email.charAt(i);
                if (symbol == '@'){
                    builder.append(email.substring(i));
                    break;
                }
                if (symbol == '+'){
                    place = true;
                }
                if (symbol != '.' && !place) builder.append(symbol);
            }
            uniqName.add(builder.toString());
        }

        return uniqName.size();
    }

    @Test
    public void test1(){

        Assert.assertEquals(2, numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }

    public int totalFruit(int[] tree) {

        if (tree.length < 3) return tree.length;
        HashMap<Integer, Integer> uniqTree = new HashMap<>();
        int start = 0;
        int current = 0;
        int amountFruits = 2;

        while (current < tree.length){
            int nextTree = tree[current];
            if (uniqTree.size() < 2){
                uniqTree.put(nextTree, uniqTree.getOrDefault(nextTree, 0)+1);
                current++;
            }else {
                if (uniqTree.containsKey(nextTree)){
                    uniqTree.put(nextTree, uniqTree.get(nextTree)+1);
                    current++;
                }else {
                    amountFruits = Math.max(current-start, amountFruits);
                    int sum = uniqTree.get(tree[start]);
                    if (sum == 1){
                        uniqTree.remove(tree[start]);
                    }else {
                        uniqTree.put(tree[start], sum-1);
                    }
                    start++;
                }
            }
        }

        return Math.max(amountFruits, current-start);
    }

    @Test
    public void test2(){

        Assert.assertEquals(5, totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
