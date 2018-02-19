package com.j2core.sts.leetcode.com.MinStack;

/*
   The class is easy implementation mini stack
 */
public class MinStack {

    int stackSize = 512;                            // stack's size
    private int [] stack = new int[stackSize];      // array for save numbers
    private int minElement;                         // min element in stack
    private int index = 0;                          // index for first free position in stack

    public MinStack() {
    }

    /**
     * The method push element onto stack
     *
     * @param x     element for save onto stack
     */
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

    /**
     *  The method removes the element on top of the stack
     */
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

    /**
     * The method get the top element
     *
     * @return   top element from stack
     */
    public int top() {
        return stack[index-1];
    }

    /**
     * The method retrieve the minimum element in the stack
     *
     * @return     min element from stack
     */
    public int getMin() {

        return this.minElement;
    }
}
