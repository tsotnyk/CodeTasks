package com.j2core.sts.leetcode.com.MinStack;

public class MinStack {

    int stackSize = 512;
    private int [] stack = new int[stackSize];
    private int minElement;
    private int index = 0;

    public MinStack() {
    }

    public void push(int x) {

        if (index == 0){
            minElement = x;
        }
        if (index == stackSize){
            stackSize = stackSize * 2;
            int[] newStack = new int[stackSize];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[index] = x;
        index++;
        if (minElement > x){
            minElement = x;
        }
    }

    public void pop() {
        index--;
        if (stack[index] == minElement){
            int tmp = stack[0];
            for (int i = 1; i < index; i++){
                int num = stack[i];
                if (tmp > num){
                    tmp = num;
                }
            }
            minElement = tmp;
        }
    }

    public int top() {
        return stack[index-1];
    }

    public int getMin() {

        return this.minElement;
    }
}
