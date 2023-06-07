package chapter3;

import org.testng.annotations.Test;

import java.util.Stack;

public class QueueViaStack {

    Stack<Integer> input;
    Stack<Integer> output;

    public QueueViaStack() {
        this.input = new Stack<>();
        this.output = new Stack<>();
    }

    public boolean push(int value){

        this.input.add(value);
        return  true;
    }

    public Integer peek(){

        if (this.output.isEmpty()){
            rePullValue();
        }

        return this.output.peek();
    }

    public Integer pop(){

        if (this.output.isEmpty()){
            rePullValue();
        }
        return this.output.pop();
    }

    private void rePullValue(){

        while (!this.input.isEmpty()){
            this.output.push(this.input.pop());
        }
    }

    @Test
    public void test(){

        QueueViaStack meTest = new QueueViaStack();

        meTest.push(1);
        meTest.push(2);
        meTest.push(3);
        System.out.println(meTest.peek());
        System.out.println(meTest.pop());
        meTest.push(4);
        meTest.push(5);
        System.out.println(meTest.pop());
        System.out.println(meTest.pop());
        System.out.println(meTest.pop());
        System.out.println(meTest.pop());

    }
}
