package com.j2core.sts.leetcode.com.tmp.visa;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public static int getMin(String s) {
        // Write your code here
        int counter = 0;
        Stack<Character> stack = new Stack<>();

        for (char symbol : s.toCharArray()){
            if (symbol == '('){
                stack.push('(');
            }else {
                if (stack.isEmpty()){
                    counter++;
                }else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()){
            stack.pop();
            counter++;
        }
        return counter;
    }

    @Test
    public static void test1(){

        Assert.assertEquals(getMin("()))))))))))))))))))))))()()))()))))))))()))))))()))()))))(()))))))))))))()))))))(()))))))))()()))))))))))))()))))(())()))))))(()))))()))))))()))()())))())))))))))))()))())(()()())()()())))))()))))())()))()))))))))))))))()())))()))))()))))))()))())()))())))(()))()))))))))())))())))(())()))))()((()))))))((((()())())())(())))))())())))))))())))))()(()))))()))))())))))()())())()))()))))))))()))))))))))()))))())))))(((()))))()))((())))())))))))())))()()())())))))())))())())))))(())())))))))())))()()))))))))))))(())())())))((()))))))(())))()())))()))))(())))(())))))))))))))(())))(())()))))(()))())())))))))()())(()(())())))))))))))))))))))))))((()())))())))())))((()())))()))())()))))())()())))))))))))(()))))))))))))))()))))))()))))))))))))))))(()(()))(()))()))))))()))()()))))))))))()))())()))))())))()()()))()))))(())))))))))))))()()))))(())))()))))))()))()())()))())()())())))()()(()())))))()())))))))())))())))(())))())))))))()))))))))()((()(())))))))))(())))())))())))))))))()())))()))))))))("), 564);
    }

    public static String maxSubstring(String s) {
        // Write your code here
        TreeSet<String> subStringList = new TreeSet<>();
        for (int i = 0; i < s.length(); i++){

            for (int j = i+1; j <= s.length(); j++){
                subStringList.add(s.substring(i, j));
            }
        }

        return subStringList.last();
    }

    @Test
    public void test2(){

        Assert.assertEquals(maxSubstring("banana"), "nana");
        Assert.assertEquals(maxSubstring("aaa"), "aaa");
        Assert.assertEquals(maxSubstring("ba"), "ba");
        Assert.assertEquals(maxSubstring("baca"), "ca");

    }

    public static int minSum(List<Integer> num, int k) {
        // Write your code here

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;

        for(int n : num) {
            maxHeap.add(n);
            sum += n;
        }

        while(k-- > 0) {
            int number = maxHeap.poll();
            sum -= number;
            number = number%2 == 0 ? number/2 : (number/2)+1;
            sum += number;
            maxHeap.add(number);
        }

        return sum;
    }

    @Test
    public void test3(){

        List<Integer> list = new LinkedList<>(Arrays.asList(10, 20, 7));
        Assert.assertEquals(minSum(list, 4), 14);
        List<Integer> list1 = new LinkedList<>(Arrays.asList(2));
        Assert.assertEquals(minSum(list1, 1), 1);
        List<Integer> list2 = new LinkedList<>(Arrays.asList(2,3));
        Assert.assertEquals(minSum(list2, 1), 4);
    }

}
