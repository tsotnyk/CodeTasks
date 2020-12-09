package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter3;

import org.testng.annotations.Test;

import java.util.Stack;

public class Solution3_5 {

    public void sortStack(Stack<Integer> stack){

        if (stack != null && !stack.isEmpty()){

            Stack<Integer> tmpStack = new Stack<>();
            while (!stack.isEmpty()){
                int element = stack.pop();
                if (!tmpStack.isEmpty() && tmpStack.peek() > element) {
                    while (!tmpStack.isEmpty() && tmpStack.peek() > element) {
                        stack.push(tmpStack.pop());
                    }
                }
                tmpStack.push(element);
            }
            while (!tmpStack.isEmpty()){
                stack.push(tmpStack.pop());
            }
        }

    }

    @Test
    public void test(){

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(4);
        stack1.push(9);
        stack1.push(3);
        sortStack(stack1);

        while (!stack1.isEmpty()){
            System.out.println(stack1.pop());
        }
        System.out.println("  expected  == >  3,4,9");

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(3);
        stack2.push(5);
        stack2.push(6);
        stack2.push(0);
        sortStack(stack2);

        while (!stack2.isEmpty()){
            System.out.println(stack2.pop());
        }
        System.out.println("  expected  == >  0,1,2,3,3,4,5,6");

    }
}
