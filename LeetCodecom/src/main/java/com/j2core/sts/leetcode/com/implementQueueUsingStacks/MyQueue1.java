package com.j2core.sts.leetcode.com.implementQueueUsingStacks;

import java.util.Stack;

public class MyQueue1 {

    private Stack<Integer> stackRevers;
    private Stack<Integer> stackQueue;

    /** Initialize your data structure here. */
    public MyQueue1() {
        this.stackRevers = new Stack<>();
        this.stackQueue = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        this.stackRevers.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackQueue.isEmpty()){
            moveValues();
        }
        return stackQueue.pop();

    }

    private void moveValues(){
        Stack<Integer> tmpStack = new Stack<>();
        while (!this.stackRevers.isEmpty()){
            tmpStack.push(this.stackRevers.pop());
        }
        while (!this.stackQueue.isEmpty()){
            tmpStack.push(this.stackQueue.pop());
        }
        this.stackQueue = tmpStack;
    }

    /** Get the front element. */
    public int peek() {
        if (stackQueue.isEmpty()){
            moveValues();
        }
        return stackQueue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stackRevers.isEmpty() && this.stackQueue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

