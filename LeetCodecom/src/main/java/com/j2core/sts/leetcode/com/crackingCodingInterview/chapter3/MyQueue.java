package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter3;

import org.testng.annotations.Test;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> baseStack;
    Stack<Integer> reversStack;
    int size;

    public MyQueue() {
        this.baseStack = new Stack<>();
        this.reversStack = new Stack<>();
        this.size = 0;
    }

    public boolean add(Integer num) {
        this.baseStack.push(num);
        this.size++;
        return true;
    }

    public Integer remove() {
        if (reversStack.isEmpty()){
            if (baseStack.isEmpty()){
                return null;
            }else {
                while (!baseStack.isEmpty()){
                    reversStack.push(baseStack.pop());
                }
            }
        }
        size--;
        return reversStack.pop();
    }

    public Integer poll() {
        if (reversStack.isEmpty()){
            if (baseStack.isEmpty()){
                return null;
            }else {
                while (!baseStack.isEmpty()){
                    reversStack.push(baseStack.pop());
                }
            }
        }
        size--;
        return reversStack.pop();
    }

    public Integer element() {
        if (reversStack.isEmpty()){
            if (baseStack.isEmpty()){
                return null;
            }else {
                while (!baseStack.isEmpty()){
                    reversStack.push(baseStack.pop());
                }
            }
        }
        return reversStack.peek();
    }

    public Integer peek() {
        if (reversStack.isEmpty()){
            if (baseStack.isEmpty()){
                return null;
            }else {
                while (!baseStack.isEmpty()){
                    reversStack.push(baseStack.pop());
                }
            }
        }
        return reversStack.peek();
    }

    public int size(){
        return this.size;
    }

    public boolean offer(int num){
        boolean elemContain = false;

        if (!reversStack.isEmpty()){
            Stack<Integer> tmpStack = new Stack<>();
            while (!reversStack.isEmpty()){
                tmpStack.push(reversStack.pop());
            }
            while (!tmpStack.isEmpty()){
                int elem = tmpStack.pop();
                if (elem == num){
                    elemContain = true;
                }
                reversStack.push(elem);
            }
        }
        if (!elemContain){
            while (!baseStack.isEmpty()){
                int elem = baseStack.pop();
                if (elem == num){
                    elemContain = true;
                }
                reversStack.push(elem);
            }
        }

        return elemContain;
    }

    public boolean isEmpty(){

        return baseStack.isEmpty() && reversStack.isEmpty();
    }

    @Test
    public void test(){

        MyQueue queue = new MyQueue();
        System.out.println("is empty => " + queue.isEmpty() + " // expected true");
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(6);
        queue.add(10);
        System.out.println("Queue contains : 1,2,3,4,6,10");
        System.out.println("is empty => " + queue.isEmpty() + " // expected false");
        System.out.println("is contain 5 => " + queue.offer(5) + " // expected false");
        System.out.println("is contain 6 => " + queue.offer(6) + " // expected true");
        System.out.println("head is => " + queue.peek() + "  // expected 1");
        System.out.println("head is => " + queue.element() + "  // expected 1");
        System.out.println("remove head => " + queue.remove() + "  // expected 1");
        System.out.println("next head is => " + queue.peek() + "  // expected 2");
        System.out.println("poll head => " + queue.poll() + "  // expected 2");
        System.out.println("next head is => " + queue.peek() + "  // expected 3");
    }
}
