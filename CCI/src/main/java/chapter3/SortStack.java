package chapter3;

import org.testng.annotations.Test;

import java.util.Stack;

public class SortStack {

    public Stack<Integer> sortStack(Stack<Integer> input){

        Stack<Integer> helper = new Stack<>();

        while (!input.isEmpty()){
            Integer value = input.pop();
            if (helper.isEmpty()){
                helper.push(value);
            }else {
                if (helper.peek() < value){
                    helper.push(value);
                }else{
                    input.push(helper.pop());
                    input.push(value);
                }
            }
        }

        while (!helper.isEmpty()){
            input.push(helper.pop());
        }

        return input;
    }

    @Test
    public void test(){

        Stack<Integer> input = new Stack<>();
        input.push(1);
        input.push(5);
        input.push(0);
        input.push(12);
        input.push(2);
        input.push(7);
        input.push(4);
        input.push(8);
        input.push(3);

        Stack<Integer> output = sortStack(input);

        while (!output.isEmpty()){
            System.out.println(output.pop());
        }
    }
}
