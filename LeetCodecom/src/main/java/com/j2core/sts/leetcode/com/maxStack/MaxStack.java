package com.j2core.sts.leetcode.com.maxStack;

import org.testng.annotations.Test;

import java.util.*;

public class MaxStack {

    Stack<Integer> stack;
    HashMap<Integer, Integer> map;
    TreeSet<Integer> tree;

    /** initialize your data structure here. */
    public MaxStack() {

        this.stack = new Stack<>();
        this.map = new HashMap<>();
        this.tree = new TreeSet<>();

    }

    // O(logN)
    public void push(int x) {

        this.stack.add(x);
        int count = this.map.getOrDefault(x, 0);
        if(count == 0){
            this.tree.add(x);
        }
        this.map.put(x, count+1);
    }

    // O(logN)
    public int pop() {

        int num = this.stack.pop();
        int count = this.map.get(num);
        if(count == 1){
            this.tree.remove(num);
        }
        this.map.put(num, count-1);
        return num;

    }

    // O(1)
    public int top() {

        return this.stack.peek();

    }

    // O(1)
    public int peekMax() {

        return this.tree.last();
    }

    // O(n)
    public int popMax() {

        int maxNum = this.tree.last();
        Stack<Integer> list = new Stack<>();
        int num = this.stack.pop();
        while (num != maxNum){
            list.push(num);
            num = this.stack.pop();
        }
        while (!list.empty()){
            this.stack.push(list.pop());
        }
        int count = this.map.get(maxNum);
        this.map.put(maxNum, count-1);
        if(count < 2){
            return this.tree.pollLast();
        }else return this.tree.last();

    }

    @Test
    public void test(){

        MaxStack myStack = new MaxStack();
        myStack.push(5);
        myStack.push(1);
        myStack.push(5);
        System.out.println(myStack.top());
        System.out.println(myStack.popMax());
        System.out.println(myStack.top());
        System.out.println(myStack.peekMax());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
    }
//
//    public class HelloWorld {
//
//        public static void main(String[] args){
//            //Prints "Hello, World" to the terminal
//            System.out.println("Hello, World");
//
//            System.out.print("Hi");
//        }
//
//
//
//// Input: “[()]{}{[()()]()}”
//// Output: true
//// Input: “[(])”
//// Output: false
//
//        // "  {}()" %2 == 0
//        public boolean matched(String s) {
//            // Implementation here
//
//            if( s == null || s.length() == 1) return false;
//            if(s.length() == 0) return true;
//
//            char[] array = s.toCharArray();
//
//            int index = isEmptyPart(array, 0, s.length()-1);
//
//            while(index > -1){
//
//                char firstBrack;
//                if(array[index] == '(') firstBrack = ')';
//                if(array[index] == '[') firstBrack = ']';
//                if(array[index] == '{') firstBrack = '}';
//
//                int indexEnd = indexOfArray(array, index, array.length-1, firstBrack);
//                if(!isCorrectPair(array, index, indexEnd)) return false;
//
//                int indexStart = isEmptyPart(array, 0, s.length()-1);
//            }
//
//            return true;
//        }
//
//
//
//        private boolean isCorrectPair(char[] array, int start, int end){
//
//            // todo find similar brackets
//            if((array[start] == '(' && array[end] != ')' )|| (array[start] == '[' && array[end] != ']' ) || (array[start] == '{' && array[end] != '}' )){
//                char firstBrack;
//                if(array[start] == '(') firstBrack = ')';
//                if(array[start] == '[') firstBrack = ']';
//                if(array[start] == '{') firstBrack = '}';
//                char secondBrack;
//                if(array[start] == '(') secondBrack = ')';
//                if(array[start] == '[') secondBrack = ']';
//                if(array[start] == '{') secondBrack = '}';
//
//                int index = indexOfArray(array, start, end-1, firstBrack);
//
//                if(index < 0) return false;
//
//                if(!isCorrectPair(array, start, index)) return false;
//
//                index = indexOfArray(array, start+1, end-1, secondBrack);
//
//                if (index < 0) return false;
//
//                start = index;
//            }
//
//            if((end-start) %2 != 0) return false;
//
//            if(isEmptyPart(array, start+1, end-1) == -1){
//                array[end] = ' ';
//                array[start] = ' ';
//                return true;
//            }else{
//                return isCorrectPair(array, start+1, end-1);
//            }
//        }
//
//        private int indexOfArray(char[] array, int start, int end, char bracket){
//
//            for(int i = start; i <= end; i++){
//                if(array[i] == bracket) return i;
//            }
//
//            return -1;
//        }
//
//        private int isEmptyPart(char[] array, int start, int end){
//
//            for(int i = start+1; i < end; i++){
//                if(array[i] != ' ') return i;
//
//            }
//
//            return -1;
//        }
//
//    }
//
//    // Input: “[()]{}{[()()]()}”
//// Output: true
//// Input: “[(])”
//// Output: false
//
//    // "  {}()" %2 == 0
//    public boolean matched(String s) {
//        // Implementation here
//
//        if( s == null || s.length() == 1) return false;
//        if(s.length() == 0) return true;
//
//        char[] array = s.toCharArray();
//
//        int index = isEmptyPart(array, 0, s.length()-1);
//
//        while(index > -1){
//
//            char firstBrack;
//            if(array[index] == '(') firstBrack = ')';
//            if(array[index] == '[') firstBrack = ']';
//            if(array[index] == '{') firstBrack = '}';
//
//            int indexEnd = indexOfArray(array, index, array.length-1, firstBrack);
//            if(!isCorrectPair(array, index, indexEnd)) return false;
//
//            int indexStart = isEmptyPart(array, 0, s.length()-1);
//        }
//
//        return true;
//    }
//
//
//
//    private boolean isCorrectPair(char[] array, int start, int end){
//
//        // todo find similar brackets
//        if((array[start] == '(' && array[end] != ')' )|| (array[start] == '[' && array[end] != ']' ) || (array[start] == '{' && array[end] != '}' )){
//            char firstBrack;
//            if(array[start] == '(') firstBrack = ')';
//            if(array[start] == '[') firstBrack = ']';
//            if(array[start] == '{') firstBrack = '}';
//            char secondBrack;
//            if(array[start] == '(') secondBrack = ')';
//            if(array[start] == '[') secondBrack = ']';
//            if(array[start] == '{') secondBrack = '}';
//
//            int index = indexOfArray(array, start, end-1, firstBrack);
//
//            if(index < 0) return false;
//
//            if(!isCorrectPair(array, start, index)) return false;
//
//            index = indexOfArray(array, start+1, end-1, secondBrack);
//
//            if (index < 0) return false;
//
//            start = index;
//        }
//
//        if((end-start) %2 != 0) return false;
//
//        if(isEmptyPart(array, start+1, end-1) == -1){
//            array[end] = ' ';
//            array[start] = ' ';
//            return true;
//        }else{
//            return isCorrectPair(array, start+1, end-1);
//        }
//    }
//
//    private int indexOfArray(char[] array, int start, int end, char bracket){
//
//        for(int i = start; i <= end; i++){
//            if(array[i] == bracket) return i;
//        }
//
//        return -1;
//    }
//
//    private int isEmptyPart(char[] array, int start, int end){
//
//        for(int i = start+1; i < end; i++){
//            if(array[i] != ' ') return i;
//
//        }
//
//        return -1;
//    }

}




