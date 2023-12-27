package stacks;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char sym : s.toCharArray()){
            if (sym == '(' || sym == '{' || sym == '['){
                stack.push(sym);
            }else {
                if (stack.isEmpty()) return false;
                switch (sym){
                    case ')':
                        if (stack.pop() != '(') return false;
                        break;
                    case ']':
                        if (stack.pop() != '[') return false;
                        break;
                    case '}':
                        if (stack.pop() != '{') return false;
                        break;
                }
            }
        }

        // Replace this placeholder return statement with your code
        return stack.isEmpty();
    }
}
