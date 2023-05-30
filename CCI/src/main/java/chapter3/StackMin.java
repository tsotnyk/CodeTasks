package chapter3;

import java.util.Stack;

public class StackMin extends Stack<Integer>{

    Stack<Integer> minStack = new Stack<>();

    public StackMin() {
    }

    public void push(int value){

        if (value <= this.minStack.peek()){
            minStack.push(value);
        }
        super.push(value);

    }

    public Integer pop(){

        Integer value = super.pop();

        if (this.minStack.peek().equals(value)){
            this.minStack.pop();
        }
        return value;
    }

    public Integer min(){
        return this.minStack.peek();
    }

}
