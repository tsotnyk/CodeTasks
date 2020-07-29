package com.j2core.sts.leetcode.com.removeInvalidParentheses;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public List<String> removeInvalidParentheses(String s) {

        if (s.length() == 0){
            return new LinkedList<>(Collections.singletonList(""));
        }

        int indexStart = s.indexOf('(');
        int indexEnd = s.lastIndexOf(')');

        if (indexStart < 0 && indexEnd < 0) {
            return new LinkedList<>(Collections.singleton(s));
        }

        if (validateString(s.toCharArray())) return new LinkedList<>(Collections.singletonList(s));

        List<char[]> list = new LinkedList<>(Collections.singletonList(s.toCharArray()));

        List<char[]> result = new LinkedList<>();

        while (result.isEmpty()){
            list = createPotentiallyString(list);
            for (char[] array : list){
                if (validateString(array)){
                   result.add(array);
                }
            }
        }

        return createStringList(result);
    }

    private List<String> createStringList(List<char[]> list) {

        Set<String> result = new HashSet<>();
        StringBuilder builder;

        for (char[] array : list){
            builder = new StringBuilder();
            for (char symbol : array){
                if (symbol != ' '){
                    builder.append(symbol);
                }
            }
            result.add(builder.toString());
        }

        return new LinkedList<>(result);
    }

    private List<char[]> createPotentiallyString(List<char[]> stringList){

        List<char[]> list = new LinkedList<>();

        for (char[] array : stringList) {
            for (int i = 0; i < array.length; i++){
                if (array[i] == '(' || array[i] == ')') {
                    char[] newArray = Arrays.copyOf(array, array.length);
                    newArray[i] = ' ';
                    list.add(newArray);
                }
            }
        }
        return list;
    }

    private boolean validateString(char[] string){

        Stack<Character> stack = new Stack<>();

        for (char symbol : string){

            if (symbol == '('){
                stack.push(symbol);
            }else if (symbol == ')'){
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void test(){

        List<String> result1 = removeInvalidParentheses("()())()");
        Assert.assertEquals(result1.size(), 2);

        List<String> result2 = removeInvalidParentheses("(a)())()");
        Assert.assertEquals(result2.size(), 2);

        List<String> result3 = removeInvalidParentheses(")(");
        Assert.assertEquals(result3.size(), 1);

        List<String> result4 = removeInvalidParentheses("n");
        Assert.assertEquals(result4.size(), 1);

        List<String> result5 = removeInvalidParentheses("n(");
        Assert.assertEquals(result5.size(), 1);

        List<String> result6 = removeInvalidParentheses("((");
        Assert.assertEquals(result6.size(), 1);

        List<String> result7 = removeInvalidParentheses(")(f");
        Assert.assertEquals(result7.size(), 1);
    }

}
