package com.j2core.sts.leetcode.com.basicCalculatorII;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public int calculate(String s) {

        s = s.replaceAll(" ", "");

        List<Integer> numList = new LinkedList<>();
        List<Character> actionList = new LinkedList<>();

        parsString(numList, actionList, s);

        return calculateAction(numList, actionList);
    }

    private int calculateAction(List<Integer> numList, List<Character> actionList){

        Iterator<Character> iterator = actionList.iterator();
        int first;
        int second;
        int sum;

        while (!actionList.isEmpty()) {
            int index = 0;
            while (iterator.hasNext()) {
                char action = iterator.next();
                if (action =='/' || action =='*'){
                    first = numList.get(index);
                    second = numList.remove(index+1);
                    if (action == '/'){
                        sum = first/second;
                    }else {
                        sum = first*second;
                    }
                    iterator.remove();
                    numList.set(index, sum);
                    index--;

                }
                index++;
            }
            index = 0;
            iterator = actionList.iterator();
            while (iterator.hasNext()){
                char action = iterator.next();
                first = numList.get(index);
                second = numList.remove(index+1);
                if(action == '+'){
                    sum = first + second;
                }else {
                    sum = first - second;
                }
                iterator.remove();
                numList.set(index, sum);
            }
        }
        return numList.get(0);

    }

    private void parsString(List<Integer> numList, List<Character> actionList, String string){

        int index = 0;
        int tmpIndex = index;

        while (tmpIndex < string.length()){

            char tmp = string.charAt(tmpIndex);
            if (Character.isDigit(tmp)){
                tmpIndex++;
            }else {
                actionList.add(tmp);
                numList.add(Integer.parseInt(string.substring(index, tmpIndex)));
                index = ++tmpIndex;
            }
        }
        numList.add(Integer.parseInt(string.substring(index)));
    }




    @Test
    public void test(){

//        int result = calculate("2*3*4");
        int result = calculate("3+2*2");

        Assert.assertEquals(result, 7);

    }
}
