package com.j2core.sts.leetcode.com.implementQueueUsingStacks;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {

        this.input = new Stack<>();
        this.output = new Stack<>();
    }

    public void push(int x) {

        this.input.push(x);
    }

    public int pop() {
        if (this.output.isEmpty()){
            swapData();
        }

        return this.output.pop();
    }

    public int peek() {

        if (this.output.isEmpty()){
            swapData();
        }

        return this.output.peek();
    }

    private void swapData(){

        while (!this.input.isEmpty()){
            this.output.push(this.input.pop());
        }
    }

    public boolean empty() {

        return this.input.isEmpty() && this.output.isEmpty();
    }
}
