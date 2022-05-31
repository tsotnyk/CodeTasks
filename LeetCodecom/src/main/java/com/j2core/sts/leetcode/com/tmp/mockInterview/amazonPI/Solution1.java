package com.j2core.sts.leetcode.com.tmp.mockInterview.amazonPI;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution1 {

    public String removeVowels(String s) {

        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));

        StringBuilder builder = new StringBuilder();

        for (char symbol : s.toCharArray()){
            if (!vowels.contains(symbol)){
                builder.append(symbol);
            }
        }
        return builder.toString();
    }
}

abstract class Node {

    public ArrayList<String> values;

    public Node(String[] values){
        this.values = new ArrayList<>(Arrays.asList(values));
    }
    public abstract int evaluate();
    // define your fields here
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {

        Node node = new Node(postfix) {
            @Override
            public int evaluate() {

                if (this.values.size() == 1) return Integer.parseInt(this.values.get(0));
                int index = 0;

                while (index < this.values.size()){
                    switch (this.values.get(index)){
                        case "+":
                        case "-":
                        case "*":
                        case "/":
                            if (index < 2){
                                index++;
                                continue;
                            }
                            action(values, index);

                            break;
                        default: index++;
                    }
                }

                return evaluate();
            }
        };

        return node;
    }

    private void action(ArrayList<String> values, int index){

        int first = Integer.parseInt(values.get(index-2));
        int second = Integer.parseInt(values.get(index-1));
        int sum;
        switch (values.get(index)){
            case "+":
                sum = first+second;
                break;
            case "-":
                sum = first-second;
                break;
            case "*":
                sum = first*second;
                break;
            default:
                sum = (int)first/second;
        }

        values.set(index-2, String.valueOf(sum));
        values.remove(index);
        values.remove(index-1);
    }

}

class Starter{
    public static void main(String[] args) {

        TreeBuilder builder = new TreeBuilder();

        Node node = builder.buildTree(new String[]{"4","5","7","2","+","-","*"});

        int result = node.evaluate();

        System.out.println(result);

    }
}
